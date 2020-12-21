package model;

import test.Dlg;
import test.DlgPlayer;
import test.DlgSport;
import test.DlgCountry;

public class Sport extends AnyData {
	
	private int yearStateOlimpic;
	private boolean comand;
	private boolean water;
		
	 public Sport(String name, int yearStateOlimpic, boolean comand, boolean water) {
		super();
		this.name = name;
		this.yearStateOlimpic = yearStateOlimpic;
		this.comand = comand;
		this.water = water;
	}
	 
	public int getYearStateOlimpic() {
		return yearStateOlimpic;
	}

	public void setYearStateOlimpic(int yearStateOlimpic) {
		this.yearStateOlimpic = yearStateOlimpic;
	}

	public boolean isComand() {
		return comand;
	}

	public void setComand(boolean comand) {
		this.comand = comand;
	}

	public boolean isWater() {
		return water;
	}

	public void setWater(boolean water) {
		this.water = water;
	}

	public Dlg showDialog(boolean b) {
		// TODO Auto-generated method stub
		DlgSport d = new DlgSport(this);
		d.setEditable(b);
		d.setVisible(true);
		return d;
	}
	
	 public Dlg showSonDlialog() {
		DlgPlayer d = new DlgPlayer();
		d.setVisible(true);
		return d;
	}

}
