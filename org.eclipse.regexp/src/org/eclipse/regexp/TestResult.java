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

import java.util.List;

import org.eclipse.core.runtime.IStatus;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class TestResult {

	private IStatus status;
	private final List<RegexpResult> results = Lists.newArrayList();

	void addRegexpResult(final RegexpResult regexpResult) {
		results.add(regexpResult);
	}

	public List<RegexpResult> getInputResults() {
		return ImmutableList.copyOf(results);
	}

	void setStatus(final IStatus status) {
		this.status = status;
	}

	public IStatus getStatus() {
		return status;
	}
}
