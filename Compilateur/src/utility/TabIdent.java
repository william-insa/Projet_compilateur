package utility;

import generated.ParseException;

import java.util.HashMap;

public class TabIdent {
	//HashMap des fonctions
	private HashMap<String, Fonction> globaux;
	
	//HashMap des Ident
	private HashMap<String,Ident> locaux;

	//Constructeur (initialisation des HashMap)
	public TabIdent() {
		globaux = new HashMap<String, Fonction>();
		locaux = new HashMap<String, Ident>();
	}

	//Recupere l'Ident correspondant a la clef
	public Ident chercheIdent(String _clef) throws ParseException {
		if (existeIdent(_clef)) {return locaux.get(_clef);}
		throw (new ParseException ("Erreur ident inconnu : "+_clef+" \n"));
	}

	//Est ce que l'ident clef existe?
	public boolean existeIdent(String _clef) {return locaux.containsKey(_clef);}

	//Ajoute un ident dans la HashMap
	public void rangeIdent(String _clef, Ident _ident) {
		if (!existeIdent(_clef))
			locaux.put(_clef, _ident);
	}
	
	//Ajoute une Fonction dans la HashMap
	public void rangeFonction(String _clef, Fonction _fonc) {
		if (!existeFonction(_clef))
			globaux.put(_clef, _fonc);
	}
	
	// Est ce que la fonction existe?
	public boolean existeFonction(String _clef) {return globaux.containsKey(_clef);}
	
	//Rend la Fonction correspondante a la clef
	public Fonction chercheFonction(String _clef) throws ParseException {
		if (existeFonction(_clef)) {
			return globaux.get(_clef);
		}
		throw (new ParseException ("Erreur Fonction inconnu : "+_clef+" \n"));
	}
	
	//Rend le nombre de Var
	public int getNbVar() { 
		int i =0;
		for(Ident id : locaux.values()) {
			if (!id.isConst() && !id.isParam()) {i++;}
		}
		return i;
	}
	
	//Rend le nombre de Param
	public int getNbParam() { 
		int i =0;
		for(Ident id : locaux.values()) {
			if (id.isParam()) {i++;}
		}
		return i;
	}
	
	//init les offset de tout les Param
	public void initOffset() {
		int nbParam = getNbParam();
		int i=1;
		for(Ident id : locaux.values()) {
			if (id.isParam())
			{
				((IdParam) id).setOffset(nbParam*2+4-i*2);
				i++;
			}
		}
	}
	
	public HashMap<String,Fonction> getG() { return this.globaux; }
	public HashMap<String,Ident> getL() { return this.locaux; }
	
}
