package game;

public class GegnerJuergen extends Gegner {

	Waffe waffeGegner;

	// Konstruktor
	public GegnerJuergen() {
		super("Juergen", 45, 1, 10, true);
		MittelStarkesSchwert waffeGegnerJuergen = new MittelStarkesSchwert();
		this.waffeGegner = waffeGegnerJuergen;
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
