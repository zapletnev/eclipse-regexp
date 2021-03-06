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
package org.eclipse.regexp;

import static org.eclipse.regexp.RegexpConstanstants.PLUGIN_ID;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class RegexpEngine {

	public TestResult test(final String regexp, final String replacement,
			final String[] strings, final int flags) {
		TestResult result = new TestResult();

		Pattern pattern = null;
		try {
			pattern = Pattern.compile(regexp, flags);
		} catch (PatternSyntaxException ex1) {
			result.setStatus(new Status(IStatus.ERROR, PLUGIN_ID,
					"Could not compile pattern: " + regexp, ex1));
		} catch (IllegalArgumentException ex2) {
			result.setStatus(new Status(IStatus.ERROR, PLUGIN_ID,
					"Could not compile pattern " + regexp, ex2));
		}

		if (pattern == null)
			return result;

		for (int i = 0; i < strings.length; i++) {
			String input = strings[i];
			if (input == null || input.isEmpty())
				continue;

			Matcher matcher = pattern.matcher(input);

			List<RegexpResult.Group> groups = new ArrayList<RegexpResult.Group>();
			while (matcher.find()) {
				groups.add(new RegexpResult.Group(matcher.start(), matcher
						.end(), matcher.group()));
			}

			RegexpResult regexpResult = new RegexpResult(i, input, replacement,
					matcher.matches(),
					replacement != null ? matcher.replaceFirst(replacement)
							: null,
					replacement != null ? matcher.replaceAll(replacement)
							: null, matcher.lookingAt(), groups);

			result.addRegexpResult(regexpResult);

		}
		return result;
	}
}
