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

import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.common.collect.Maps;

public class RegexpUIPlugin extends AbstractUIPlugin implements
		RegexpUIConstants {

	public static Map<String, Integer> FLAGS = Maps.newHashMap();

	static {
		FLAGS.put(CANON_EQ, Pattern.CANON_EQ);
		FLAGS.put(CASE_INSENSITIVE, Pattern.CASE_INSENSITIVE);
		FLAGS.put(COMMENTS, Pattern.COMMENTS);
		FLAGS.put(DOTALL, Pattern.DOTALL);
		FLAGS.put(LITERAL, Pattern.LITERAL);
		FLAGS.put(MULTILINE, Pattern.MULTILINE);
		FLAGS.put(UNICODE_CASE, Pattern.UNICODE_CASE);
		FLAGS.put(UNIX_LINES, Pattern.UNIX_LINES);
	}

	private static RegexpUIPlugin instance;

	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		instance = this;
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		instance = null;
		super.stop(context);
	}

	public static RegexpUIPlugin getDefault() {
		return instance;
	}

	public int getFlags() {
		int flags = 0;
		IPreferenceStore prefStore = getPreferenceStore();
		for (String key : FLAGS.keySet()) {
			if (prefStore.getBoolean(key)) {
				flags |= FLAGS.get(key);
			}
		}
		return flags;
	}
}
