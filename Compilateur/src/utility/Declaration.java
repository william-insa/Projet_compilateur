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
	
	public void declVar(String clef, int type) throws IdentDejaPresentException{
		Yaka.tabIdent.rangeIdent(clef, new IdVar(clef,type,0));
	}
	
	
}
