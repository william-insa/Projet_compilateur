package utility;

import generated.ParseException;

import java.util.HashMap;

public class TabIdent {
	private HashMap<String, Fonction> globaux;
	private HashMap<String,Ident> locaux;

	public TabIdent() {
		globaux = new HashMap<String, Fonction>();
		locaux = new HashMap<String, Ident>();
	}

	public Ident chercheIdent(String _clef) throws ParseException {
		if (existeIdent(_clef)) {
			return locaux.get(_clef);
		}
		
		throw (new ParseException ("Erreur ident inconnu : "+_clef+" \n"));
		
	}

	public boolean existeIdent(String _clef) {
		return locaux.containsKey(_clef);
	}

	public void rangeIdent(String _clef, Ident _ident) {
		if (!existeIdent(_clef))
			locaux.put(_clef, _ident);
	}
	
	public void rangeFonction(String _clef, Fonction _fonc) {
		if (!existeFonction(_clef))
			globaux.put(_clef, _fonc);
	}
	
	public boolean existeFonction(String _clef) {
		return globaux.containsKey(_clef);
	}
	
	public Fonction chercheFonction(String _clef) throws ParseException {
		if (existeFonction(_clef)) {
			return globaux.get(_clef);
		}
		
		throw (new ParseException ("Erreur ident inconnu : "+_clef+" \n"));
		
	}
	
	public int getNbVar() { 
		int i =0;
		for(Ident id : locaux.values()) {
			if (!id.isConst() && !id.isParam())
			{
				i++;
			}
		}
		
		return i;
	}
	
	public int getNbParam() { 
		int i =0;
		for(Ident id : locaux.values()) {
			if (id.isParam())
			{
				i++;
			}
		}
		
		return i;
	}
	
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
