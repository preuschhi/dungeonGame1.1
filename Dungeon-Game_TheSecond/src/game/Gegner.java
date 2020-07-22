package game;

public abstract class Gegner implements IMethoden {

	// Eigenschaften
	private String nameGegner;
	private int lebenGegner;
	Waffe waffeGegner;
	Spieler spieler;
	double spielerWaffeHaltbarkeitAbzug;//So viel wird der Waffe nach dem tötet dieses Gegenrs abgezogen
	int goldFuerSpieler; //So viel Gold bekommt der Spieler wenn er diesen Gegner tötet

	// Konstruktor
	public Gegner(String nameGegner, int lebenGegner, double spielerWaffeHaltbarkeitAbzug, int goldFuerSpieler) {
		super();
		this.nameGegner = nameGegner;
		this.lebenGegner = lebenGegner;
		this.spielerWaffeHaltbarkeitAbzug = spielerWaffeHaltbarkeitAbzug;
		this.goldFuerSpieler = goldFuerSpieler;
	}

	// Methoden

	public void angriff(Spieler spielerID, Gegner gegner) {

		// Dann wir durch zufall ermittelt ob der Gegner den Spieler angreift oder ob er
		// ihn verfehlt
		int min = 1;
		int max = 10;
		int zahl = min + (int) (Math.random() * ((max - min) + 1));
		// Hier wird angeriffen
		if ((zahl == 1) || (zahl == 2) || (zahl == 3) || (zahl == 4) || (zahl == 5) || (zahl == 6)) {
			
			spielerID.setLeben(spielerID.getLeben() - getWaffe().schadenWaffe);
			System.out.println("Der Gegner " + getName() + " hat dir " + getWaffe().schadenWaffe + " Leben abgezogen!");
			System.out.println("Du hast noch " + spielerID.getLeben() + " Leben!");
		} else {
		
			System.out.println("Der Gegner " + getName() + " hat dich nicht Getroffen");
		}

	}

	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.nameGegner;
	}

	@Override
	public int getLeben() {
		// TODO Auto-generated method stub
		return this.lebenGegner;
	}

	@Override
	public void setLeben(int neueLeben) {
		this.lebenGegner = neueLeben;

	}

	public void setGegnerSpieler(Spieler spieler) { // Um dem Gegner die möglichkeit zu geben den Spieler anzugreifen
		this.spieler = spieler;
	}

	public Waffe getWaffe() { // Um die Waffe vom SpielerGegner Objekt zu bekommen, z.B. Olaf
		
		return waffeGegner;
	}

}
