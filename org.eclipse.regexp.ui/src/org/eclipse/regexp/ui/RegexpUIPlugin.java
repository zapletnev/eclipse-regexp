package org.eclipse.regexp.ui;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class RegexpUIPlugin extends AbstractUIPlugin {
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
		for (String key : RegexpUIConstants.FLAGS.keySet()) {
			if (prefStore.getBoolean(key)) {
				flags |= RegexpUIConstants.FLAGS.get(key);
			}
		}
		return flags;
	}
}
