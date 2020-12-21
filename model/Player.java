package model;

import test.Dlg;
import test.DlgPlayer;

public class Player extends AnyData {
	private int yearBirth;
	private int countAward;
	
	
	public Player(String name, int yearBirth, int countAward) {
		super();
		this.name = name;
		this.yearBirth = yearBirth;
		this.countAward = countAward;
	}

	public int getYearBirth() {
		return yearBirth;
	}

	public void setYearBirth(int yearBirth) {
		this.yearBirth = yearBirth;
	}

	public int getCountAward() {
		return countAward;
	}

	public void setCountAward(int countAward) {
		this.countAward = countAward;
	}

	public Dlg showDialog(boolean b) {
		// TODO Auto-generated method stub
		DlgPlayer d = new DlgPlayer(this);
		d.setEditable(b);
		d.setVisible(true);
		return d;
	}
	
	public Dlg showSonDlialog() {
		return null;
	}
}
