package utility;

public abstract class Ident {
	private String name;
	private int type;


	public Ident(String _name, int _type) {
		this.name = _name;
		this.type = _type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String _n) {
		this.name = _n;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int _t) {
		this.type = _t;
	}
	public boolean memeIdent(Ident _a, Ident _b) {
		return _a.getName().equals(_b.getName());
	}
}
