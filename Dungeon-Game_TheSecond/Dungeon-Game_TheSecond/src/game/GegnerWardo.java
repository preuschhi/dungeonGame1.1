package game;

public class GegnerWardo extends Gegner {
	
	Waffe waffeGegner;
	
	//Konstruktor
	public GegnerWardo() {
		super("Wardo", 60, 1.75, 22, false);
		KryptoBogen waffeGegnerWardo = new KryptoBogen();
		this.waffeGegner = waffeGegnerWardo;

	}

	@Override
	public void angriff() {
		// TODO Auto-generated method stub

	}

	// Methoden
	public Waffe getWaffe() {
		return this.waffeGegner;
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
