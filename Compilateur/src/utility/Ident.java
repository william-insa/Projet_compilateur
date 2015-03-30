package utility;

public abstract class Ident {
	
	// Nom de l'Ident et son type (boolean ou entier)
	private String name;
	private int type;

	//Constructeur (nom + type)
	public Ident(String _name, int _type) {
		this.name = _name;
		this.type = _type;
	}

	//Ident _a et _b sont identique?
	public boolean memeIdent(Ident _a, Ident _b) {
		return _a.getName().equals(_b.getName());
	}

	public String getName() {return this.name;}
	public void setName(String _n) {this.name = _n;}

	public int getType() {return this.type;}
	public void setType(int _t) {this.type = _t;}

	//Verificateur de type
	public boolean isConst() {return false;}
	public boolean isParam() {return false;}
	public boolean isVar() {return false;}
}
