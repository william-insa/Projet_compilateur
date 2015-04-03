package utility;

import generated.*;

import java.util.Stack;

public class Expression {
	// Pile des termes d'une expression
	private Stack<Integer> pileOperande;
	// Pile des opérateurs d'une expression
	private Stack<String> pileOperateur;
	private YVM yvm;
	/* -1 : type erreur
	 * 0 : type entier
	 * 1 : type boolean
	 */
	
	// Constructeur
	public Expression(YVM _yvm) {
		pileOperande = new Stack<Integer>();
		pileOperateur = new Stack<String>();
		yvm = _yvm;
	}
	
	// Empile un ident sur la pileOperande
	public void empilerIdent (String _op) throws ParseException  {
		
		Ident ident = Yaka.tabIdent.chercheIdent(_op);
			
		pileOperande.add(ident.getType());
		
		if (ident.isConst()) {
			yvm.iconst(((IdConst) ident).getValeur());
		}
		else {
			if(ident.isParam())
				yvm.iload(((IdParam) ident).getOffset());
			else
				yvm.iload(((IdVar) ident).getOffset());
		}
	}
	
	// Empile un opérateur sur la pile opérateur
	public void empilerOP (String _op) { this.pileOperateur.add(_op); }
	
	// Empile un booléen sur la pile des opérandes (cas const)
	public void empilerBool() { this.pileOperande.add(1);}
	// Empile un entier sur la pile des opérandes (cas const)
	public void empilerInt() { this.pileOperande.add(0);}
	
	// Diverses fonctions qui testent l'opérateur
	public boolean calcul(String ope) { return ope.equals("+") || ope.equals("-") || ope.equals("/") || ope.equals("*"); }
	public boolean comparaisonEntier(String ope) { return ope.equals("<") || ope.equals(">") || ope.equals("<=") || ope.equals(">="); }
	public boolean comparaisonTous(String ope) { return ope.equals("=") || ope.equals("<>"); }
	public boolean testBool(String ope) { return ope.equals("OU") || ope.equals("ET"); }
	public boolean testOpNegBool(String ope) { return ope.equals("NON"); }
	public boolean testOpNegInt(String ope) { return ope.equals("NEG"); }
	
	// Test si une opération est bon en fonction du type et de l'opérateur
	public boolean estBon(int type, String ope) {
		return (type==0 && (calcul(ope) || comparaisonEntier(ope) || comparaisonTous(ope) || testOpNegInt(ope))) 
				|| (type==1 && (comparaisonTous(ope) || testBool(ope) || testOpNegBool(ope)));
	}
	
	// Evalue une opération (autre que 'opNeg') 
	public void evaluation() {
		String operateur;
		int typeA, typeB, type=0;
		
		operateur = pileOperateur.pop();
		typeA = pileOperande.pop();
		

		typeB = pileOperande.pop();
	
		if(!(estBon(typeA,operateur) && typeA == typeB)) {
			if (typeA!=-1 && typeB!=-1){
				System.out.println("Erreur de type.");
			}
			type=-1;
		}
		else
		{
			if (typeA==1) { type=1; }
			else {
				if (calcul(operateur)) { type = 0; }
				else { type = 1; }
			}
		}
		pileOperande.push(type);
		
		switch(operateur) {
			case "<":
				yvm.iinf();	break;
			case ">":
				yvm.isup();	break;
			case "<=":
				yvm.iinfegal();break;
			case ">=":
				yvm.isupegal();break;
			case "NON":
				yvm.inot();break;
			case "ET":
				yvm.iand();break;
			case "/":
				yvm.idiv();break;
			case "*":
				yvm.imul();break;
			case "OU":
				yvm.ior();break;
			case "+":
				yvm.iadd();break;
			case "-":
				yvm.isub();break;
		}
	}
	
	// Evalue une opération 'opNeg'
	public void evaluationNeg() {
		String operateur;
		int typeA;
		
		operateur = pileOperateur.pop();
		typeA = pileOperande.pop();
		
		if (estBon(typeA,operateur)) {
			pileOperande.push(typeA);
		}
		else{
			if (typeA!=-1){
				System.out.println("Erreur de type.");
			}
			
			pileOperande.push(-1);
			}
		switch(operateur) {
		case "NON":
			yvm.inot();
			break;
		case "-":
			yvm.ineg();
			break;
		}
	}
	
	// Vérifie si l'affectation est cohérente avec le type final de l'opération
	public void aff(Ident i){
		int typeI = i.getType();
		int typeE = pileOperande.pop();
		
		if (i.isConst()) System.out.println("On ne peut pas affecter une nouvelle valeur à une constante.");
		if (typeI != typeE) System.out.println("Erreur d'affectation.");
		
	}
	
	
	public int ecr() {	return pileOperande.pop(); }
	
	// Vérifie qu'une condition est de type booléen
	public void cond() {
		if (pileOperande.pop()!=1)
			System.out.println("La condition n'est pas de type booléen.");
	}
	
	// Vérifie qu'une fonction retourne le bon type
	public void testRetour(int _t, String _id) {
		if (pileOperande.pop() != _t)
			System.out.println("La fonction "+_id+" ne retourne pas le bon type.");
	}
	
	// Vérifie que le type d'un paramètre est correct
	public void testTypeP(Fonction _f, int _r)
	{
		if (pileOperande.pop() != _f.getList().get(_r-1))
			System.out.println("Type du parametre incorrect.");
	}
	
	// Empile le type résultat d'une fonction dans la pile des opérandes
	public void empilerFonc(Fonction _f) {	pileOperande.add(_f.getRetour()); }
}