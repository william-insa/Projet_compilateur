package utility;

import java.util.HashMap;

public class TabIdent {
	private HashMap<String,Ident> table;
	
	public TabIdent () {
		table = new HashMap<String,Ident>();
	}
	
	public Ident chercheIdent(String _clef) throws IdentPasPresentException {
		if (existeIdent(_clef)) {
			return this.table.get(_clef);
		}
		else
			throw new IdentPasPresentException();
		
	}
	
	public boolean existeIdent(String _clef) {
		return this.table.containsKey(_clef);
	}
	
	public void rangeIdent (String _clef, Ident _ident) throws IdentDejaPresentException
	{
		if (!existeIdent(_clef))
		{
			this.table.put(_clef, _ident);
		}
		else
			throw new IdentDejaPresentException();
	}
}
