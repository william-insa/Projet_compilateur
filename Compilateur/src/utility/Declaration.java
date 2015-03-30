package utility;

import generated.*;



public class Declaration {
	
	
	//declaration d'une constante
	public void declConst(String clef){
		Yaka.tabIdent.rangeIdent(clef, new IdConst(clef,0,0));
	}

	//Definition d'une constante (mise a jour du type et de la valeur)
	public void defConst(String clef, int type, int valeur) throws ParseException {
		((IdConst) Yaka.tabIdent.chercheIdent(clef)).setValeur(valeur);
		((IdConst) Yaka.tabIdent.chercheIdent(clef)).setType(type);
	}

	//Definition d'une constante (copie d'une autre constante)
	public void defConst(String clef, String nom) throws ParseException {
		IdConst temp = (IdConst) Yaka.tabIdent.chercheIdent(nom);
		((IdConst) Yaka.tabIdent.chercheIdent(clef)).setValeur(temp.getValeur());
		((IdConst) Yaka.tabIdent.chercheIdent(clef)).setType(temp.getType());
	}
	
	//Declaration d'une Var (avec son type)
	public void declVar(String clef, int type) {
		Yaka.tabIdent.rangeIdent(clef, new IdVar(clef,type,-2*(1+Yaka.tabIdent.getNbVar())));
	}
	
	//Declaration d'un Param (avec son type)
	public void declParam(String clef, int type) {
		Yaka.tabIdent.rangeIdent(clef, new IdParam(clef,type,0));
	}
	
	//Declaration d'une Fonction avec le type du resultat
	public void declFonction(String nom, int _r) {
		Yaka.tabIdent.rangeFonction(nom, new Fonction(_r));
	}
}
