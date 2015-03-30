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
	public int getRetour() { return this.resultat; }
	
	public ArrayList<Integer> getList() { return this.param; }
	
	public void testNbP(int _n, String id) {
		if(_n != getNbP())
			System.out.println("Nombre de paramètres incorrect pour "+id);
	}
}
