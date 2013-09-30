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
package org.eclipse.regexp.ui.common;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Widget;

public class ControlUtils {

	public static final int WIDGET_DELAY = 400;

	public static IObservableValue observeText(final Widget widget) {
		return WidgetProperties.text(SWT.Modify).observeDelayed(WIDGET_DELAY,
				widget);
	}

	public static void refreshScroll(final Composite composite) {
		Composite parent = composite;
		while (parent != null) {
			if (parent.getParent() instanceof ScrolledComposite) {
				((ScrolledComposite) parent.getParent()).setMinSize(parent
						.computeSize(SWT.DEFAULT, SWT.DEFAULT));
				parent.getParent().layout(true, true);
				break;
			}
			parent = parent.getParent();
		}
	}

}
