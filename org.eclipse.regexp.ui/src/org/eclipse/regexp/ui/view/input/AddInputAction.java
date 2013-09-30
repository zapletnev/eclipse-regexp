package org.eclipse.regexp.ui.view.input;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class AddInputAction extends Action {

	private final InputSection section;

	public AddInputAction(final InputSection section) {
		super("More input", PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJ_ADD));
		this.section = section;
	}

	@Override
	public void run() {
		section.addInput();
	}
}
