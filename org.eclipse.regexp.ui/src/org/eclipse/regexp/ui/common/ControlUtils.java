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
