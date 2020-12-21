package model;

import test.Dlg;
import test.DlgOlympiad;
import test.DlgSport;
import test.DlgCountry;

public class Country extends AnyData {
	private int countPartic;
	private int countGold;
	private int countSilver;
	private int countBronze;
	
	public Country(String name, int countPartic, int countGold, int countSilver, int countBronze) {
		super();
		this.name = name;
		this.countPartic = countPartic;
		this.countGold = countGold;
		this.countSilver = countSilver;
		this.countBronze = countBronze;
	}

	public int getCountPartic() {
		return countPartic;
	}

	public void setCountPartic(int countPartic) {
		this.countPartic = countPartic;
	}

	public int getCountGold() {
		return countGold;
	}

	public void setCountGold(int countGold) {
		this.countGold = countGold;
	}

	public int getCountSilver() {
		return countSilver;
	}

	public void setCountSilver(int countSilver) {
		this.countSilver = countSilver;
	}

	public int getCountBronze() {
		return countBronze;
	}

	public void setCountBronze(int countBronze) {
		this.countBronze = countBronze;
	}

	public Dlg showDialog(boolean b) {
		// TODO Auto-generated method stub
		DlgCountry d = new DlgCountry(this);
		d.setEditable(b);
		d.setVisible(true);
		return d;
	}
	
	public Dlg showSonDlialog() {
		DlgSport d = new DlgSport();
		d.setVisible(true);
		return d;
	}


}
