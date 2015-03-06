package utility;

public interface YVM {

	public void entete();
	
	public void ouvrePrinc();
	
	public void iconst(int valeur);
	
	public void idiv();
	
	public void iadd();
	
	public void istore(int offset);
	
	public void iload (int x);
	
	public void imul();
	
	public void isub();
	
	public void ior();
	
	public void iinfegal();
	
	public void queue();
	
}
