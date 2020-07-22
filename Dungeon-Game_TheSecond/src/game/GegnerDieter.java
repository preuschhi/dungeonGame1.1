package game;

public class GegnerDieter extends Gegner{
	
	Waffe waffeGegner;
	
	//Konstruktor
	public GegnerDieter() {
		super("King Dieter", 70, 1.5, 20);
		StarkesSchwert waffeGegnerDieter = new StarkesSchwert();
		this.waffeGegner = waffeGegnerDieter;
	}
	
	//Methoden
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
