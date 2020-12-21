package test;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import model.Country;
import javax.swing.UIManager;
import java.awt.Color;

public class DlgCountry extends Dlg {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldPartic;
	private JTextField textFieldGold;
	private JTextField textFieldSilver;
	private JTextField textFieldBronze;
	public DlgCountry() {
		
		textFieldName.setBounds(12, 13, 116, 34);
		contentPanel.setLayout(null);
		
		textFieldPartic = new JTextField();
		textFieldPartic.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Count partic", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textFieldPartic.setBounds(12, 60, 116, 34);
		contentPanel.add(textFieldPartic);
		textFieldPartic.setColumns(10);
		
		textFieldGold = new JTextField();
		textFieldGold.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Count gold medal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textFieldGold.setBounds(12, 106, 136, 34);
		contentPanel.add(textFieldGold);
		textFieldGold.setColumns(10);
		
		textFieldSilver = new JTextField();
		textFieldSilver.setColumns(10);
		textFieldSilver.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Count silver medal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textFieldSilver.setBounds(12, 153, 136, 34);
		contentPanel.add(textFieldSilver);
		
		textFieldBronze = new JTextField();
		textFieldBronze.setColumns(10);
		textFieldBronze.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Count bronze medal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textFieldBronze.setBounds(12, 200, 136, 34);
		contentPanel.add(textFieldBronze);
	}

	public DlgCountry(Object data) {
		this();
		Country coun = (Country) data;
		textFieldName.setText(coun.getName());
		textFieldPartic.setText(String.valueOf(coun.getCountPartic()));
		textFieldGold.setText(String.valueOf(coun.getCountGold()));
		textFieldSilver.setText(String.valueOf(coun.getCountSilver()));
		textFieldBronze.setText(String.valueOf(coun.getCountBronze()));
	}
	
	@Override
	public Object createObject() throws Exception {
		if(!ok) return null;
		String name = textFieldName.getText();
		int partic = Integer.parseInt((textFieldPartic.getText()));
		int gold = Integer.parseInt((textFieldPartic.getText()));
		int silver = Integer.parseInt((textFieldPartic.getText()));
		int bronze = 	Integer.parseInt((textFieldPartic.getText()));
		return new Country(name, partic, gold, silver, bronze);
	}

	@Override
	public Dlg showDialog(boolean b) {
		DlgCountry d = new DlgCountry(this);
		d.setEditable(b);
		d.setVisible(true);
		return d;
	}

	@Override
	public Dlg showSonDialog() {
		DlgSport d = new DlgSport();
		d.setVisible(true);
		return d;
	}

}
