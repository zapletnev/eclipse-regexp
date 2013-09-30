package org.eclipse.regexp.ui.view;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.regexp.ui.RegexpUIConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PreferencesUtil;

public class RegexpPreferencesHandler extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		PreferenceDialog pref = PreferencesUtil.createPreferenceDialogOn(
				PlatformUI.getWorkbench().getDisplay().getActiveShell(),
				RegexpUIConstants.PREF_PAGE, null, null);
		pref.open();
		return null;
	}
}
