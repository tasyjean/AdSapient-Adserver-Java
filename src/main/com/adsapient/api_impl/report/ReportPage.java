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
package com.adsapient.api_impl.report;

import com.adsapient.api.ReportEntity;
import com.adsapient.api.ReportTransformer;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

public class ReportPage {
	private Collection content = new ArrayList();

	private ReportTransformer transformer = null;

	public ReportPage() {
	}

	public Collection getContent() {
		return content;
	}

	public void setTransformer(ReportTransformer transformer) {
		this.transformer = transformer;
	}

	public ReportTransformer getTransformer() {
		return transformer;
	}

	public void add(ReportEntity entity) {
		content.add(entity);
	}

	public void print(HttpServletResponse response) throws IOException {
		if (transformer != null) {
			transformer.transform(this, response);
		}
	}
}