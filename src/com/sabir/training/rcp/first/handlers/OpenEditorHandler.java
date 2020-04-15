package com.sabir.training.rcp.first.handlers;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import com.sabir.training.rcp.first.editor.FirstEditor;
import com.sabir.training.rcp.first.editor.input.PersonInput;

public class OpenEditorHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		PersonInput input = new PersonInput();
		input.setName("HELLO SABIR");
		try {
			HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().openEditor(input, FirstEditor.ID);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
