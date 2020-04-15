package com.sabir.training.rcp.first.editor;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import com.sabir.training.rcp.first.editor.input.PersonInput;

public class FirstEditor extends EditorPart {

	public static String ID = "com.sabir.training.rcp.first.editor.ID";
	private boolean dirty;
	private Text text;
	
	public FirstEditor() {
		System.out.println("FirstEditor.FirstEditor()");
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		
		dirty = false;
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub
		dirty = false;
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		setSite(site);
		setInput(input);
	}

	@Override
	public boolean isDirty() {
		return dirty;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	@Override
	public void createPartControl(Composite parent) {
		System.out.println("FirstEditor.createPartControl()");
		text = new Text(parent,SWT.NONE);
		text.setText(((PersonInput)getEditorInput()).getName());
		text.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				dirty = true;
				firePropertyChange(PROP_DIRTY);
				
			}
		});

	}

	@Override
	public void setFocus() {
		text.setFocus();
	}

}
