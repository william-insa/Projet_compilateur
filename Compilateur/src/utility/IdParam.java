package utility;

public class IdParam extends Ident {

	private int offset;

	public IdParam(String _name, int _type, int _offset) {
		super(_name, _type);
		this.offset = _offset;
	}

	public int getOffset() {
		return this.offset;
	}

	public void setOffset(int _o) {
		this.offset = _o;
	}
	
	public boolean isParam() { return true; }
}
