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

import java.util.ArrayList;
import java.util.List;

public class RegexpResult {

	public static class Group {
		public final int start;
		public final int end;
		public final String group;

		public Group(final int start, final int end, final String group) {
			this.start = start;
			this.end = end;
			this.group = group;
		}
	}

	public final int index;
	public final String input;
	public final String replacement;
	public final boolean mathes;
	public final String replaceFirst;
	public final String replaceAll;
	public final boolean lookingAt;
	public final boolean find;

	public final List<Group> groups;

	public RegexpResult(final int index, final String input,
			final String replacement, final boolean mathes,
			final String replaceFirst, final String replaceAll,
			final boolean lookingAt, final List<Group> groups) {
		this.index = index;
		this.input = input;
		this.replacement = replacement;
		this.mathes = mathes;
		this.replaceFirst = replaceFirst;
		this.replaceAll = replaceAll;
		this.lookingAt = lookingAt;
		this.find = !groups.isEmpty();
		this.groups = new ArrayList<Group>(groups);
	}
}
