package model;

import java.io.Serializable;

import test.Dlg;

public abstract class AnyData implements Serializable {
	protected String name;
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}

	public abstract Dlg showDialog(boolean b);
	public abstract Dlg showSonDlialog();
	
}
