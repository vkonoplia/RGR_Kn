package test;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public abstract class Dlg extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final JPanel contentPanel = new JPanel();
	protected JTextField textFieldName;
	protected JButton okButton;
	protected JButton cancelButton;
	protected boolean ok;


	/**
	 * Create the dialog.
	 */
	public Dlg() {
		
		setModal(true);
		setBounds(100, 100, 253, 347);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textFieldName = new JTextField();
		textFieldName.setBorder(new TitledBorder(null, "Name", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		contentPanel.add(textFieldName);
		textFieldName.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ok = true;
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ok = false;
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public abstract Object createObject() throws Exception;
	
	public void setEditable(boolean b) {
		okButton.setVisible(b);
		if(b)
			cancelButton.setText("Cancel");
		else 
			cancelButton.setText("Exit");
		for(Component c: contentPanel.getComponents()) {
			c.setEnabled(b);
		}
	}
	
	abstract public Dlg showDialog(boolean b);
			
	abstract public Dlg showSonDialog();
	
	public JButton getOkButton() {
		return okButton;
	}
	public JButton getCancelButton() {
		return cancelButton;
	}
}
