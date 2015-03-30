package utility;

public class IdConst extends Ident {

	//Valeur de la constante
	private int valeur;

	//Initialisation d'une IdConst (nom, type et valeur)
	public IdConst(String _name, int _type, int _valeur) {
		super(_name, _type); //constructeur de Ident
		this.valeur = _valeur;
	}

	public int getValeur() {return this.valeur;}
	public void setValeur(int _v) {this.valeur = _v;}

	//Verificateur de type
	public boolean isConst() {return true;}
}
