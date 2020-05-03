package com.jf.mzzc.parts;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.jf.mzzc.dialog.CreateModuleDialog;

public class CodePart {

	private Button btnCreateModule, btnSelectEntity;

	@Inject
	private Shell shell;
	
	public CodePart() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		btnCreateModule = new Button(parent, SWT.NONE);
		btnCreateModule.setLayoutData(new GridData(SWT.CENTER, SWT.BOTTOM, true, true, 1, 1));
		btnCreateModule.setText("Create Module");

		btnSelectEntity = new Button(parent, SWT.NONE);
		btnSelectEntity.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, true, true, 1, 1));
		btnSelectEntity.setText("Select Entity");

		btnCreateModule.addListener(SWT.Selection, e -> {
			
			CreateModuleDialog moduleDialog = new CreateModuleDialog(shell);
			if (moduleDialog.open() == Window.OK) {
				System.err.println(moduleDialog.getModule().toString());
			}
			
		});

		btnSelectEntity.addListener(SWT.Selection, e -> {

			
			
		});
	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
		// TODO Set the focus to control
	}

}
