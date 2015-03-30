package utility;

public class IdParam extends Ident {

	//offset dans la pile
	private int offset;

	
	//Constructeur (Nom + type + offset)
	public IdParam(String _name, int _type, int _offset) {
		super(_name, _type); // Constructeur de Ident
		this.offset = _offset;
	}

	public int getOffset() {
		return this.offset;
	}
	public void setOffset(int _o) {
		this.offset = _o;
	}
	
	//Verificateur de Type
	public boolean isParam() { return true; }
}
