
public class LlibreRepetitException extends Exception{

	private Llibre LlibreErroni;
	public LlibreRepetitException(String m) {
		super(m);
	}
	
	public Llibre getLlibreErroni() {
		return LlibreErroni;
	}
	public void setLlibreErroni(Llibre l) {
		LlibreErroni = l;
	}
	
	
	

}
