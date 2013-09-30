/*******************************************************************************
 * Copyright (c) 2013 Igor Zapletnev
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Igor Zapletnev - initial API and Implementation
 *******************************************************************************/
package org.eclipse.regexp.ui;

public interface RegexpUIConstants {

	public static final String PLUGIN_ID = "org.eclipse.regexp.ui";
	public static final String PREF_PAGE = PLUGIN_ID + ".prefs";

	public static final String ICONS = "icons/";
	public static final String ICONS_TOOLS = ICONS + "etool16/";
	public static final String SETTINGS_ICON = ICONS_TOOLS + "settings16.png";
	public static final String REGEXP_VIEW_ICON = ICONS + "view16.png";

	public static final String CANON_EQ = PLUGIN_ID + ".canon_eq";
	public static final String CASE_INSENSITIVE = PLUGIN_ID
			+ ".case_insensitive";
	public static final String COMMENTS = PLUGIN_ID + ".comments";
	public static final String DOTALL = PLUGIN_ID + ".dotall";
	public static final String LITERAL = PLUGIN_ID + ".literal";
	public static final String MULTILINE = PLUGIN_ID + ".multiline";
	public static final String UNICODE_CASE = PLUGIN_ID + ".unicode_case";
	public static final String UNIX_LINES = PLUGIN_ID + ".unix_lines";
}
