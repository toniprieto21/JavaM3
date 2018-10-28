
public class BibliotecaApp {

	public static void main(String[] args) {
		
		// Creem els llibres
		Llibre llibre1 = new Llibre("Titol1", "ISBN1", "Autor1", "Editorial1", 50, 1999);
		Llibre llibre2 = new Llibre("Titol2", "ISBN2", "Autor2", "Editorial2", 100, 2000);
		
		// Creem seccio
		Seccio seccio1 = new Seccio("Nom1", "123");
		
		//Afegim els llibres a la seccio
		seccio1.addLlibre(llibre1);
		seccio1.addLlibre(llibre2);
		
		seccio1.printLlibres();
		
		
		
		
		
	}

}
