package utility;

public class IdentDejaPresentException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdentDejaPresentException() {
		System.out.println("Un ident avec le même nom existe déjà.");
	}
}
