package utility;

import generated.ParseException;

import java.util.ArrayList;

public class Fonction {
	
	//Liste des type des params
	private ArrayList<Integer> param;
	//Liste du nom des params
	private ArrayList<String> paramNom;
	//Type du resultat de la fonction
	private int resultat;
	
	//Constructeur (Type de retour)
	public Fonction(int _r) {
		param = new ArrayList<Integer>();
		paramNom = new ArrayList<String>();
		resultat = _r;
	}
	
	//Ajoute un Param a la liste
	public void addParam(int _p, String _n) { this.param.add(_p); this.paramNom.add(_n);}
	
	public int getNbP() { return this.param.size(); }
	public int getRetour() { return this.resultat; }
	
	public ArrayList<Integer> getList() { return this.param; }
	
	//Verification du nombre de param
	public void testNbP(int _n, String id) {
		if(_n != getNbP())
			System.out.println("Nombre de paramètres incorrect pour "+id);
	}
	
	//init les offset de tout les Param
		public void initOffset(TabIdent t) throws ParseException {
			for(int i=0;i<paramNom.size();i++) {
				((IdParam) t.chercheIdent(paramNom.get(i))).setOffset(paramNom.size()*2+4-(i+1)*2);
			}
		}
}
