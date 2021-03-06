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
package org.eclipse.regexp.ui.view.results;

import org.eclipse.jface.viewers.OwnerDrawLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.regexp.RegexpResult;
import org.eclipse.regexp.RegexpResult.Group;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Event;

public class ResultsLabelProvider extends OwnerDrawLabelProvider {

	private static final int INDEX = 0;
	private static final int INPUT = 1;
	private static final int MATCHES = 2;
	private static final int REPLACEFIRST = 3;
	private static final int REPLACEALL = 4;
	private static final int LOOKINGAT = 5;
	private static final int FIND = 6;
	private static final int GROUPS = 7;

	private static final String EMPTY = "";
	private final TableViewer viewer;

	public ResultsLabelProvider(final TableViewer viewer) {
		this.viewer = viewer;
	}

	private String getLabel(final RegexpResult result, final int index) {
		switch (index) {
		case INDEX:
			return String.valueOf(result.index);
		case INPUT:
			return result.input;
		case MATCHES:
			return boolLabel(result.mathes);
		case REPLACEFIRST:
			return result.replaceFirst;
		case REPLACEALL:
			return result.replaceAll;
		case LOOKINGAT:
			return boolLabel(result.lookingAt);
		case FIND:
			return boolLabel(result.find);
		case GROUPS:
			return groupsLabel(result);
		}
		return EMPTY;
	}

	private String groupsLabel(final RegexpResult result) {
		StringBuilder build = new StringBuilder();
		for (int i = 0; i < result.groups.size(); i++) {
			if (i > 0) {
				build.append("\n");
			}
			Group group = result.groups.get(i);
			build.append(String.format("%d: [%d,%d] %s", i, group.start,
					group.end, group.group));
		}
		return build.toString();
	}

	private String boolLabel(final boolean val) {
		return val ? "Yes" : "No";
	}

	@Override
	protected void measure(final Event event, final Object element) {
		Point size = event.gc.textExtent(getLabel((RegexpResult) element,
				event.index));
		event.width = viewer.getTable().getColumn(event.index).getWidth();
		int lines = size.x / event.width + 1;
		event.height = size.y * lines;
	}

	@Override
	protected void paint(final Event event, final Object element) {
		event.gc.drawText(getLabel((RegexpResult) element, event.index),
				event.x, event.y, true);
	}

}
