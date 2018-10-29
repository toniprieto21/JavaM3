import java.util.Vector;

/**
 * Classe que permet representar el concepte de secció temàtica d'una biblioteca.
 * 
 * @author Jordi Gual i Purtí
 *
 */
public class Seccio {
	private String nom;
	private String codiCDU;
	private Vector<Llibre> llibres;

	/**
	 * Constructor que permet crear objectes de tipus Seccio amb un valor inicial per a tots els seus atributs
	 * @param n Valor inicial per a l'atribut nom.
	 * @param c Valor inicial per a l'atribut codiCDU.
	 * @throws IllegalArgumentException En cas que algun dels valors inicials dels atributs no compleixi els requisits
	 * establerts en cadascun dels setter corresponents.
	 */
	public Seccio(String n, String c) {
		try {
			setNom(n);
			setCodiCDU(c);
			llibres = new Vector<Llibre>();
		}
		catch (IllegalArgumentException e){
			System.out.println("Els valors no compleixen els requisits establerts.");
		}
	}

	/**
	 * Getter de l'atribut nom.
	 * @return Valor actual de l'atribut nom.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter de l'atribut nom.
	 * @param n Nou valor per a l'atribut nom.
	 * @throws IllegalArgumentException En cas que el valor que li passem sigui null o cadena buida.
	 */
	public void setNom(String n) {
		try {
			if (n == null || n.equals("")) {
				throw new IllegalArgumentException("El valor no pot ser null o cadena buida.");
			}
			else {
				nom = n;
			}
		}
		catch (IllegalArgumentException IAE) {
			System.out.println("El valor no pot ser null o cadena buida.");
		}
	}


	/**
	 * Getter de l'atribut codiCDU
	 * @return the codiCDU Valor actual de l'atribut codiCDU.
	 */
	public String getCodiCDU() {
		return codiCDU;
	}

	/**
	 * Setter de l'atribut codi CDU.
	 * @param c Nou valor per a l'atribut codiCDU.
	 * @throws IllegalArgumentException En cas que el valor que li passem sigui null o cadena buida.
	 */
	public void setCodiCDU(String c) {
		try {
			if (c == null || c.equals("")) {
				throw new IllegalArgumentException("El valor no pot ser null o cadena buida.");
			}
			else {
				codiCDU = c;
			}
		}
		catch (IllegalArgumentException IAE) {
			System.out.println("El valor no pot ser null o cadena buida.");
		}
	}

	/**
	 * Mètode que permet afegir un nou llibre a una secció.
	 * @param l Referència a l'objecte llibre que volem afegir a la secció.
	 * @throws LlibreRepetitException En cas que ja existeixi un llibre donat d'alta a la secció amb
	 * el mateix ISBN que el nou llibre que volem afegir.
	 * @throws IllegalArgumentException En cas que passem una referència que valgui null.
	 */
	public void addLlibre (Llibre l) {
		try {
			// Condicional que s'activa en cas que el valor que donem valgui null.
			if (l == null) {
				throw new IllegalArgumentException("La referencia no pot ser nul.");
			}

			if (posicioLlibre(l.getIsbn()) != -1) {
				throw new LlibreRepetitException("LLIBRE REPETIT");
			}

			else {
				llibres.add(l);
			}
		}
		catch (IllegalArgumentException IAE){
			System.out.println("La referencia no pot ser nul.");
			System.out.println("");
			System.out.println("");
		}
		catch (LlibreRepetitException LRE){
			System.out.println("El llibre que has intentat afegir ja existeix. ISBN del llibre: " + l.getIsbn());
			System.out.println("");
			System.out.println("");
		}

	}


	/**
	 * Mètode que permet eliminar un llibre d'una secció donant-ne el ISBN
	 * @param i ISBN del llibre que volem eliminar de la secció.
	 * @throws LlibreInexistentException En cas que l'ISBN donat no correspongui a cap dels llibres de la secció.
	 * @throws IllegalArgumentException En cas que passem un valor null o cadena buida com a ISBN del llibre a eliminar.
	 */
	public void removeLlibre(String i) {
		int pos;
		pos = posicioLlibre(i);

		try {
			if (posicioLlibre(i) == -1) {
				throw new LlibreInexistentException("L'ISBN donat no coincideix amb cap llibre.");
			}
			
			else if (i == null || i.equals("")) {
				throw new IllegalArgumentException("");
			}
			else {
				llibres.remove(pos);
			}
			
		}
		catch (IllegalArgumentException IAE) {
			System.out.println("El valor no potser null.");
			System.out.println("");
			System.out.println("");
		}
		catch (LlibreInexistentException LIE) {
			System.out.println("L'ISBN donat no coincideix amb cap llibre.");
			System.out.println("");
			System.out.println("");
		}			
	}


	/**
	 * Mètode que ens comprova si a la secció hi tenim un llibre amb un ISBN determinat i,
	 * en cas afirmatiu, ens diu en quina posició del vector de llibres es troba.
	 * @param i ISBN del llibre que volem comprovar si existeix.
	 * @return Posició on es troba el llibre dins del vector (si existeix), o -1 en cas que
	 * no existeixi cap llibre amb l'ISBN donat dins la secció.
	 */
	private int posicioLlibre(String i) {
		boolean trobat = false;
		int pos = 0;
		int resultat =  -1;

		// Recorrem el vector de llibres comprovant per cadascun d'ells si el seu ISBN és
		// igual que el que ens donen. En cas afirmatiu, posarem la variable trobat a true
		// i pararem el bucle.
		while (pos < llibres.size() && !trobat) {
			trobat = llibres.get(pos).getIsbn().equals(i);
			pos++;
		}

		// Si havíem trobat un llibre amb l'ISBN donat, retornarem la posició on l'hem trobat.
		// En cas contrari, es retornarà -1 ja que no modificarem el valor inicial de la
		// variable resultat.
		if (trobat) {
			resultat = pos - 1;
		}

		return resultat;
	}

	/**
	 * Mètode que mostra per consola les dades de tots els llibres d'una secció.
	 */
	public void printLlibres() {

		if (llibres.size() > 0) {
			System.out.printf("%-40s%-15s%-30s%-15s%10s%10s%n", "Títol", "ISBN", "Autor", "Editorial", "Pàgines", "Any Ed.");
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------");
			for (int pos = 0; pos < llibres.size(); pos++) {
				System.out.printf("%-40s%-15s%-30s%-15s%10d%10d%n", 
						llibres.get(pos).getTitol(),
						llibres.get(pos).getIsbn(),
						llibres.get(pos).getAutor(),
						llibres.get(pos).getEditorial(),
						llibres.get(pos).getNumPagines(),
						llibres.get(pos).getAnyEdicio());
			}
		}
		else {
			System.out.println("No hi ha llibres per mostrar en la secció " + nom + ".");
		}
	}
}
