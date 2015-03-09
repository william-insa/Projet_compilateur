package utility;

import generated.Yaka;

import java.util.Stack;

public class Expression {
	private Stack<Integer> pileIdent;
	private Stack<Character> pileOperateur;
	
	public Expression() {
		pileIdent = new Stack<Integer>();
		pileOperateur = new Stack<Character>();
	}
	
	public void calcul() {
		
	}
	
	public void empiler (Ident _op) throws IdentPasPresentException {
		if (Yaka.tabIdent.existeIdent(_op.getName()))
			this.pileIdent.add(_op.getType());
		else
			throw new IdentPasPresentException();
	}
	public void empiler (char _op) {this.pileOperateur.add(_op);}
	
	public void opNeg() {
		// vérifier type
		
	}
}
