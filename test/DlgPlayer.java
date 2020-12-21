package test;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import model.Player;
import javax.swing.UIManager;
import java.awt.Color;

public class DlgPlayer extends Dlg {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldAward;
	private JTextField textFieldYear;
	
	public DlgPlayer() {
		
		textFieldAward = new JTextField();
		textFieldAward.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Count award", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textFieldAward.setBounds(12, 60, 116, 34);
		contentPanel.add(textFieldAward);
		textFieldAward.setColumns(10);
		
		textFieldYear = new JTextField();
		textFieldYear.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Year birth ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textFieldYear.setBounds(12, 107, 116, 34);
		contentPanel.add(textFieldYear);
		textFieldYear.setColumns(10);
	}
	
	public DlgPlayer(Object data) {
		this();
		Player coun = (Player) data;
		textFieldName.setText(coun.getName());
		textFieldAward.setText(String.valueOf(coun.getCountAward()));
		textFieldYear.setText(String.valueOf(coun.getYearBirth()));
	}
	

	@Override
	public Object createObject() throws Exception {
		if(!ok) return null;
		String name = textFieldName.getText();
		int award = Integer.parseInt(textFieldAward.getText());
		int year = Integer.parseInt(textFieldYear.getText());
		return new Player(name, year, award);
	}
	
	@Override
	public Dlg showDialog(boolean b) {
		DlgPlayer d = new DlgPlayer(this);
		d.setEditable(b);
		d.setVisible(true);
		return d;
	}

	@Override
	public Dlg showSonDialog() {
		return null;
	}

}
