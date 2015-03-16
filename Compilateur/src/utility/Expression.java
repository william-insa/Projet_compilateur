package utility;

import generated.*;

import java.util.Stack;

public class Expression {
	private Stack<Integer> pileOperande;
	private Stack<String> pileOperateur;
	private YVM yvm;
	/* -1 : type erreur
	 * 0 : type entier
	 * 1 : type boolean
	 */
	public Expression(YVM _yvm) {
		pileOperande = new Stack<Integer>();
		pileOperateur = new Stack<String>();
		yvm = _yvm;
	}
	
	public void empiler (Ident _op) throws IdentPasPresentException {
		if (Yaka.tabIdent.existeIdent(_op.getName())) {
			this.pileOperande.add(_op.getType());
			if (_op.getClass().isInstance(IdConst.class)) {
				IdConst t = (IdConst) _op;
				yvm.iconst(t.getValeur());
			}
			else if (_op.getClass().isInstance(IdVar.class)) {
				IdVar t = (IdVar) _op;
				yvm.iload(t.getOffset());
			}
		}
		else
			throw new IdentPasPresentException();
	}
	
	public void empilerOPREL (String _op) {
		this.pileOperateur.add(_op);
		
		switch(_op) {
		case "<":
			yvm.iinf();
			break;
		case ">":
			yvm.isup();
			break;
		case "<=":
			yvm.iinfegal();
			break;
		case ">=":
			yvm.isupegal();
			break;
		
		case "NON":
			yvm.inot();
			break;
		}
	
	}
	
	public void empilerOPADD(String _op) {
		this.pileOperateur.add(_op);
		switch(_op) {
		case "OU":
			yvm.ior();
			break;
		case "+":
			yvm.iadd();
			break;
		case "-":
			yvm.isub();
			break;
		}
	}
	
	public void empilerOPMUL(String _op) {
		this.pileOperateur.add(_op);
		switch(_op) {
		case "ET":
			yvm.iand();
			break;
		case "/":
			yvm.idiv();
			break;
		case "*":
			yvm.imul();
			break;
		}
	}
	public void empilerOPNEG(String _op) {
		this.pileOperateur.add(_op);
		switch(_op) {
		case "NON":
			yvm.inot();
			break;
		case "-":
			yvm.ineg();
			break;
		}
	}
	
	public boolean calcul(String ope) { return ope.equals("+") || ope.equals("-") || ope.equals("/") || ope.equals("*"); }
	public boolean comparaisonEntier(String ope) { return ope.equals("<") || ope.equals(">") || ope.equals("<=") || ope.equals(">="); }
	public boolean comparaisonTous(String ope) { return ope.equals("=") || ope.equals("<>"); }
	public boolean testBool(String ope) { return ope.equals("OU") || ope.equals("ET"); }
	public boolean testOpNegBool(String ope) { return ope.equals("NON"); }
	public boolean testOpNegInt(String ope) { return ope.equals("-"); }
	
	public boolean estBon(int type, String ope) {
		return (type==0 && (calcul(ope) || comparaisonEntier(ope) || comparaisonTous(ope) || testOpNegInt(ope))) 
				|| (type==1 && (comparaisonTous(ope) || testBool(ope) || testOpNegBool(ope)));
	}
	
	
	public void controle() {
		String operateur;
		int typeA, typeB;

		operateur = pileOperateur.pop();
		typeA = pileOperande.pop();
			
		if (estBon(typeA,operateur)) {
			if (!(testOpNegInt(operateur) || testOpNegBool(operateur)))
			{
				typeB = pileOperande.pop();
				if (typeA == typeB)
				{
					if (typeA==1) { pileOperande.push(typeA); }
					else if (calcul(operateur)){
						pileOperande.push(0);
					}
					else {
						pileOperande.push(1);
					}
				}
				else
					pileOperande.push(-1);
			}
			else
				pileOperande.push(typeA);
		}
		else
			pileOperande.push(-1);
	}
}