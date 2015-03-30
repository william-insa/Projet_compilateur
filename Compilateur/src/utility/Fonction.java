package utility;

import java.util.ArrayList;

public class Fonction {
	
	//Liste des type des param
	private ArrayList<Integer> param;
	//Type du resultat de la fonction
	private int resultat;
	
	//Constructeur (Type de retour)
	public Fonction(int _r) {
		param = new ArrayList<Integer>();
		resultat = _r;
	}
	
	//Ajoute un Param a la liste
	public void addParam(int _p) { this.param.add(_p); }
	
	public int getNbP() { return this.param.size(); }
	public int getRetour() { return this.resultat; }
	public ArrayList<Integer> getList() { return this.param; }
	
	//Verification du nombre de param
	public void testNbP(int _n, String id) {
		if(_n != getNbP())
			System.out.println("Nombre de paramètres incorrect pour "+id);
	}
}
