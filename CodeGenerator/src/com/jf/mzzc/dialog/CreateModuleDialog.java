package com.jf.mzzc.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.jf.mzzc.param.Module;

public class CreateModuleDialog extends TitleAreaDialog {
	
	private Text pathText;
	private Text moduleNameText;
	private Button btnBrowse;
	private Module module = new Module();
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public CreateModuleDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage("New Module", IMessageProvider.INFORMATION);
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		GridLayout gl_container = new GridLayout(3, false);
		gl_container.verticalSpacing = 10;
		gl_container.horizontalSpacing = 10;
		gl_container.marginWidth = 15;
		gl_container.marginHeight = 15;
		container.setLayout(gl_container);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label lblLocation = new Label(container, SWT.NONE);
		lblLocation.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLocation.setText("Location:");
		
		pathText = new Text(container, SWT.BORDER);
		pathText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		btnBrowse = new Button(container, SWT.NONE);
		btnBrowse.setText("Browse..");
		
		Label lblModuleName = new Label(container, SWT.NONE);
		lblModuleName.setText("Module Name:");
		
		moduleNameText = new Text(container, SWT.BORDER);
		moduleNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(container, SWT.NONE);

		return area;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		pathText.addVerifyListener(new VerifyListener() {
			
			@Override
			public void verifyText(VerifyEvent e) {
				// 验证路径
			}
		});
		
		moduleNameText.addVerifyListener(new VerifyListener() {
			
			@Override
			public void verifyText(VerifyEvent e) {
				// 验证输入模块名
			}
		});
		
	}

	@Override
	public void create() {
		super.create();
		getShell().setText("New Module");
	}
	
	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
	
	@Override
	protected void okPressed() {
		module.setPath(pathText.getText());
		module.setName(moduleNameText.getText());
		super.okPressed();
	}
	
	public Module getModule() {
		return module;
	}

}
