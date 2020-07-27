package game;

public class GegnerJürgen extends Gegner {

	Waffe waffeGegner;

	// Konstruktor
	public GegnerJürgen() {
		super("Jürgen", 45, 1, 10, true);
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
