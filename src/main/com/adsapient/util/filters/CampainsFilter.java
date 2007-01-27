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
package com.adsapient.util.filters;

import com.adsapient.api.FilterInterface;

import com.adsapient.api_impl.advertizer.CampainImpl;
import com.adsapient.api_impl.filter.factory.CampainFilters;
import com.adsapient.api_impl.publisher.PlacesImpl;

import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class CampainsFilter {
	static Logger logger = Logger.getLogger(CampainsFilter.class);

	public static CampainImpl doFiliter(CampainImpl campain,
			HttpServletRequest request, PlacesImpl places,
			Collection bannersCollectin) {
		if (campain == null) {
			return null;
		}

		if (!campain.isContainRelevantSizeBanner(places, bannersCollectin)) {
			return null;
		}

		if (applyFilters(request, campain)) {
			return campain;
		} else {
			return null;
		}
	}

	private static boolean applyFilters(HttpServletRequest request,
			CampainImpl campain) {
		CampainFilters filters = null;

		Iterator filtersIterator = filters.getFiltersMap().entrySet()
				.iterator();

		while (filtersIterator.hasNext()) {
			Map.Entry entry = (Map.Entry) filtersIterator.next();

			FilterInterface filter = (FilterInterface) entry.getValue();

			if (!filter.doFilter(request)) {
				return false;
			}
		}

		logger.debug("Camapin with id=" + campain.getCampainId()
				+ " do filter check");

		return true;
	}
}