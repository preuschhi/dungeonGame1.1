package game;

public class GegnerOlaf extends Gegner {

	Waffe waffeGegner;

	// Konstrukor
	public GegnerOlaf() {
		super("Olaf", 30, 0.5, 5, true);
		StandartSchwert waffeGegnerOlaf = new StandartSchwert();
		this.waffeGegner = waffeGegnerOlaf;
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
