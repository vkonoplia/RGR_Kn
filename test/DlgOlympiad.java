package test;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import model.Olympiad;
import javax.swing.UIManager;
import java.awt.Color;

public class DlgOlympiad extends Dlg {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldCount;
	private JTextField textFieldCountry;
	private JTextField textFieldYear;
	public DlgOlympiad() {
		textFieldCount.setBounds(12, 13, 116, 34);
		setBounds(300, 300, 213, 270);
		contentPanel.setLayout(null);
		
		textFieldCount = new JTextField();
		textFieldCount.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Count country member", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textFieldCount.setBounds(12, 12, 171, 43);
		contentPanel.add(textFieldCount);
		textFieldCount.setColumns(10);
		
		textFieldCountry = new JTextField();
		textFieldCountry.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Country", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textFieldCountry.setBounds(12, 68, 116, 43);
		contentPanel.add(textFieldCountry);
		textFieldCountry.setColumns(10);
		
		textFieldYear = new JTextField();
		textFieldYear.setColumns(10);
		textFieldYear.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Year", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textFieldYear.setBounds(12, 124, 116, 43);
		contentPanel.add(textFieldYear);
	}
	
	public DlgOlympiad(Object data) {
		this();
		Olympiad coun = (Olympiad) data;
		textFieldName.setText(coun.getName());
		textFieldCount.setText(String.valueOf(coun.getCountCountryMem()));
		textFieldCountry.setText(coun.getCountry());
		textFieldYear.setText(String.valueOf(coun.getYear()));
	}
	
	@Override
	public Object createObject() throws Exception {
		if(!ok) return null;
		String name = textFieldName.getText();
		int count =Integer.parseInt(textFieldCount.getText());
		String country = textFieldCountry.getText();
		int year = Integer.parseInt(textFieldYear.getText());
		return new Olympiad(name, year, country, count);
	}

	@Override
	public Dlg showDialog(boolean b) {
		DlgOlympiad d = new DlgOlympiad(this);
		d.setEditable(b);
		d.setVisible(true);
		return d;
	}

	@Override
	public Dlg showSonDialog() {
		DlgCountry d = new DlgCountry();
		d.setVisible(true);
		return d;
	}
}
