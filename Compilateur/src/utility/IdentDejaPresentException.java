package utility;

public class IdentDejaPresentException extends Exception{
	public IdentDejaPresentException() {
		System.out.println("Un ident avec le même nom existe déjà.");
	}
}
