package utility;

public class IdentDejaPresentException extends Exception{
	public IdentDejaPresentException() {
		System.out.println("Un ident avec le m�me nom existe d�j�.");
	}
}
