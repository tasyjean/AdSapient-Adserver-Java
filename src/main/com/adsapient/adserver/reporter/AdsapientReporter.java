/*
 * AdSapient - Open Source Ad Server
 * http://www.sourceforge.net/projects/adsapient
 * http://www.adsapient.com
 *
 * Copyright (C) 2001-06 Vitaly Sazanovich
 * Vitaly.Sazanovich@gmail.com
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Library General Public License  as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 *
 */
package com.adsapient.adserver.reporter;

import com.adsapient.adserver.beans.EventObjectImpl;
import com.adsapient.adserver.beans.ReporterModel;
import com.adsapient.adserver.beans.SpecificEventsObjectImpl;
import com.adsapient.adserver.beans.VisitorObjectImpl;

import com.adsapient.api_impl.advertizer.BannerImpl;
import com.adsapient.api_impl.publisher.PlacesImpl;

import com.adsapient.shared.api.entity.IEventObject;
import com.adsapient.shared.api.entity.ISpecificEventsObject;

import com.adsapient.util.admin.AdsapientConstants;

import com.sleepycat.bind.tuple.TupleBinding;
import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleOutput;

import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.SecondaryConfig;
import com.sleepycat.je.SecondaryDatabase;
import com.sleepycat.je.SecondaryKeyCreator;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AdsapientReporter {
	static Logger logger = Logger.getLogger(AdsapientReporter.class);

	private Database uniqueVisitorsDb;

	private SecondaryDatabase uniqueVisitorIndexDb;

	private UniqueVisitorKeyCreator uniqueVisitorKeyCreator;

	private DatabaseConfig uniqueVisitorsDbConfig;

	private EnvironmentConfig uniqueVisitorsDbEnvConfig;

	private SecondaryConfig uniqueVisitorIndexDbConfig;

	private Environment environment;

	private String databasesHome;

	private String uniquevisitorsdbName;

	private String uniqueVisitorIndexDbName;

	private String datePattern = "yyMMddHH";

	private SimpleDateFormat dateFormat;

	private UniqueVisitorBinding binding;

	private Random random;

	public AdsapientReporter() {
	}

	public void setup() throws DatabaseException {
		try {
			dateFormat = new SimpleDateFormat(datePattern);
			binding = new UniqueVisitorBinding();
			binding.setSimpleDateFormat(dateFormat);
			random = new Random();

			uniqueVisitorsDbEnvConfig = new EnvironmentConfig();
			uniqueVisitorsDbConfig = new DatabaseConfig();
			uniqueVisitorIndexDbConfig = new SecondaryConfig();

			uniqueVisitorKeyCreator = new UniqueVisitorKeyCreator(binding);

			uniqueVisitorsDbEnvConfig.setTransactional(false);
			uniqueVisitorsDbEnvConfig.setAllowCreate(true);

			uniqueVisitorsDbConfig.setAllowCreate(true);
			uniqueVisitorsDbConfig.setTransactional(false);
			uniqueVisitorsDbConfig.setSortedDuplicates(false);

			uniqueVisitorIndexDbConfig.setAllowCreate(true);
			uniqueVisitorIndexDbConfig.setAllowPopulate(true);
			uniqueVisitorIndexDbConfig.setSortedDuplicates(false);
			uniqueVisitorIndexDbConfig.setTransactional(false);

			uniqueVisitorIndexDbConfig.setKeyCreator(uniqueVisitorKeyCreator);

			File f = new File(databasesHome);
			f.mkdirs();
			logger.debug(f.canWrite());

			environment = new Environment(f, uniqueVisitorsDbEnvConfig);

			uniqueVisitorsDb = environment.openDatabase(null,
					uniquevisitorsdbName, uniqueVisitorsDbConfig);

			uniqueVisitorIndexDb = environment.openSecondaryDatabase(null,
					uniqueVisitorIndexDbName, uniqueVisitorsDb,
					uniqueVisitorIndexDbConfig);
		} catch (Exception ex) {
			logger.fatal(ex.getMessage(), ex);
		}
	}

	public void close() {
		try {
			if (uniqueVisitorsDb != null) {
				uniqueVisitorsDb.close();
			}
		} catch (DatabaseException dbe) {
			logger.fatal(dbe.getMessage(), dbe);
		}
	}

	public Database getUniqueVisitorsDb() {
		return uniqueVisitorsDb;
	}

	public void setUniqueVisitorsDb(Database uniqueVisitorsDb) {
		this.uniqueVisitorsDb = uniqueVisitorsDb;
	}

	public String getUniquevisitorsdbName() {
		return uniquevisitorsdbName;
	}

	public void setUniquevisitorsdbName(String uniquevisitorsdbName) {
		this.uniquevisitorsdbName = uniquevisitorsdbName;
	}

	public String getDatabasesHome() {
		return databasesHome;
	}

	public void setDatabasesHome(String databasesHome) {
		this.databasesHome = databasesHome;
	}

	public Integer saveOrUpdateUniqueVisitor(Map<String, Object> requestParams,
			byte eventType) {
		try {
			VisitorObjectImpl visitorObject = getVisitorObject(requestParams);

			if (visitorObject == null) {
				Integer id = saveVisitorObject(requestParams);

				if (id == null) {
					return null;
				}

				visitorObject = getVisitorObjectById(id);
				visitorObject.setId(id);
			}

			Integer id = visitorObject.getId();

			if (id == null) {
				id = (Integer) requestParams
						.get(AdsapientConstants.COOKIE_UNIQUE_ID_REQUEST_PARAM_KEY);
			}

			updateVisitorObject(id, visitorObject, requestParams, eventType);

			return id;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);

			return null;
		}
	}

	private void updateVisitorObject(Integer id,
			VisitorObjectImpl visitorObject, Map<String, Object> requestParams,
			byte eventType) throws ParseException, IOException,
			DatabaseException {
		Date currentTimeWithHourlyPrecision = dateFormat.parse(dateFormat
				.format(new Date()));
		Map<String, IEventObject> entityCompositeKeyToEventsMap = visitorObject
				.getEntityCompositeKeyToEventsMap();

		if (entityCompositeKeyToEventsMap == null) {
			entityCompositeKeyToEventsMap = new HashMap<String, IEventObject>();
			visitorObject
					.setEntityCompositeKeyToEventsMap(entityCompositeKeyToEventsMap);
		}

		BannerImpl banner = (BannerImpl) requestParams
				.get(AdsapientConstants.BANNER_REQUEST_PARAM_KEY);
		String compositeBannerEntityKey = banner.getBannerId()
				+ AdsapientConstants.BANNER_ENTITY_ID;
		EventObjectImpl eventObject = (EventObjectImpl) entityCompositeKeyToEventsMap
				.get(compositeBannerEntityKey);

		if (eventObject == null) {
			eventObject = new EventObjectImpl();
			entityCompositeKeyToEventsMap.put(compositeBannerEntityKey,
					eventObject);
		}

		Map<Byte, ISpecificEventsObject> adEventTypeToSpecificEventsObjectMap = eventObject
				.getAdEventTypeToSpecificEventsObjectMap();

		if (adEventTypeToSpecificEventsObjectMap == null) {
			adEventTypeToSpecificEventsObjectMap = new HashMap<Byte, ISpecificEventsObject>();
			eventObject
					.setAdEventTypeToSpecificEventsObjectMap(adEventTypeToSpecificEventsObjectMap);
		}

		SpecificEventsObjectImpl specificEventsObject = (SpecificEventsObjectImpl) adEventTypeToSpecificEventsObjectMap
				.get(eventType);

		if (specificEventsObject == null) {
			specificEventsObject = new SpecificEventsObjectImpl();
			specificEventsObject.setEventType(eventType);
			adEventTypeToSpecificEventsObjectMap.put(eventType,
					specificEventsObject);
		}

		Map<Date, Integer> dateToCountMap = specificEventsObject
				.getDateToCountMap();

		if (dateToCountMap == null) {
			dateToCountMap = new HashMap<Date, Integer>();
			specificEventsObject.setDateToCountMap(dateToCountMap);
		}

		Integer count = dateToCountMap.get(currentTimeWithHourlyPrecision);

		if (count == null) {
			dateToCountMap.put(currentTimeWithHourlyPrecision, 1);
		} else {
			++count;
			dateToCountMap.put(currentTimeWithHourlyPrecision, count);
		}

		PlacesImpl place = (PlacesImpl) requestParams
				.get(AdsapientConstants.ADPLACE_REQUEST_PARAM_KEY);
		String compositePlaceEntityKey = place.getId()
				+ AdsapientConstants.ADPLACE_ENTITY_ID;
		eventObject = (EventObjectImpl) entityCompositeKeyToEventsMap
				.get(compositePlaceEntityKey);

		if (eventObject == null) {
			eventObject = new EventObjectImpl();
			entityCompositeKeyToEventsMap.put(compositePlaceEntityKey,
					eventObject);
		}

		adEventTypeToSpecificEventsObjectMap = eventObject
				.getAdEventTypeToSpecificEventsObjectMap();

		if (adEventTypeToSpecificEventsObjectMap == null) {
			adEventTypeToSpecificEventsObjectMap = new HashMap<Byte, ISpecificEventsObject>();
			eventObject
					.setAdEventTypeToSpecificEventsObjectMap(adEventTypeToSpecificEventsObjectMap);
		}

		specificEventsObject = (SpecificEventsObjectImpl) adEventTypeToSpecificEventsObjectMap
				.get(eventType);

		if (specificEventsObject == null) {
			specificEventsObject = new SpecificEventsObjectImpl();
			specificEventsObject.setEventType(eventType);
			adEventTypeToSpecificEventsObjectMap.put(eventType,
					specificEventsObject);
		}

		dateToCountMap = specificEventsObject.getDateToCountMap();

		if (dateToCountMap == null) {
			dateToCountMap = new HashMap<Date, Integer>();
			specificEventsObject.setDateToCountMap(dateToCountMap);
		}

		count = dateToCountMap.get(currentTimeWithHourlyPrecision);

		if (count == null) {
			dateToCountMap.put(currentTimeWithHourlyPrecision, 1);
		} else {
			++count;
			dateToCountMap.put(currentTimeWithHourlyPrecision, count);
		}

		DatabaseEntry theKey = new DatabaseEntry(ReporterModel
				.intToByteArray(id));
		DatabaseEntry theData = new DatabaseEntry(new byte[] {});
		TupleOutput to = new TupleOutput(theData.getData());
		binding.objectToEntry(visitorObject, to);
		theData.setData(to.toByteArray());
		uniqueVisitorsDb.put(null, theKey, theData);
	}

	private Integer saveVisitorObject(Map<String, Object> requestParams) {
		try {
			Integer id = random.nextInt();

			while (getVisitorObjectById(id) != null) {
				id = random.nextInt();
			}

			String ipAddress = (String) requestParams
					.get(AdsapientConstants.IPADDRESS_UNIQUE_ID_REQUEST_PARAM_KEY);
			VisitorObjectImpl visitorObject = new VisitorObjectImpl();
			visitorObject.setIpAddress(ipAddress);

			DatabaseEntry theKey = new DatabaseEntry(ReporterModel
					.intToByteArray(id));
			DatabaseEntry theData = new DatabaseEntry(new byte[] {});
			TupleOutput to = new TupleOutput(theData.getData());
			binding.objectToEntry(visitorObject, to);

			theData.setData(to.toByteArray());
			uniqueVisitorsDb.put(null, theKey, theData);

			return id;
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);

			return ((requestParams
					.get(AdsapientConstants.COOKIE_UNIQUE_ID_REQUEST_PARAM_KEY) == null) ? null
					: (Integer) requestParams
							.get(AdsapientConstants.COOKIE_UNIQUE_ID_REQUEST_PARAM_KEY));
		}
	}

	public VisitorObjectImpl getVisitorObject(Map<String, Object> requestParams) {
		try {
			Integer id = (Integer) requestParams
					.get(AdsapientConstants.COOKIE_UNIQUE_ID_REQUEST_PARAM_KEY);

			if (id == null) {
				String ipAddress = (String) requestParams
						.get(AdsapientConstants.IPADDRESS_UNIQUE_ID_REQUEST_PARAM_KEY);
				DatabaseEntry searchKey = new DatabaseEntry(ipAddress
						.getBytes("UTF-8"));
				DatabaseEntry primaryKey = new DatabaseEntry();
				DatabaseEntry primaryData = new DatabaseEntry();
				OperationStatus retVal = uniqueVisitorIndexDb.get(null,
						searchKey, primaryKey, primaryData, LockMode.DEFAULT);

				if (retVal.equals(OperationStatus.NOTFOUND)) {
					return null;
				} else {
					id = ReporterModel.arr2int(primaryKey.getData(), 0);

					VisitorObjectImpl visitorObject = (VisitorObjectImpl) binding
							.entryToObject(new TupleInput(primaryData.getData()));
					visitorObject.setId(id);

					return visitorObject;
				}
			} else {
				DatabaseEntry theKey = new DatabaseEntry(ReporterModel
						.intToByteArray(id));
				DatabaseEntry theData = new DatabaseEntry();

				if (uniqueVisitorsDb.get(null, theKey, theData,
						LockMode.DEFAULT) == OperationStatus.SUCCESS) {
					return (VisitorObjectImpl) binding
							.entryToObject(new TupleInput(theData.getData()));
				} else {
					requestParams
							.put(
									AdsapientConstants.COOKIE_UNIQUE_ID_REQUEST_PARAM_KEY,
									null);
					logger.error("Couldn't find visitor object for id: " + id
							+ ", which came with a cookie.");

					return getVisitorObject(requestParams);
				}
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);

			return null;
		}
	}

	private VisitorObjectImpl getVisitorObjectById(Integer id) {
		try {
			DatabaseEntry theKey = new DatabaseEntry(ReporterModel
					.intToByteArray(id));
			DatabaseEntry theData = new DatabaseEntry();

			if (uniqueVisitorsDb.get(null, theKey, theData, LockMode.DEFAULT) == OperationStatus.SUCCESS) {
				return (VisitorObjectImpl) binding
						.entryToObject(new TupleInput(theData.getData()));
			}

			return null;
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);

			return null;
		}
	}

	public String getUniqueVisitorIndexDbName() {
		return uniqueVisitorIndexDbName;
	}

	public void setUniqueVisitorIndexDbName(String uniqueVisitorIndexDbName) {
		this.uniqueVisitorIndexDbName = uniqueVisitorIndexDbName;
	}

	private class UniqueVisitorKeyCreator implements SecondaryKeyCreator {
		private TupleBinding theBinding;

		public UniqueVisitorKeyCreator(TupleBinding theBinding1) {
			theBinding = theBinding1;
		}

		public boolean createSecondaryKey(SecondaryDatabase secondaryDatabase,
				DatabaseEntry keyEntry, DatabaseEntry dataEntry,
				DatabaseEntry resultEntry) throws DatabaseException {
			try {
				VisitorObjectImpl visitor = (VisitorObjectImpl) theBinding
						.entryToObject(new TupleInput(dataEntry.getData()));
				String key = visitor.getIpAddress();
				resultEntry.setData((key != null) ? key.getBytes("UTF-8")
						: new byte[] {});
			} catch (UnsupportedEncodingException e) {
				logger.error(e.getMessage(), e);
			}

			return true;
		}
	}
}