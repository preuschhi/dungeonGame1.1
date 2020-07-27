package game;

public class GegnerBeber extends Gegner{

	Waffe waffeGegner;
	
	
	//Konstruktor
	public GegnerBeber() {
		super("Beber", 44, 0.75, 13, false);
		BambusBogen waffeGegnerBeber =  new BambusBogen();
		this.waffeGegner = waffeGegnerBeber;
	
	}

	// Methoden
		public Waffe getWaffe () {
			return this.waffeGegner;
		}
	
	@Override
	public void angriff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void heilen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void heilen(CustomArray heiltrankID) {
		// TODO Auto-generated method stub
		
	}
}
