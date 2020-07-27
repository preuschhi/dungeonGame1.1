package game;

public class GegnerFlaga extends Gegner {

	Waffe waffeGegner;
	
	//Konstruktor
	public GegnerFlaga() {
		super("Flaga", 37, 1, 16, false);
		CarbonBogen waffeGegnerFlaga = new CarbonBogen();
		this.waffeGegner = waffeGegnerFlaga;
	}

	// Methoden
	public Waffe getWaffe() {
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
