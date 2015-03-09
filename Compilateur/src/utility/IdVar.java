package utility;

public class IdVar extends Ident {

	private int offset;

	public IdVar(String _name, int _type, int _offset) {
		super(_name, _type);
		this.offset = _offset;
	}

	public int getOffset() {
		return this.offset;
	}

	public void setOffset(int _o) {
		this.offset = _o;
	}
}
