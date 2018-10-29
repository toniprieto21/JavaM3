import java.util.InputMismatchException;

/**
 * Classe que permet representar el concepte de llibre.
 * 
 * @author Jordi Gual i Purtí
 *
 */
public class Llibre {
	private String titol;
	private String isbn;
	private String autor;
	private String editorial;
	private int numPagines;
	private int anyEdicio;

	/**
	 * Constructor que permet crear objectes de tipus Llibre donant un valor inicial a tots els seus atributs.
	 * @param t Valor inicial per a l'atribut titol.
	 * @param i Valor inicial per a l'atribut isbn.
	 * @param a Valor inicial per a l'atribut autor.
	 * @param e Valor inicial per a l'atribut editorial.
	 * @param np Valor inicial per a l'atribut numPagines.
	 * @param ae Valor inicial per a l'atribut anyEdicio.
	 * @throws IllegalArgumentException En cas que algun dels valors inicials dels atributs no compleixi els requisits
	 * establerts en cadascun dels setter corresponents.
	 */
	public Llibre(String t, String i, String a, String e, int np, int ae) {
		try {
			setTitol(t);
			setIsbn(i);
			setAutor(a);
			setEditorial(e);
			setNumPagines(np);
			setAnyEdicio(ae);
		}
		catch (IllegalArgumentException e1){
			System.out.println("Els valors no compleixen els requisits establerts.");
		}
	}


	/**
	 * Getter de l'atribut titol.
	 * @return Valor actual de l'atribut titol.
	 */
	public String getTitol() {
		return titol;
	}


	/**
	 * Setter de l'atribut titol.
	 * @param t Nou valor per a l'atribut titol.
	 * @throws IllegalArgumentException En cas que el valor que donem valgui null o cadena buida.
	 */
	public void setTitol(String t) {	
		try {
			if (t == null || t.equals("")) {
				throw new IllegalArgumentException("");
			}
			else {
				this.titol = t;
			}
		}
		catch (IllegalArgumentException IAE) {
			System.out.println("El valor no pot ser null o cadena buida.");
		}
	}


	/**
	 * Getter de l'atribut isbn.
	 * @return Valor actual de l'atribut isbn.
	 */
	public String getIsbn() {
		return isbn;
	}


	/**
	 * Setter de l'atribut isbn.
	 * @param i Nou valor per a l'atribut isbn.
	 * @throws IllegalArgumentException En cas que el valor que donem valgui null o cadena buida.
	 */
	public void setIsbn(String i) {
		try {
			if (i == null || i.equals("")) {
				throw new IllegalArgumentException("El valor no pot ser null o cadena buida.");
			}
			else {
				this.isbn = i;
			}
		}
		catch (IllegalArgumentException IAE) {
			System.out.println("El valor no pot ser null o cadena buida.");
		}
	}


	/**
	 * Getter de l'atribut autor.
	 * @return Valor actual de l'atribut autor.
	 */
	public String getAutor() {
		return autor;
	}


	/**
	 * Setter de l'atribut autor.
	 * @param a Nou valor per a l'atribut autor.
	 * @throws IllegalArgumentException En cas que el valor que donem valgui null o cadena buida.
	 */
	public void setAutor(String a) {
		try {
			if (a == null || a.equals("")) {
				throw new IllegalArgumentException("El valor no pot ser null o cadena buida.");
			}
			else {
				this.autor = a;
			}
		}
		catch (IllegalArgumentException IAE) {
			System.out.println("El valor no pot ser null o cadena buida.");
		}
	}


	/**
	 * Getter de l'atribut editorial.
	 * @return Valor actual de l'atribut editorial.
	 */
	public String getEditorial() {
		return editorial;
	}


	/**
	 * Setter de l'atribut editorial.
	 * @param e Nou valor per a l'atribut editorial.
	 * @throws IllegalArgumentException En cas que el valor que donem valgui null o cadena buida.
	 */
	public void setEditorial(String e) {
		try {
			if (e == null || e.equals("")) {
				throw new IllegalArgumentException("El valor no pot ser null o cadena buida.");
			}
			else {
				this.editorial = e;
			}
		}
		catch (IllegalArgumentException IAE) {
			System.out.println("El valor no pot ser null o cadena buida.");
		}
	}


	/**
	 * Getter de l'atribut numPagines.
	 * @return Valor actual de l'atribut numPagines.
	 */
	public int getNumPagines() {
		return numPagines;
	}


	/**
	 * Setter de l'atribut numPagines
	 * @param n Nou valor per a l'atribut numPagines.
	 * @throws IllegalArgumentException En cas que el valor sigui menor que 1.
	 */
	public void setNumPagines(int n) {
		try {
			if (n < 1) {
				throw new IllegalArgumentException("El valor no pot ser menor que 1.");
			}
			else {
				this.numPagines = n;
			}
		}
		catch (IllegalArgumentException IAE) {
			System.out.println("El valor no pot ser menor que 1.");
		}
	}


	/**
	 * Getter de l'atribut anyEdicio.
	 * @return Valor actual de l'atribut anyEdicio.
	 */
	public int getAnyEdicio() {
		return anyEdicio;
	}


	/**
	 * Setter de l'atribut anyEdicio.
	 * @param a Nou valor per a l'atribut anyEdicio.
	 * @throws IllegalArgumentException En cas que el valor sigui menor que -3300 (segons la viquipèdia,
	 * l'escriptura va néixer pels volts del 3300 aC).
	 */
	public void setAnyEdicio(int a) {
		try {
			if (a < -3300) {
				throw new IllegalArgumentException("El valor no pot ser menor que -3300.");
			}
			else {
				this.anyEdicio = a;
			}
		}
		catch (IllegalArgumentException IAE){
			System.out.println("El valor no pot ser menor que -3300.");
		}
	}

}
