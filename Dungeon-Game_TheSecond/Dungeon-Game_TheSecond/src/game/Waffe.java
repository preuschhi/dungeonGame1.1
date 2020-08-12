package game;

import java.util.Scanner;

public class Waffe {

	// Eigenschaften
	Spieler spieler;// Damit ich auf die Waffen in der Spielerklasse zugriff hab
	int schadenWaffe;
	double schadenWaffeReal; // Jede Waffe hat einen Standartschaden welcher benutzt wird um den Realen
								// Schaden ermitteln zu können
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
											// ändern,
											// ausgelöst. Wenn die Verbesserung nicht auf Lvl2 ist, wird
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
		this.spieler = spielerID; // Hier wird die SpielerObjektID gespeichert damit Spieler Methoden usw.
									// verwendet werden können
		// Als erstes wird durch einen zufallsgenerator ein int ausgegeben welcher den
		// raum bestimmt
		boolean raumNormal = false;
		boolean raumEis = false;
		boolean raumFeuer = false;

		int min = 1;
		int max = 3;
		int zufallsZahl = min + (int) (Math.random() * ((max - min) + 1));
	
		if (zufallsZahl == 1) {
			raumNormal = true;			
		}
		if (zufallsZahl == 2)  {
			raumEis = true;			
		}
		if (zufallsZahl == 3) {
			raumFeuer = true;
		}

			System.out.println("===========================================\nDas ist der Waffenkonfigurator!");
			System.out
					.println("Du kannst nun eine deiner Waffen um +1 in einer von 3 Kategorien verbessern!\n[1]: Name: "
							+ spieler.waffeSpieler.nameWaffe + " Schaden: " + spieler.waffeSpieler.schadenWaffe
							+ "\n[2]: Name: " + spieler.waffeSpieler2.nameWaffe + " Schaden: "
							+ spieler.waffeSpieler2.schadenWaffe);

			Scanner scan = new Scanner(System.in);
			String eingabeString = scan.nextLine();

			/*
			 * Nachdem der Spieler seine zu verbessernde Waffe gewählt hat, wird erst
			 * überprüft ob diese schon FullLvl ist. Wenn ja, wird durch eine Methode die
			 * andere Waffe als verberssernde Waffe gewählt.
			 */
			boolean waffenKonfigLoop = true;
			while (waffenKonfigLoop == true) {
				// Hier wird die zu verbessernde Waffe gewählt
				if (eingabeString.equals("1")) {// Schwert
					spieler.setWaffeSpielerZwischenSpeicher(spieler.waffeSpieler, spielerID);
					System.out.println(spieler.waffeSpieler);
					System.out.println(spieler.getWaffeSpielerZwischenSpeicher());
					System.out.println(spieler.getWaffeSpielerZwischenSpeicher().staerke1);

				}if (eingabeString.equals("2")) { // Bogen
					spieler.setWaffeSpielerZwischenSpeicher(spieler.waffeSpieler2, spielerID);
					}

					// Dann wird überprüft ob die Waffe überhaupt verbessert werden kann
					if (spieler.getWaffeSpielerZwischenSpeicher().eis1 == true
							&& spieler.getWaffeSpielerZwischenSpeicher().eis2 == true
							&& spieler.getWaffeSpielerZwischenSpeicher().feuer1 == true
							&& spieler.getWaffeSpielerZwischenSpeicher().feuer2 == true
							&& spieler.getWaffeSpielerZwischenSpeicher().staerke1 == true
							&& spieler.getWaffeSpielerZwischenSpeicher().staerke2 == true) {
						System.out.println("Die Waffe " + spieler.getWaffeSpielerZwischenSpeicher().nameWaffe
								+ " ist schon vollständig verbessert!"
								+ "\nDu kannst nur noch deine andere Waffe verbessern!");
						setEingabeString(eingabeString);// Wenn der Bogen oder das Schwert welches zu verbessern gewählt
														// wurde
														// FullLvl ist, wird in dieser Methode
														// eingabeString so verändert, das der obere if der jeweils noch
														// zu
														// verbessernden Waffe true ist, damit die
														// setWaffeSpielerZwischenSpeicher
														// das verfügbare waffenObjekt annimmt

					}
					// Wenn das Schwert verbessert werden kann. Solange mindestens EIN Bool auf
					// false ist, kann man verbessern!
					if (spieler.getWaffeSpielerZwischenSpeicher().eis1 == false
							|| spieler.getWaffeSpielerZwischenSpeicher().eis2 == false
							|| spieler.getWaffeSpielerZwischenSpeicher().feuer1 == false
							|| spieler.getWaffeSpielerZwischenSpeicher().feuer2 == false
							|| spieler.getWaffeSpielerZwischenSpeicher().staerke1 == false
							|| spieler.getWaffeSpielerZwischenSpeicher().staerke2 == false) {

						// Hier wird erklärt wie man Verbessert
						System.out.println("Du hast die Waffe: " + spieler.getWaffeSpielerZwischenSpeicher().nameWaffe
								+ " zur verbesserung gewählt.\n"
								+ "Du kannst nun zwischen 3 Verbesserungen wählen. Eis, Feuer und Stärke.\n========================================================"
								+ "\nEs eigenet sich immer, eine Eisverbesserung, in einem  Eisraum zu machen,\n"
								+ "und eine Feuerverbesserung, in einem Feuerraum zu machen.\nStärke wird in keinem Raum beeinflusst!");

						// Hier wird der aktuelle Lvl Zustand der Waffe ausgegeben
						do {
							System.out.println("==========================================="
									+ "\nEs gibt 3 Stufen: Lvl1.Schwach, Lvl1.Stark und Lvl2."
									+ "\nWenn man Lv1.Schwach und Lv1.Stark kombiniert, bekommt man Lv2."
									+ "\nWas willst du verbessern?:" + "\n[1] Stärke: "
									+ spieler.getWaffeSpielerZwischenSpeicher().getStaerkeZustandString(spielerID)
									+ "\n[2] Eis: " + spieler.getWaffeSpielerZwischenSpeicher().getEisZustandString(spielerID)
									+ "\n[3] Feuer: "
									+ spieler.getWaffeSpielerZwischenSpeicher().getFeuerZustandString(spielerID));
							checkWelcherRaum(raumFeuer, raumEis, raumNormal);
							eingabeString = scan.nextLine();
						} while (methodeDieUeberprueftObDieVerbesserungAufLvl2Ist(eingabeString)); // Diese Methode
																									// überprüft, ob die
																									// geählte
																									// Verbesserung
																									// verfügbar ist
						/*
						 * In dieser Methode werden die Zustände der Verbesserungen überptüft und
						 * verändert. Wenn man z.B. eine Eis verbesserung in einem Feuerraum macht, gibt
						 * es dafür eine Methode welche überpüft, wie sich die booleans verhalten
						 */
						spielerID.getWaffeSpielerZwischenSpeicher().checkWieVielAngriffsSchadenDazuKommtSchwert(
								eingabeString, raumNormal, raumEis, raumFeuer, spielerID);
						/*
						 * Nachdem in der vorherigen Methode der neue Angriffschaden (waffeSchadenReal)
						 * errechnet wurde, werden nun die Infomationen aus waffeSpieleZwischenSpeicher
						 * in die Ursprüngliche waffenObjektVariable verschoben
						 */
						waffenKonfigLoop = false;	
						spielerID.ueberSchreibeWaffeSpielerZwischenSpeicherInGenommenesWaffenObjekt();
					}
				}
			}
		
		
	

	// Diese 3 Methoden sollen dem Spieler vor dem upgraden das Aktuelle Level der
	// Verbesserungen als String ausgeben
	public String getFeuerZustandString(Spieler spielerID) { // In dieser Methode wird der Levelzustand von Feuer
											// ausgegeben
		String ausgabeString = "";
		if (spielerID.getWaffeSpielerZwischenSpeicher().feuer1 == true
				&& spielerID.getWaffeSpielerZwischenSpeicher().feuer2 == true) {// Wenn beide true sind, ist die
			// verbesserung auf Level 2
			ausgabeString = "Lvl2";
		}
		if (spielerID.getWaffeSpielerZwischenSpeicher().feuer1 == true
				&& spielerID.getWaffeSpielerZwischenSpeicher().feuer2 == false) { // Wenn nur feuer1 true ist, ist die
																				// Verbesserung auf Lvl1.Stark
			ausgabeString = "Lvl1.Stark";
		}
		if (spielerID.getWaffeSpielerZwischenSpeicher().feuer1 == false
				&& spielerID.getWaffeSpielerZwischenSpeicher().feuer2 == true) {// Wenn nur feuer2 true ist, ist die
																				// Verbesserung auf Lvl1.Schwach
			ausgabeString = "Lvl1.Schwach";
		}
		if (spielerID.getWaffeSpielerZwischenSpeicher().feuer1 == false
				&& spielerID.getWaffeSpielerZwischenSpeicher().feuer2 == false) {// Wenn beide auf false sind, ist die
																				// Verbesserung noch nicht gelevelt
			ausgabeString = "Noch nicht Verbessert!";
		}
		return ausgabeString;
	}

	public String getEisZustandString(Spieler spielerID) { // In dieser Methode wird der Levelzustand von Eis ausgegeben
		String ausgabeString = "";
		if (spielerID.getWaffeSpielerZwischenSpeicher().eis1 == true
				&& spielerID.getWaffeSpielerZwischenSpeicher().eis2 == true) {// Wenn beide true sind, ist die
																			// verbesserung auf Level 2
			ausgabeString = "Lvl2";
		}
		if (spielerID.getWaffeSpielerZwischenSpeicher().eis1 == true
				&& spielerID.getWaffeSpielerZwischenSpeicher().eis2 == false) { // Wenn nur eis1 true ist, ist die
																				// Verbesserung auf Lvl1.Stark
			ausgabeString = "Lvl1.Stark";
		}
		if (spielerID.getWaffeSpielerZwischenSpeicher().eis1 == false
				&& spielerID.getWaffeSpielerZwischenSpeicher().eis2 == true) {// Wenn nur eis2 true ist, ist die
																			// Verbesserung auf Lvl1.Schwach
			ausgabeString = "Lvl1.Schwach";
		}
		if (spielerID.getWaffeSpielerZwischenSpeicher().eis1 == false
				&& spielerID.getWaffeSpielerZwischenSpeicher().eis2 == false) {// Wenn beide auf false sind, ist die
																				// Verbesserung noch nicht gelevelt
			ausgabeString = "Noch nicht Verbessert!";
		}
		return ausgabeString;
	}

	public String getStaerkeZustandString(Spieler spielerID) { // In dieser Methode wird der Levelzustand von Staerke
												// ausgegeben
		String ausgabeString = "";
		if (spielerID.getWaffeSpielerZwischenSpeicher().staerke1 == true
				&& spielerID.getWaffeSpielerZwischenSpeicher().staerke2 == true) {// Wenn beide true sind, ist die
																				// verbesserung auf Level 2
			ausgabeString = "Lvl2";
		}
		if (spielerID.getWaffeSpielerZwischenSpeicher().staerke1 == true
				&& spielerID.getWaffeSpielerZwischenSpeicher().staerke2 == false) { // Wenn nur staerke1 true ist, ist die
																					// Verbesserung auf Lvl1.Stark
			ausgabeString = "Lvl1.Stark";
		}
		if (spielerID.getWaffeSpielerZwischenSpeicher().staerke1 == false
				&& spielerID.getWaffeSpielerZwischenSpeicher().staerke2 == true) {// Wenn nur staerke2 true ist, ist die
																				// Verbesserung auf Lvl1.Schwach
			ausgabeString = "Lvl1.Schwach";
		}
		if (spielerID.getWaffeSpielerZwischenSpeicher().staerke1 == false
				&& spielerID.getWaffeSpielerZwischenSpeicher().staerke2 == false) {// Wenn beide auf false sind, ist die
																					// Verbesserung noch nicht
			ausgabeString = "Noch nicht Verbessert!"; // gelevelt
		}
		return ausgabeString;
	}

	// Diese Methode überprüft ob die aktuell gewählte Verbesserung schon auf Lvl2
	// ist
	public boolean methodeDieUeberprueftObDieVerbesserungAufLvl2Ist(String eingabeString) {
		boolean verbesserungsAuswahlSchleife = false;
		if (eingabeString.equals("1") && (spieler.getWaffeSpielerZwischenSpeicher().staerke1 == true
				&& spieler.getWaffeSpielerZwischenSpeicher().staerke2 == true)) {
			System.out.println("Du kannst die Stärke nicht mehr verbessern!");
			verbesserungsAuswahlSchleife = true;
		}
		if (eingabeString.equals("2") && (spieler.getWaffeSpielerZwischenSpeicher().eis1 == true
				&& spieler.getWaffeSpielerZwischenSpeicher().eis2 == true)) {
			System.out.println("Du kannst Eis nicht mehr verbessern!");
			verbesserungsAuswahlSchleife = true;
		}
		if (eingabeString.equals("3") && (spieler.getWaffeSpielerZwischenSpeicher().feuer1 == true
				&& spieler.getWaffeSpielerZwischenSpeicher().feuer2 == true)) {
			System.out.println("Du kannst Feuer nicht mehr verbessern!");
			verbesserungsAuswahlSchleife = true;
		}

		return verbesserungsAuswahlSchleife;

	}

	// Diese Methoden überpüfen und verändern die Zustände der Eis, Feuer und
	// Staerke booleans

	// Diese Methode überprüft und Verändert die Eis und Feuer Verbesserungen in
	// einem Normalen Raum
	public void checkRaumNormal(String eingabeString, boolean raumNormal, Spieler spielerID) {
		spielerID.getWaffeSpielerZwischenSpeicher().checkRaumNormalEis(eingabeString, raumNormal,  spielerID);
		spielerID.getWaffeSpielerZwischenSpeicher().checkRaumNormalFeuer(eingabeString, raumNormal, spielerID);
	}

	// Diese Methode überprüft und verändert die Zustände von Eis in einem Normalen
	// Raum
	public void checkRaumNormalEis(String eingabeString, boolean raumNormal, Spieler spielerID) {
		// Bei diesen Kontrollstrukturen werden die zustände überprüft und verändert.
		// Wenn ein if
		// true ist, wird der neue Schaden in Abhängigkeit des aktuellen Raumes
		// ermittelt. Ein Normaler Raum hat keine Auswirkungen.
		// Der neue Schaden ergibt sich aus dem Aktuellen schaden (schadenWaffeReal) +
		// 1/4 bzw. 1/2 von dem Standartschaden (schadenWaffe) der Waffe
		if (eingabeString.equals("2") && raumNormal == true && spielerID.getWaffeSpielerZwischenSpeicher().eis1 == false
				&& spielerID.getWaffeSpielerZwischenSpeicher().eis2 == false) {
			if (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal != 0) {
				System.out.println("Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
						+ " Schaden!");
				spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
						.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4;
				System.out.println("Deiner Waffe wurde " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4
						+ " Schaden hinzugefügt!");
				System.out.println("Jetzt macht deine Waffe "
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			}

			if (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal == 0) {
				System.out.println(
						"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe + " Schaden!");
				spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
						.getWaffeSpielerZwischenSpeicher().schadenWaffe
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4;
				System.out.println("Deiner Waffe wurde " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4
						+ " Schaden hinzugefügt!");
				System.out.println("Jetzt macht deine Waffe "
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			}
			spielerID.getWaffeSpielerZwischenSpeicher().eis2 = true;
			raumNormal = false; // Der Raum wird auf false gesetzt damit die anderen ifs nicht getriggert werden
		}

		if (eingabeString.equals("2") && raumNormal == true && spielerID.getWaffeSpielerZwischenSpeicher().eis1 == false
				&& spielerID.getWaffeSpielerZwischenSpeicher().eis2 == true) {
			System.out.println(
					"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
					.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
					+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 2;
			System.out.println("Deiner Waffe wurde " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 2
					+ " Schaden hinzugefügt!");
			System.out.println("Jetzt macht deine Waffe " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
					+ " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().eis1 = true;
			raumNormal = false; // Der Raum wird auf false gesetzt damit die anderen ifs nicht getriggert werden
		}
		if (eingabeString.equals("2") && raumNormal == true && spielerID.getWaffeSpielerZwischenSpeicher().eis1 == true
				&& spielerID.getWaffeSpielerZwischenSpeicher().eis2 == false) {
			System.out.println(
					"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
					.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
					+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4;
			System.out.println("Deiner Waffe wurde " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4
					+ " Schaden hinzugefügt!");
			System.out.println("Jetzt macht deine Waffe " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
					+ " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().eis2 = true;
			raumNormal = false; // Der Raum wird auf false gesetzt damit die anderen ifs nicht getriggert werden
		}
	}

	// Diese Methode überprüft und verändert die Zustände von Feuer in einem
	// Normalen Raum
	public void checkRaumNormalFeuer(String eingabeString, boolean raumNormal, Spieler spielerID) {
		// Bei diesen Kontrollstrukturen werden die zustände überprüft und verändert.
		// Wenn ein if
		// true ist, wird der neue Schaden in Abhängigkeit des aktuellen Raumes
		// ermittelt. Ein Normaler Raum hat keine Auswirkungen.
		// Der neue Schaden ergibt sich aus dem Aktuellen schaden (schadenWaffeReal) +
		// 1/4 bzw. 1/2 von dem Standartschaden (schadenWaffe) der Waffe
		if (eingabeString.equals("3") && raumNormal == true && spielerID.getWaffeSpielerZwischenSpeicher().feuer1 == false
				&& spielerID.getWaffeSpielerZwischenSpeicher().feuer2 == false) {
			if (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal != 0) {
				System.out.println("Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
						+ " Schaden!");
				spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
						.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4;
				System.out.println("Deiner Waffe wurde " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4
						+ " Schaden hinzugefügt!");
				System.out.println("Jetzt macht deine Waffe "
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			}
			if (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal == 0) {
				System.out.println(
						"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe + " Schaden!");
				spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
						.getWaffeSpielerZwischenSpeicher().schadenWaffe
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4;
				System.out.println("Deiner Waffe wurde " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4
						+ " Schaden hinzugefügt!");
				System.out.println("Jetzt macht deine Waffe "
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			}
			spielerID.getWaffeSpielerZwischenSpeicher().feuer2 = true;
			raumNormal = false; // Der Raum wird auf false gesetzt damit die anderen ifs nicht getriggert werden
		}
		if (eingabeString.equals("3") && raumNormal == true && spielerID.getWaffeSpielerZwischenSpeicher().feuer1 == false
				&& spielerID.getWaffeSpielerZwischenSpeicher().feuer2 == true) {
			System.out.println(
					"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
					.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
					+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 2;
			System.out.println("Deiner Waffe wurde " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 2
					+ " Schaden hinzugefügt!");
			System.out.println("Jetzt macht deine Waffe " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
					+ " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().feuer1 = true;
			raumNormal = false; // Der Raum wird auf false gesetzt damit die anderen ifs nicht getriggert werden
		}
		if (eingabeString.equals("3") && raumNormal == true && spielerID.getWaffeSpielerZwischenSpeicher().feuer1 == true
				&& spielerID.getWaffeSpielerZwischenSpeicher().feuer2 == false) {
			System.out.println(
					"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
					.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
					+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4;
			System.out.println("Deiner Waffe wurde " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4
					+ " Schaden hinzugefügt!");
			spielerID.getWaffeSpielerZwischenSpeicher().feuer2 = true;
			raumNormal = false; // Der Raum wird auf false gesetzt damit die anderen ifs nicht getriggert werden
		}

	}

	// Diese Methode überprüft und Verändert die Zustände von Eis und Feuer
	// Verbesserungen in
	// einem Eis Raum
	public void checkRaumEis(String eingabeString, boolean raumEis, Spieler spielerID) {
		spielerID.getWaffeSpielerZwischenSpeicher().checkRaumEisEis(eingabeString, raumEis, spielerID);
		spielerID.getWaffeSpielerZwischenSpeicher().checkRaumEisFeuer(eingabeString, raumEis, spielerID);
	}

	// Diese Methode überprüft und verändert die Zustände von Eis in einem Eisraum
	public void checkRaumEisEis(String eingabeString, boolean raumEis, Spieler spielerID) {
		// Bei diesen Kontrollstrukturen werden die zustände überprüft und verändert.
		// Wenn ein if
		// true ist, wird der neue Schaden in Abhängigkeit des aktuellen Raumes
		// ermittelt.
		// Der neue Schaden ergibt sich aus dem Aktuellen Schaden (waffeSchadenReal) +
		// 1/4 bzw. 1/2 von dem
		// Standartschaden (waffeSchaden) der Waffe .
		// Wenn man ein Eisupgrade in einem Eisraum macht, bekommt man einen Bonus von
		// +5!
		if (eingabeString.equals("2") && raumEis == true && spielerID.getWaffeSpielerZwischenSpeicher().eis1 == false
				&& spielerID.getWaffeSpielerZwischenSpeicher().eis2 == false) {
			if (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal != 0) {
				System.out.println("Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
						+ " Schaden!");
				spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
						.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 2 + 5; // ++5 weil man in einem
																							// Eisraum verbessert hat
				System.out.println("Deiner Waffe wurde "
						+ (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 2 + 5) + " Schaden hinzugefügt!");
				System.out.println("Jetzt macht deine Waffe "
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			}
			if (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal == 0) {
				System.out.println(
						"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe + " Schaden!");
				spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
						.getWaffeSpielerZwischenSpeicher().schadenWaffe
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 2 + 5; // ++5 weil man in einem
																							// Eisraum verbessert hat
				System.out.println("Deiner Waffe wurde "
						+ (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 2 + 5) + " Schaden hinzugefügt!");
				System.out.println("Jetzt macht deine Waffe "
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			}
			spielerID.getWaffeSpielerZwischenSpeicher().eis1 = true;
			raumEis = false;// Der Raum wird auf false gesetzt damit die anderen ifs nicht getriggert werden
		}
		if (eingabeString.equals("2") && raumEis == true && spielerID.getWaffeSpielerZwischenSpeicher().eis1 == false
				&& spielerID.getWaffeSpielerZwischenSpeicher().eis2 == true) {
			System.out.println(
					"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
					.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
					+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 2 + 5; // ++5 weil man in einem Eisraum
																						// verbessert hat
			System.out.println("Deiner Waffe wurde " + (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 2 + 5)
					+ " Schaden hinzugefügt!");
			System.out.println("Jetzt macht deine Waffe " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
					+ " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().eis1 = true;
			raumEis = false;// Der Raum wird auf false gesetzt damit die anderen ifs nicht getriggert werden
		}
		if (eingabeString.equals("2") && raumEis == true && spielerID.getWaffeSpielerZwischenSpeicher().eis1 == true
				&& spielerID.getWaffeSpielerZwischenSpeicher().eis2 == false) {
			System.out.println(
					"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
					.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
					+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4 + 5; // ++5 weil man in einem Eisraum
																						// verbessert hat
			System.out.println("Deiner Waffe wurde " + (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4 + 5)
					+ " Schaden hinzugefügt!");
			System.out.println("Jetzt macht deine Waffe " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
					+ " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().eis2 = true;
			raumEis = false;// Der Raum wird auf false gesetzt damit die anderen ifs nicht getriggert werden
		}
	}

	// Diese Methode überprüft und verändert die Zustände von Feuer in einem Eisraum
	public void checkRaumEisFeuer(String eingabeString, boolean raumEis, Spieler spielerID) {
		// Bei diesen Kontrollstrukturen werden die zuustände überprüft und verändert.
		// Wenn ein if
		// true ist, wird der neue Schaden in Abhängigkeit des aktuellen Raumes
		// ermittelt
		// Der neue Schaden ergibt sich aus dem Aktuellen Schaden (schadenWaffeReal) +
		// 1/4 bzw. 1/2 von dem
		// Standartschaden (schadenWaffe) der Waffe
		// Wenn man ein Feuerupgrade in einem Eisraum macht, bekommt man einen Abzug von
		// -5!

		if (eingabeString.equals("3") && raumEis == true && spielerID.getWaffeSpielerZwischenSpeicher().feuer1 == false
				&& spielerID.getWaffeSpielerZwischenSpeicher().feuer2 == false) {
			if (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal != 0) {
				System.out.println("Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
						+ " Schaden!");
				spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
						.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4 - 5; // --5 Weil man in einem
																							// Eisraum verbessert hat
				System.out.println("Deiner Waffe wurde "
						+ (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4 + -5) + " Schaden hinzugefügt!");
				System.out.println("Jetzt macht deine Waffe "
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			}
			if (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal == 0) {
				System.out.println(
						"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe + " Schaden!");
				spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
						.getWaffeSpielerZwischenSpeicher().schadenWaffe
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4 - 5; // --5 Weil man in einem
																							// Eisraum verbessert hat
				System.out.println("Deiner Waffe wurde "
						+ (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4 + -5) + " Schaden hinzugefügt!");
				System.out.println("Jetzt macht deine Waffe "
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			}
			spielerID.getWaffeSpielerZwischenSpeicher().feuer2 = true;
			raumEis = false;// Der Raum wird auf false gesetzt damit die anderen ifs nicht getriggert werden
		}
		if (eingabeString.equals("3") && raumEis == true && spielerID.getWaffeSpielerZwischenSpeicher().feuer1 == false
				&& spielerID.getWaffeSpielerZwischenSpeicher().feuer2 == true) {
			System.out.println(
					"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
					.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
					+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 2 - 5; // --5 Weil man in einem Eisraum
																						// verbessert hat
			System.out.println("Deiner Waffe wurde " + (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 2 + -5)
					+ " Schaden hinzugefügt!");
			System.out.println("Jetzt macht deine Waffe " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
					+ " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().feuer1 = true;
			raumEis = false;// Der Raum wird auf false gesetzt damit die anderen ifs nicht getriggert werden
		}
		if (eingabeString.equals("3") && raumEis == true && spielerID.getWaffeSpielerZwischenSpeicher().feuer1 == true
				&& spielerID.getWaffeSpielerZwischenSpeicher().feuer2 == false) {
			System.out.println(
					"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
					.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
					+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4 - 5; // --5 Weil man in einem Eisraum
																						// verbessert hat
			System.out.println("Deiner Waffe wurde " + (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4 + -5)
					+ " Schaden hinzugefügt!");
			System.out.println("Jetzt macht deine Waffe " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
					+ " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().feuer2 = true;
			raumEis = false;// Der Raum wird auf false gesetzt damit die anderen ifs nicht getriggert werden
		}
	}

	// Diese Methode überprüft und Verändert die Zustände von Eis und Feuer
	// Verbesserungen in
	// einem Feuerraum
	public void checkRaumFeuer(String eingabeString, boolean raumFeuer, Spieler spielerID) {
		spielerID.getWaffeSpielerZwischenSpeicher().checkRaumFeuerEis(eingabeString, raumFeuer, spielerID);
		spielerID.getWaffeSpielerZwischenSpeicher().checkRaumFeuerFeuer(eingabeString, raumFeuer, spielerID);
	}

	// Diese Methode überprüft und verändert die Zustände von Eis in einem Feuerraum
	public void checkRaumFeuerEis(String eingabeString, boolean raumFeuer, Spieler spielerID) {
		// Bei diesen Kontrollstrukturen werden die zustände überprüft und verändert.
		// Wenn ein if
		// true ist, wird der neue Schaden in Abhängigkeit des aktuellen Raumes
		// ermittelt.
		// Der neue Schaden ergibt sich aus dem Aktuellen schaden (schadenWaffeReal) +
		// 1/4 bzw. 1/2 von dem
		// Standartschaden (schadenWaffe) der Waffe
		// Wenn man ein Eisupgrade in einem Feuerraum macht, bekommt man einen Abzug von
		// -5!
		if (eingabeString.equals("2") && raumFeuer == true && spielerID.getWaffeSpielerZwischenSpeicher().eis1 == false
				&& spielerID.getWaffeSpielerZwischenSpeicher().eis2 == false) {
			if (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal != 0) {
				System.out.println("Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
						+ " Schaden!");
				spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
						.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4 - 5; // -5 Weil man in einem
																							// Feuerraum verbessert
				System.out.println("Deiner Waffe wurde "
						+ (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4 + -5) + " Schaden hinzugefügt!");
				System.out.println("Jetzt macht deine Waffe "
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			}
			if (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal == 0) {
				System.out.println(
						"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe + " Schaden!");
				spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
						.getWaffeSpielerZwischenSpeicher().schadenWaffe
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4 - 5;// -5 Weil man in einem
																							// Feuerraum verbessert
				System.out.println("Deiner Waffe wurde "
						+ (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4 + -5) + " Schaden hinzugefügt!");
				System.out.println("Jetzt macht deine Waffe "
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			}
			raumFeuer = false;
			spielerID.getWaffeSpielerZwischenSpeicher().eis2 = true;// Der Raum wird auf false gesetzt damit die anderen
																	// ifs nicht getriggert
			// werden
		}
		if (eingabeString.equals("2") && raumFeuer == true && spielerID.getWaffeSpielerZwischenSpeicher().eis1 == false
				&& spielerID.getWaffeSpielerZwischenSpeicher().eis2 == true) {
			System.out.println(
					"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
					.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
					+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 2 - 5; // -5 Weil man in einem Feuerraum
																						// verbessert
			System.out.println("Deiner Waffe wurde " + (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 2 + -5)
					+ " Schaden hinzugefügt!");
			System.out.println(
					"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			raumFeuer = false;
			spielerID.getWaffeSpielerZwischenSpeicher().eis1 = true;// Der Raum wird auf false gesetzt damit die anderen
																	// ifs nicht getriggert
			// werden
		}
		if (eingabeString.equals("2") && raumFeuer == true && spielerID.getWaffeSpielerZwischenSpeicher().eis1 == true
				&& spielerID.getWaffeSpielerZwischenSpeicher().eis2 == false) {
			System.out.println(
					"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
					.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
					+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4 - 5;// -5 Weil man in einem Feuerraum
																						// verbessert
			System.out.println("Deiner Waffe wurde " + (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4 + -5)
					+ " Schaden hinzugefügt!");
			System.out.println(
					"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().eis2 = true;
			raumFeuer = false;// Der Raum wird auf false gesetzt damit die anderen ifs nicht getriggert werden

		}

	}

	// Diese Methode überprüft und verändert die Zustände von Feuer in einem
	// Feuerraum
	public void checkRaumFeuerFeuer(String eingabeString, boolean raumFeuer, Spieler spielerID) {
		// Bei diesen Kontrollstrukturen werden die Zustände überprüft und verändert.
		// Wenn ein if
		// true ist, wird der neue Schaden in Abhängigkeit des aktuellen Raumes
		// ermittelt.
		// Der neue Schaden ergibt sich aus dem Aktuellen Schaden (schadenWaffeReal) +
		// 1/4 bzw. 1/2 von dem
		// Standartschaden (schadenWaffe) der Waffe.
		// Wenn man ein Feuerupgrade in einem Feuerraum macht, bekommt man einen Bonus
		// von
		// +5!
		if (eingabeString.equals("3") && raumFeuer == true && spielerID.getWaffeSpielerZwischenSpeicher().feuer1 == false
				&& spielerID.getWaffeSpielerZwischenSpeicher().feuer2 == false) {
			if (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal != 0) {
				System.out.println("Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
						+ " Schaden!");
				spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
						.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 2 + 5;// +5 weil man in einem
																							// Feuerraum verbessert
				System.out.println("Deiner Waffe wurde "
						+ (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 2 + 5) + " Schaden hinzugefügt!");
				System.out.println("Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
						+ " Schaden!");
			}
			if (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal == 0) {
				System.out.println(
						"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe + " Schaden!");
				spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
						.getWaffeSpielerZwischenSpeicher().schadenWaffe
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 2 + 5;// +5 weil man in einem
																							// Feuerraum verbessert
				System.out.println("Deiner Waffe wurde "
						+ (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 2 + 5) + " Schaden hinzugefügt!");
				System.out.println("Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
						+ " Schaden!");
			}
			spielerID.getWaffeSpielerZwischenSpeicher().feuer1 = true;
			raumFeuer = false;// Der Raum wird auf false gesetzt damit die anderen ifs nicht getriggert werden
		}
		if (eingabeString.equals("3") && raumFeuer == true && spielerID.getWaffeSpielerZwischenSpeicher().feuer1 == false
				&& spielerID.getWaffeSpielerZwischenSpeicher().feuer2 == true) {
			System.out.println(
					"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
					.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
					+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 2 + 5;// +5 weil man in einem Feuerraum
																						// verbessert
			System.out.println("Deiner Waffe wurde " + (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 2 + 5)
					+ " Schaden hinzugefügt!");
			System.out.println(
					"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().feuer1 = true;
			raumFeuer = true;// Der Raum wird auf false gesetzt damit die anderen ifs nicht getriggert werden
		}
		if (eingabeString.equals("3") && raumFeuer == true && spielerID.getWaffeSpielerZwischenSpeicher().feuer1 == true
				&& spielerID.getWaffeSpielerZwischenSpeicher().feuer2 == false) {
			System.out.println(
					"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
					.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
					+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4 + 5;// +5 weil man in einem Feuerraum
																						// verbessert
			System.out.println("Deiner Waffe wurde " + (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4 + 5)
					+ " Schaden hinzugefügt!");
			System.out.println(
					"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().feuer2 = true;
			raumFeuer = true;// Der Raum wird auf false gesetzt damit die anderen ifs nicht getriggert werden
		}
	}

	// Diese Methode überpfrüft und Verändert die Zustände voh Staerke
	public void checkStaerkeZustand(String eingabeString, Spieler spielerID) {
		// Diese Methode überprüft den Zustand von Staerke und verändert ihn. Hier
		// benötigt man nicht den Zustand jeglicher Räume, da Staerke Raumunabhängig
		// verbessert werden kann
		// Der neue Schaden ergibt sich aus dem Aktuellen schaden + 1/4 bzw. 1/2 von dem
		// Standartschaden der Waffe

		if (eingabeString.equals("1") && spielerID.getWaffeSpielerZwischenSpeicher().staerke1 == false
				&& spielerID.getWaffeSpielerZwischenSpeicher().staerke2 == false) {
			if (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal != 0) {
				System.out.println("Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
						+ " Schaden!");
				spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
						.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 2;
				System.out.println("Jetzt macht deine Waffe "
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			}
			if (spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal == 0) {
				System.out.println(
						"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe + " Schaden!");
				spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
						.getWaffeSpielerZwischenSpeicher().schadenWaffe
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 2;
				System.out.println("Jetzt macht deine Waffe "
						+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			}
			spielerID.getWaffeSpielerZwischenSpeicher().staerke1 = true;
			eingabeString = "0";
		}
		if (eingabeString.equals("1") && spielerID.getWaffeSpielerZwischenSpeicher().staerke1 == true
				&& spielerID.getWaffeSpielerZwischenSpeicher().staerke2 == false) {
			System.out.println(
					"Deine Waffe macht " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal + " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal = spielerID
					.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
					+ spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffe / 4;
			System.out.println("Jetzt macht deine Waffe " + spielerID.getWaffeSpielerZwischenSpeicher().schadenWaffeReal
					+ " Schaden!");
			spielerID.getWaffeSpielerZwischenSpeicher().staerke2 = true;
		}
	}

	// Diese Methode fasst die Oberen Methoden zu einem zusammen
	public void checkWieVielAngriffsSchadenDazuKommtSchwert(String eingabeString, boolean raumNormal, boolean raumEis,
			boolean raumFeuer, Spieler spielerID) {
		spielerID.getWaffeSpielerZwischenSpeicher().checkRaumNormal(eingabeString, raumNormal, spielerID);
		spielerID.getWaffeSpielerZwischenSpeicher().checkRaumEis(eingabeString, raumEis, spielerID);
		spielerID.getWaffeSpielerZwischenSpeicher().checkRaumFeuer(eingabeString, raumFeuer, spielerID);
		spielerID.getWaffeSpielerZwischenSpeicher().checkStaerkeZustand(eingabeString, spielerID);
	}

	// Diese Methode gibt den aktuellen Raum als String aus
	public void checkWelcherRaum(boolean raumFeuer, boolean raumEis, boolean raumNormal) {
		if (raumFeuer == true) {
			System.out.println("Du befindest dich in einem Feuerraum!");
		}
		if (raumEis == true) {
			System.out.println("Du befindest dich in einem Eisraum!");
		}
		if (raumNormal == true) {
			System.out.println("Du befindest dich in einem Normalen Raum!");
		}
	}

	public String setEingabeString(String eingabeString) {// Das ist ein fakeSetter. //Dieser setter nutzt man um die
															// SpielerEingabe "eingabeString" bei bedarf zu verändern
		if (eingabeString.equals("1")) {
			eingabeString = "2";
		}
		if (eingabeString.equals("2")) {
			eingabeString = "1";
		}
		return eingabeString;
	}

	public boolean getValueStaerke() {
		return spieler.getWaffeSpielerZwischenSpeicher().staerke1;
	}
}
