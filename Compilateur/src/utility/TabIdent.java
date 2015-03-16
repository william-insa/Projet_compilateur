package utility;

import java.util.HashMap;

public class TabIdent {
	private HashMap<String, Ident> table;

	public TabIdent() {
		table = new HashMap<String, Ident>();
	}

	public Ident chercheIdent(String _clef) {
		if (existeIdent(_clef)) {
			return this.table.get(_clef);
		}
		return null;

	}

	public boolean existeIdent(String _clef) {
		return this.table.containsKey(_clef);
	}

	public void rangeIdent(String _clef, Ident _ident) {
		if (!existeIdent(_clef)) {
			this.table.put(_clef, _ident);
		}
	}
	
	public int getNbVar() { 
		int i =0;
		for(Ident id : table.values()) {
			if (!id.isConst())
			{
				i++;
			}
		}
		
		return i;
	}
}
