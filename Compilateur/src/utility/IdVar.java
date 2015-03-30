package utility;

public class IdVar extends Ident {

	//Offset dans la pile
	private int offset;

	//Constructeur (Nom + type + offset)
	public IdVar(String _name, int _type, int _offset) {
		super(_name, _type); //Constructeur de Ident
		this.offset = _offset;
	}
	
	public int getOffset() {return this.offset;}
	public void setOffset(int _o) {this.offset = _o;}
	
	//Verification du type
	public boolean isVar() {return true;}
}
