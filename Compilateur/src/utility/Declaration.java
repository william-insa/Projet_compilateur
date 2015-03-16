package utility;
import generated.*;



public class Declaration {

	public void declConst(String clef) throws IdentDejaPresentException{
		Yaka.tabIdent.rangeIdent(clef, new IdConst(clef,0,0));
	}

	public void defConst(String clef, int type, int valeur) throws IdentPasPresentException{
		((IdConst) Yaka.tabIdent.chercheIdent(clef)).setValeur(valeur);
		((IdConst) Yaka.tabIdent.chercheIdent(clef)).setType(type);
		
	}

	public void defConst(String clef, String nom) throws IdentPasPresentException{
		IdConst temp = (IdConst) Yaka.tabIdent.chercheIdent(nom);
		((IdConst) Yaka.tabIdent.chercheIdent(clef)).setValeur(temp.getValeur());
		((IdConst) Yaka.tabIdent.chercheIdent(clef)).setType(temp.getType());
		
	}
	
	public void declVar(String clef, int type) throws IdentDejaPresentException{
		Yaka.tabIdent.rangeIdent(clef, new IdVar(clef,type,0));
	}
	
	
}
