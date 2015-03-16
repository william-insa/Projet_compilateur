package utility;

import java.io.IOException;

public interface YVM {

	public void entete();

	public void ouvrePrinc(int x);

	public void iconst(int valeur);

	public void idiv();

	public void iadd();

	public void istore(int offset);

	public void iload(int x);

	public void imul();

	public void isub();

	public void ior();

	public void iinfegal();
	
	public void iinf();
	
	public void ineg();
	
	public void inot();
	
	public void isup();
	
	public void isupegal();
	
	public void iegal();
	
	public void idiff();
	
	public void ifeq(String etiq);
	
	public void queue();
	
	public void iand();
	
	public void Goto(String etiq);
	
	public void lireEnt(int x);
	
	public void aLaLigne();
	
	public void ecrireChaine(String x);
	
	public void ecrireEnt();
	
	public void ecrireBool();

}
