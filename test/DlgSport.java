package test;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import model.Sport;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JCheckBox;

public class DlgSport extends Dlg {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldYear;
	private JCheckBox chckbxComand;
	private JCheckBox chckbxWater;
	public DlgSport() {
		
		textFieldYear = new JTextField();
		textFieldYear.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Year state olimpic", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textFieldYear.setBounds(12, 60, 116, 34);
		contentPanel.add(textFieldYear);
		textFieldYear.setColumns(10);
		
		chckbxComand = new JCheckBox("Comand");
		contentPanel.add(chckbxComand);
		
		chckbxWater = new JCheckBox("Water");
		contentPanel.add(chckbxWater);
	}

	@SuppressWarnings("deprecation")
	public DlgSport(Object data) {
		this();
		Sport coun = (Sport) data;
		textFieldName.setText(coun.getName());
		textFieldYear.setText(String.valueOf(coun.getYearStateOlimpic()));
		chckbxComand.setSelected(coun.isComand());
		chckbxWater.setSelected(coun.isWater());
	}
	
	@Override
	public Object createObject() throws Exception {
		if(!ok) return null;
		String name = textFieldName.getText();
		int year = Integer.parseInt((textFieldYear.getText()));
		boolean comand = chckbxComand.isEnabled();
		boolean water = chckbxWater.isEnabled();
		return new Sport(name, year, comand, water);
	}

	@Override
	public Dlg showDialog(boolean b) {
		DlgSport d = new DlgSport(this);
		d.setEditable(b);
		d.setVisible(true);
		return d;
	}

	@Override
	public Dlg showSonDialog() {
		DlgPlayer d = new DlgPlayer();
		d.setVisible(true);
		return d;
	}
	
	public JCheckBox getChckbxComand() {
		return chckbxComand;
	}
	public JCheckBox getChckbxWater() {
		return chckbxWater;
	}
}
