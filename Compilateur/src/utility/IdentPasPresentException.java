package utility;

public class IdentPasPresentException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdentPasPresentException() {
		System.out.println("L'ident n'est pas présent dans la table des idents.");
	}
}
