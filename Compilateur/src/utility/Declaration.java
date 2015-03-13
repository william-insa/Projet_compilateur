package utility;


import java.util.Stack;

public class Declaration {
	private Stack<String> pileNom;
	private Stack<Integer> pileType;
	private Stack<Integer> pileVal;
	private TabIdent table;
	
	public Declaration(TabIdent ta){
		pileNom = new Stack<String>();
		pileType = new Stack<Integer>();
		pileVal = new Stack<Integer>();
		table = ta;
		
	}
	

	public void declConst(){
		//TODO on fait quoi ici?
	}
	public void defConst(){
		// TODO recup du nom
	}
	public void valConst() throws IdentDejaPresentException{
		String name = pileNom.pop();
		int type = pileType.pop();
		int val= pileVal.pop();
		
		Ident id = new IdConst(name, type, val);
		
		if (table.existeIdent(name))
			table.rangeIdent(name, id);
		else
			throw new IdentDejaPresentException();
	}
	public void declVar() throws IdentDejaPresentException{
		String name = pileNom.pop();
		int type = pileType.pop();
		int val= pileVal.pop();
	
		Ident id = new IdVar(name, type, val);
	
		if (table.existeIdent(name))
			table.rangeIdent(name, id);
		else
			throw new IdentDejaPresentException();
	}
	
	
}
