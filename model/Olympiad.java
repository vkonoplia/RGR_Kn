package model;

import test.Dlg;
import test.DlgOlympiad;
import test.DlgCountry;

public class Olympiad extends AnyData {
	private int year;
	private String country;
	private int countCountryMem;
	
	public Olympiad(String name, int year, String country, int countCountryMem) {
		super();
		this.name = name;
		this.year = year;
		this.country = country;
		this.countCountryMem = countCountryMem;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getCountCountryMem() {
		return countCountryMem;
	}
	public void setCountCountryMem(int countCountryMem) {
		this.countCountryMem = countCountryMem;
	}
	@Override
	public Dlg showDialog(boolean b) {
		// TODO Auto-generated method stub
		DlgOlympiad d = new DlgOlympiad(this);
		d.setEditable(b);
		d.setVisible(true);
		return d;
	}
	@Override
	public Dlg showSonDlialog() {
		DlgCountry d = new DlgCountry();
		d.setVisible(true);
		return d;
	}
}
