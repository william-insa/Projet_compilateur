package utility;

import java.util.ArrayList;

public class Fonction {
	private ArrayList<Integer> param;
	private int resultat;
	
	public Fonction(int _r) {
		param = new ArrayList<Integer>();
		resultat = _r;
	}
	
	public void addParam(int _p) { this.param.add(_p); }
	
	public int getNbP() { return this.param.size(); }
}
