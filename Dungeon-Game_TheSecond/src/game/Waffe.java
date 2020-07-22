package game;

import java.util.Scanner;

public class Waffe {

	// Eigenschaften
	Spieler spieler;// Damit ich auf die Waffen in der Spielerklasse zugriff hab
	int schadenWaffe;
	String nameWaffe;
	double haltbarkeitWaffe;
	// Das sind die Stufen der 3 Waffenverbesserungen
	Boolean staerke1;
	Boolean staerke2;
	Boolean eis1;
	Boolean eis2;
	Boolean feuer1;
	Boolean feuer2;
	boolean verbesserungsAuswahlSchleife;// Wenn der Spieler eine Waffe verbessern will, die schon lvl 2 ist, wird
											// dieser bool auf true gestellt, damit eine schleife, um die Auswahl zu
											// wiederholen, ausgelöst wird. Wenn die Verbesserung nicht auf Lvl2 ist,
											// wird
											// der Bool auf false gestellt, damit das programm weiterlaufen kann

	// Konstruktor
	public Waffe(int schadenWaffe, String nameWaffe, double haltbarkeitWaffe, boolean staerke1, Boolean staerke2,
			Boolean eis1, Boolean eis2, Boolean feuer1, Boolean feuer2) {
		this.schadenWaffe = schadenWaffe;
		this.nameWaffe = nameWaffe;
		this.haltbarkeitWaffe = haltbarkeitWaffe;
		this.staerke1 = staerke1;
		this.staerke2 = staerke2;
		this.eis1 = eis1;
		this.eis2 = eis2;
		this.feuer1 = feuer1;
		this.feuer2 = feuer2;
	}

	// Methoden

	// Hier kommt die WaffenKonfigurationsmethode.
	// Der Spieler hat di

	public void waffenKonfiguration(Spieler spielerID) {
		this.spieler = spielerID;
		// Als erstes wird durch einen zufallsgenerator ein int ausgegeben welcher den
		// raum bestimmt
		boolean raumNormal = false;
		boolean raumKalt = false;
		boolean raumHeiß = false;

		int min = 1;
		int max = 3;
		int zufallsZahl = min + (int) (Math.random() * ((max - min) + 1));

		switch (zufallsZahl) {
		case 1: {
			raumNormal = true;
		}
		case 2: {
			raumKalt = true;
		}
		case 3: {
			raumHeiß = true;

			System.out.println("===========================================\nDas ist der Waffenkonfigurator!");
			System.out
					.println("Du kannst nun eine deiner Waffen um +1 in einer von 3 Kategorien verbessern!\n[1]: Name: "
							+ spielerID.waffeSpieler.nameWaffe + " Schaden: " + spielerID.waffeSpieler.schadenWaffe
							+ "\n[2]: Name: " + spielerID.waffeSpieler2.nameWaffe + " Schaden: "
							+ spielerID.waffeSpieler2.schadenWaffe);
			Scanner scan = new Scanner(System.in);
			String eingabeString = scan.nextLine();

			// Hier hat der Spieler das Schwert zum verbessern gewählt
			if (eingabeString.equals("1")) {// Schwert
				// Erst wird überprüft ob das Schwert überhaupt verbessert werden kann
				if (spielerID.waffeSpieler.eis1 == true && spielerID.waffeSpieler.eis2 == true
						&& spielerID.waffeSpieler.feuer1 == true && spielerID.waffeSpieler.feuer2 == true
						&& spielerID.waffeSpieler.staerke1 == true && spielerID.waffeSpieler.staerke2 == true) {
					System.out.println("Die Waffe " + spielerID.waffeSpieler.nameWaffe
							+ " ist schon vollständig verbessert!" + "\nDu kannst nur noch den Bogen "
							+ spielerID.waffeSpieler2.nameWaffe + " verbessern!");
					eingabeString = "2";
				}
				// Wenn das Schwert verbessert werden kann. Solange mindestens EIN Bool auf
				// false ist, kann man verbessern!
				if (spielerID.waffeSpieler.eis1 == false || spielerID.waffeSpieler.eis2 == false
						|| spielerID.waffeSpieler.feuer1 == false || spielerID.waffeSpieler.feuer2 == false
						|| spielerID.waffeSpieler.staerke1 == false || spielerID.waffeSpieler.staerke2 == false) {
					// Hier wird erklärt wie man Verbessert
					System.out.println("Du hast das Schwert: " + spielerID.waffeSpieler.nameWaffe
							+ " zur verbesserung gewählt.\n"
							+ "Du kannst nun zwischen 3 Verbesserungen wählen. Eiß, Feuer und Stärke.\n========================================================"
							+ "\nEs eigenet sich immer, eine Eißverbesserung, in einem Kalten Raum zu machen,\n"
							+ "und eine Feuerverbesserung, in einem Heißen Raum zu machen.\nStärke wird in keinem Raum beeinflusst!");

					verbesserungsAuswahlSchleife = true;
					// Hier wird angegeben was man noch verbessern kann
					while (verbesserungsAuswahlSchleife == true) {
						System.out.println("==========================================="
								+ "\nEs gibt 3 Stufen: Lvl1.Schwach, Lvl1.Stark und Lvl2."
								+ "\nWenn man Lv1.Schwach und Lv1.Stark kombiniert, bekommt man Lv2."
								+ "\nWas willst du verbessern?:" + "\n[1] Stärke: "
								+ spielerID.waffeSpieler.getBooleanStaerkeZustand() + "\n[2] Eis: "
								+ spielerID.waffeSpieler.getBooleanEisZustand() + "\n[3] Feuer: "
								+ spielerID.waffeSpieler.getBooleanFeuerZustand());
						verbesserungsAuswahlSchleife = false;
						eingabeString = scan.nextLine();
						methodeDieUeberprueftObDieVerbesserungAufLvl2Ist(eingabeString);
					}
				}
			}

			if (raumNormal == true) {
				if (eingabeString.equals("1")) {

					// Hier wird der Angriff der Waffe kalkuliert
					if (this.staerke1 == true && this.staerke2 == true) {
						// angriff = piezda;

					}
					if (this.staerke1 == true && this.staerke2 == false) {

					}
					if (this.staerke1 == false && this.staerke2 == true) {

					}
				}
			}
			if (raumHeiß == true) {
				if (eingabeString.equals("2")) {
					if (this.feuer1 == true && this.feuer2 == true) {
						// angriff = piezda
					}
					if (this.feuer1 == true && this.feuer2 == false) {
						// angriff == piezda - piezdaWeilDerRaumHeißIst
					}
				}
			}
			if (raumKalt == true) {

			}
			if (this.staerke1 == true || this.staerke2 == true) {
				// angriff = piezda;
			}
			if (this.staerke1 == true && this.staerke2 == false) {

			}
		}
		}
	}

	public String getBooleanFeuerZustand() { // In dieser Methode wird der Levelzustand von Feuer ausgegeben
		String ausgabeString = "";
		if (feuer1 == true && feuer2 == true) {// Wenn beide true sind, ist die verbesserung auf Level 2
			ausgabeString = "Lvl2";
		}
		if (feuer1 == true && feuer2 == false) { // Wenn nur feuer1 true ist, ist die Verbesserung auf Lvl1.Stark
			ausgabeString = "Lvl1.Stark";
		}
		if (feuer1 == false && feuer2 == true) {// Wenn nur feuer2 true ist, ist die Verbesserung auf Lvl1.Schwach
			ausgabeString = "Lvl1.Schwach";
		}
		if (feuer1 == false && feuer2 == false) {// Wenn beide auf false sind, ist die Verbesserung noch nicht gelevelt
			ausgabeString = "Noch nicht Verbessert!";
		}
		return ausgabeString;
	}

	public String getBooleanEisZustand() { // In dieser Methode wird der Levelzustand von Eis ausgegeben
		String ausgabeString = "";
		if (eis1 == true && eis2 == true) {// Wenn beide true sind, ist die verbesserung auf Level 2
			ausgabeString = "Lvl2";
		}
		if (eis1 == true && eis2 == false) { // Wenn nur eis1 true ist, ist die Verbesserung auf Lvl1.Stark
			ausgabeString = "Lvl1.Stark";
		}
		if (eis1 == false && eis2 == true) {// Wenn nur eis2 true ist, ist die Verbesserung auf Lvl1.Schwach
			ausgabeString = "Lvl1.Schwach";
		}
		if (eis1 == false && eis2 == false) {// Wenn beide auf false sind, ist die Verbesserung noch nicht gelevelt
			ausgabeString = "Noch nicht Verbessert!";
		}
		return ausgabeString;
	}

	public String getBooleanStaerkeZustand() { // In dieser Methode wird der Levelzustand von Staerke ausgegeben
		String ausgabeString = "";
		if (staerke1 == true && staerke2 == true) {// Wenn beide true sind, ist die verbesserung auf Level 2
			ausgabeString = "Lvl2";
		}
		if (staerke1 == true && staerke2 == false) { // Wenn nur staerke1 true ist, ist die Verbesserung auf Lvl1.Stark
			ausgabeString = "Lvl1.Stark";
		}
		if (staerke1 == false && staerke2 == true) {// Wenn nur staerke2 true ist, ist die Verbesserung auf Lvl1.Schwach
			ausgabeString = "Lvl1.Schwach";
		}
		if (staerke1 == false && staerke2 == false) {// Wenn beide auf false sind, ist die Verbesserung noch nicht
			ausgabeString = "Noch nicht Verbessert!"; // gelevelt
		}
		return ausgabeString;
	}

	public void methodeDieUeberprueftObDieVerbesserungAufLvl2Ist(String eingabeString) {
		if (eingabeString.equals("1") && (staerke1 == true && staerke2 == true)) {
			System.out.println("Du kannst die Stärke nicht mehr verbessern!");
			this.verbesserungsAuswahlSchleife = true;
		}
		if (eingabeString.equals("2") && (eis1 == true && eis2 == true)) {
			System.out.println("Du kannst Eis nicht mehr verbessern!");
			this.verbesserungsAuswahlSchleife = true;
		}
		if (eingabeString.equals("3") && (feuer1 == true && feuer2 == true)) {
			System.out.println("Du kannst Feuer nicht mehr verbessern!");
			this.verbesserungsAuswahlSchleife = true;
		}
	}

}
