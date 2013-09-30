/*******************************************import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.regexp.ui.RegexpUIConstants;
import org.eclipse.regexp.ui.RegexpUIPlugin;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
utors:
 *     Igor Zapletnev - initial API and Implementation
 *******************************************************************************/
package org.eclipse.regexp.ui.view.prefs;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.regexp.ui.RegexpUIConstants;
import org.eclipse.regexp.ui.RegexpUIPlugin;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class RegexpPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	@Override
	public void init(final IWorkbench workbench) {
		setPreferenceStore(RegexpUIPlugin.getDefault().getPreferenceStore());
	}

	@Override
	protected void createFieldEditors() {
		Composite composite = getFieldEditorParent();
		addField(new BooleanFieldEditor(RegexpUIConstants.CANON_EQ,
				"Force canonical equivalence (CANON_EQ)", composite));
		addField(new BooleanFieldEditor(RegexpUIConstants.CASE_INSENSITIVE,
				"Case insensitive (CASE_INSENSITIVE)", composite));
		addField(new BooleanFieldEditor(RegexpUIConstants.COMMENTS,
				"Allow comments (COMMENTS)", composite));
		addField(new BooleanFieldEditor(RegexpUIConstants.DOTALL,
				"Dot matches line terminator (DOTALL)", composite));
		addField(new BooleanFieldEditor(RegexpUIConstants.LITERAL,
				"Treat as a sequence of literal characters (LITERAL)",
				composite));
		addField(new BooleanFieldEditor(RegexpUIConstants.MULTILINE,
				"^ and $ match EOL (MULTILINE)", composite));
		addField(new BooleanFieldEditor(RegexpUIConstants.UNICODE_CASE,
				"Unicode case matching (UNICODE_CASE)", composite));
		addField(new BooleanFieldEditor(RegexpUIConstants.UNIX_LINES,
				"Only consider '\\n' as line terminator (UNIX_LINES)",
				composite));
	}

}
