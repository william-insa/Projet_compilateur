package utility;

public class IdConst extends Ident {

	private int valeur;
	
	public IdConst(String _name, int _type, int _valeur) {
		super(_name, _type);
		this.valeur = _valeur;
	}

	
	public int getValeur() { return this.valeur; }
	public void setValeur(int _v) { this.valeur = _v; }
}
