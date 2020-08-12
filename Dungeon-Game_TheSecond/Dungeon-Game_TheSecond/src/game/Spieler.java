package game;

import java.util.Scanner;



public class Spieler {

	// Eigenschaften
	private String nameSpieler;
	private int lebenSpieler;
	Waffe waffeSpieler; // Schwert
	Waffe waffeSpieler2; // Bogen
	 Waffe waffeSpielerZwischenSpeicher; // Dort werden die Informationen des WaffenObjekts zwischengespeichert
												// welches
	// für entweder, die Waffenkonfig oder die Gewählte kampfwaffe, verwendet wird.
	Gegner gegner;
	CustomArray inventar[]; // In dieser Klasse werden Anzahl und Name von Gegenständen gespeichert
							// In diesem Fall "Heiltrank" & "Gold"

	// Konstruktor
	public Spieler(String nameSpieler, int lebenSpieler) {
		this.nameSpieler = nameSpieler;
		this.lebenSpieler = lebenSpieler;

	}

	// Methoden

	public void angriff(Spieler spielerID, CustomArray heiltrankID, CustomArray goldID) { // Über die IDs kann auf das
																							// Objekt zugreifen

		// Diese Kontrollstruktur erkennt welcher gegner erstellt werden soll und
		// erstellt dieses Objekt
		gegnerAuswahl();

		// Hier wird der aktuelle Gegner ermittelt und dessen Stats herausgefunden

		System.out.println("=====================================\nDein aktueller Gegner: " + gegner.getName() + " hat "
				+ gegner.getLeben() + " Leben.");
		System.out.println(gegner.getName() + " hat die Waffe " + gegner.getWaffe().nameWaffe
				+ ".\nSie hat diese Stats:\nSchaden: " + gegner.getWaffe().schadenWaffe);

		// Hier läuft der eigentliche Angriff ab
		boolean angriff = true;
		/*
		 * Dieser boolean ist auf true wenn der Spieler angreifen will. Wenn der Spieler
		 * den Angriff abbricht wird sie auf false gesetzt. Wenn der Gegner besiegt wird
		 * wird sie auch auf false gesetzt. Damit der Gegnerangriff abgebrochen werden
		 * kann, this.lebenGegner übertragen und lebenGegner wird auf 0 gesetzt.
		 * 
		 */
		boolean waffeUmstellen = true;// Wenn dieser Bool auf False ist,
										// wird die WaffenKonifg aufgerufen
		while (angriff == true) {
			spielerID.checkWaffeHaltbarkeit();// Hier wird geprüft ob die Waffe vom Spieler nochh Haltbarkeit hat. Wenn
												// nicht wird sie durch ein Standartschwert ersetzt.

			// Erst wird abgefragt ob der Spieler angreifen will
			System.out.println(
					"===================================\nWillst du den Gegner angreifen?\n*Antworte mit\n[1]: Ja\n[2]: Nein");
			Scanner scan = new Scanner(System.in);
			String eingabeString = scan.nextLine();

			// Hier wird der angriff abgebrochen
			if (eingabeString.equals("2")) {
				System.out.println("Du hast den Angriff abgebrochen!\n=========================================");
				angriff = false;
			}

			// Wenn der Spieler den Gegner angreifen will, wird der Schaden der Spielerwaffe
			// ermittelt und dem Gegner vom Leben abgezogen
			else if (eingabeString.equals("1")) {
				if (waffeUmstellen == true) {		
					System.out.println("Waffenkonfig");
					Waffe waffe = new StandartSchwert();
					waffe.waffenKonfiguration(spielerID);
					waffe = null;
				}
				waffeUmstellen = false;

				// Nun bekommt der Spieler die möglichkeit sich seine Angriffswaffe auszusuchen.
				setWaffeSpielerAngriff(scan, spielerID);

				// Hier wird der Gegner Angegriffen. Ihm wird der Schaden der ausgewählten
				// angriffsWaffe angezogen
				gegner.setLeben(gegner.getLeben() - waffeSpielerZwischenSpeicher.schadenWaffe);
				System.out.println("=============================================\nDu hast dem Gegner "
						+ gegner.getName() + " " + waffeSpielerZwischenSpeicher.schadenWaffe + " Leben abgezogen!");

				// Hier wird überprüft ob der Gegner noch lebt
				// Wenn der Gegner tot ist...
				if (gegner.getLeben() <= 0) {

					angriff = false;

					System.out.println("Du hast den Gegner " + gegner.getName() + " besiegt!");
					this.waffeSpielerZwischenSpeicher.haltbarkeitWaffe = this.waffeSpielerZwischenSpeicher.haltbarkeitWaffe
							- gegner.spielerWaffeHaltbarkeitAbzug;
					System.out.println("Deiner Waffe " + this.waffeSpielerZwischenSpeicher.nameWaffe + " wurde "
							+ gegner.spielerWaffeHaltbarkeitAbzug + " Haltbarkeit abgezogen!");
					System.out.println("Deine Waffe " + this.waffeSpielerZwischenSpeicher.nameWaffe + " hat noch "
							+ this.waffeSpielerZwischenSpeicher.haltbarkeitWaffe + " Hatlbarkeit!");

					/*
					 * Nachdem die Haltbarkeit von waffeSpielerZwischenSpeicher abgezogen wurde,
					 * werden die Informationen von waffeSpielerZwischenSpeicher zurück in in die
					 * Urspüngliche ObjektWaffenVariable gespeichert
					 */
					ueberSchreibeWaffeSpielerZwischenSpeicherInGenommenesWaffenObjekt();

					System.out.println("Du hast " + goldID.getWertID() + " Gold!");
					System.out.println("Du hast " + gegner.goldFuerSpieler + " Gold bekommen!");
					goldID.setWertID(goldID.getWertID() + gegner.goldFuerSpieler); // Hier bekommt der Gegner die
																					// individuelle Goldmenge des
																					// GegnerObjektes
					System.out.println("Du hast " + goldID.getWertID() + " Gold!");

					// Hier kann der Spieler, die Waffe vom Gegner aufheben
					System.out.println("Willst du die Waffe vom Gegner aufheben?\n[1]: Ja\n[2]: Nein\nName: "
							+ gegner.getWaffe().nameWaffe + "\nSchaden: " + gegner.getWaffe().schadenWaffe);

					eingabeString = scan.nextLine();

					if (eingabeString.equals("2")) { // Der Spieler nimmt die Waffe nicht

						System.out.println("Du hast die Waffe nicht aufgehoben!");
					}
					// Der Spieler nimmt die Waffe
					if (eingabeString.equals("1")) {
						nimmWaffeVonGegner();
					}
				}
				// Wenn der gegner noch lebt...
				else if (gegner.getLeben() > 0) {

					System.out.println(gegner.getName() + " hat noch " + gegner.getLeben()
							+ " Leben!\n=============================================");

					// Danach kommt gleich der Angriff des Gegners in einer Methode.
					// Diese Methode erkennt die Lebenanzahl des Spieler und zieht den Schaden der
					// Gegnerwaffe vom Leben des Spielers ab
					gegner.angriff(spielerID, gegner);

					// Hier wird überprüft ob du noch Lebst
					// Wenn du noch lebst
					if (getLeben() > 0) {

						// Der Spieler kann sich auch Heilen
						// Erst wird überprüft Ob der Spieler heiltränke hat
						// Wenn er welche hat....
						if (heiltrankID.getWertID() > 0) {
							System.out.println("Willst du dich Heilen?\n[1]: Ja\n[2]: Nein");
							System.out.println("Du hast " + heiltrankID.getWertID() + " Heiltränke");
							eingabeString = scan.nextLine();

							// Wenn der Spieler nicht Heilen will
							if (eingabeString.equals("2")) {
								System.out.println("Du hast dich nicht geheilt!");

								// Wenn der Spieler sich heilen will
							} else if (eingabeString.equals("1")) {
								heilen(heiltrankID);
							}
						}
						// Wenn der Spieler tod ist.
					} else if (getLeben() <= 0) {
						System.out.println("Der Gegner " + gegner.getName() + " hat dich getötet! :(");
						angriff = false;
					}

				}
			}

		}
	}

	public void heilen(CustomArray heiltrankID) {
		if (heiltrankID.getWertID() > 0) {

			lebenSpieler = lebenSpieler + 10;
			heiltrankID.setWertID(heiltrankID.getWertID() - 1);
			System.out
					.println("=======================================\nDir wurde ein Heiltrank abgezogen. Du hast noch "
							+ heiltrankID.getWertID() + " Heiltränke!");
			System.out.println("Dir wurden 10 Leben hinzugefügt, du hast " + lebenSpieler + " Leben!");
		} else {

			System.out.println("===============================\nDu hast keine Heiltränke mehr!");
		}

	}

	public String getName() { // Um den Namen vom Spieler/ Gegner zu bekommen
		// TODO Auto-generated method stub
		return this.nameSpieler;
	}

	public int getLeben() { // Um die LP vom Gegner/ Spieler zu bekommen
		// TODO Auto-generated method stub
		return this.lebenSpieler;
	}

	public void setLeben(int neueLeben) { // Um nach angriffen oder nach dem Heilen die LP zu aktualisieren
		this.lebenSpieler = neueLeben;

	}

	public void setGegner(Gegner gegner) { // Um dem Spieler einen Gegner zuzuweisen
		this.gegner = gegner;
	}

	public void setWaffe(Waffe waffeSpieler) { // Hier wird dem Spieler eine Waffe zugewiesen

		this.waffeSpieler = waffeSpieler;
	}

	public void setWaffe2(Waffe waffeSpieler2) { // Hier wird dem Spieler eine Waffe zugewiesen

		this.waffeSpieler2 = waffeSpieler2;
	}

	public void checkWaffeHaltbarkeit() {
		// Für die Schwerter
		if (waffeSpieler.haltbarkeitWaffe <= 0) {

			StandartSchwert waffeSchwert = new StandartSchwert();
			System.out.println("Deine aktuelle Waffe " + waffeSpieler.nameWaffe
					+ " ist kaputt.\nDu bekommst als Standartwaffe ein " + waffeSchwert.nameWaffe + " mit "
					+ waffeSchwert.schadenWaffe + " Schaden!");
			this.waffeSpieler = waffeSchwert;
		}
		// Für den Bogen
		if (waffeSpieler2.haltbarkeitWaffe <= 0) {

			BambusBogen waffeBogen = new BambusBogen();
			System.out.println("Deine aktuelle Waffe " + waffeSpieler2.nameWaffe
					+ " ist kaputt.\nDu bekommst als Standartwaffe ein " + waffeBogen.nameWaffe + " mit "
					+ waffeBogen.schadenWaffe + " Schaden!");
			this.waffeSpieler2 = waffeBogen;
		}
	}

	public void showInventar(CustomArray goldID, CustomArray heiltrankID) {
		System.out.println("=======================\nDas ist dein Inventar:");

		System.out.println("Name Schwert: " + waffeSpieler.nameWaffe + "\nSchaden Schwert: " + waffeSpieler.schadenWaffe
				+ "\nName Bogen " + waffeSpieler2.nameWaffe + "\nSchaden Bogen: " + waffeSpieler2.schadenWaffe
				+ "\nHeilränke: " + heiltrankID.getWertID() + "\nGold: " + goldID.getWertID()
				+ "\n===============================");
	}

	public boolean auswahlMethode(CustomArray goldID, CustomArray heiltrankID, Spieler spielerID) {
		System.out.println(
				"Du kannst zwischen\n[1]: Angriff\n[2]: Heilen\n[3]: Inventar zeigen\n[4]: Neuer Raum\n[5]: Spiel beenden\nwählen!");
		boolean spielBeenden = false;

		Scanner scanner = new Scanner(System.in);
		String eingabeString = scanner.nextLine();

		while (spielBeenden == false) {
			switch (eingabeString) {
			case "1": {
				// Angriff
				angriff(spielerID, heiltrankID, goldID);
				return spielBeenden = false;
			}
			case "2": {
				// Heilen
				heilen(heiltrankID);
				return spielBeenden = false;
			}
			case "3": {
				// Inventar zeigen
				showInventar(goldID, heiltrankID);
				return spielBeenden = false;
			}
			case "4": {
				// Neuen Raum erstellen
				erstelleRaum(goldID, heiltrankID);
				auswahlMethode(goldID, heiltrankID, spielerID);
				return spielBeenden = false;
			}
			case "5": {
				// Um die Spielschleife zu stoppen
				spielBeenden = true;
				return spielBeenden;
			}
			}
		}
		return spielBeenden = false;
	}

	public void erstelleRaum(CustomArray goldID, CustomArray heiltrankID) { // In dieser Methode wird durch zufall ein
																			// Raum und/oder ein Händler erstellt
		System.out.println("Du betrittst einen neuen Raum!");

		// Zufällige (25%) erstellung einer Kiste mit Gold und Heiltrank
		int min = 1;
		int max = 4;
		int zufallsZahlKiste = min + (int) (Math.random() * ((max - min) + 1));// Zufallszahl wird generiert

		// Hier bekommt der Spieler Gold
		if (zufallsZahlKiste == 1) {

			System.out.println("========================\nDu hast eine Kiste gefunden!");
			System.out.println("Du hast 5 Gold bekommen!");
			goldID.setWertID(goldID.getWertID() + 5);
			System.out.println("Du hast jetzt " + goldID.getWertID() + " Gold\n---------------------------");

			// Hier bekommt der Spieler einen Heiltrank
			System.out.println("Du hast einen Heiltrank bekommen!");
			heiltrankID.setWertID(heiltrankID.getWertID() + 1);
			System.out.println(
					"Du hast jetzt " + heiltrankID.getWertID() + " Heiltränke!\n=============================");

		} else
			System.out.println("In diesem Raum gibt es keine Kiste!");

		// Zufällige (20%) erstellung eines Händlers der Waffen oder Heiltränke für Gold
		// verkauft
		boolean kauf = true; // Durch diesen bool kann man nach z.B. einem Heiltrankkauf einen weiteren
								// kaufen, oder wenn man nicht genug geld für das DiaSchwert hat, einen
								// heiltrank kaufen
		int min2 = 1;
		int max2 = 5;
		int zufallsZahlhaendler = min2 + (int) (Math.random() * ((max2 - min2) + 1));

		while (kauf == true) {
			if (zufallsZahlhaendler != 1) {
				System.out.println("In diesem Raum gibt es keinen Händler!\n========================================");
				kauf = false;
			}
			if (zufallsZahlhaendler == 1) {

				System.out.println("============================\nDu hast einen Händler gefunden!");
				System.out.println("Du hast " + goldID.getWertID() + " Gold!");
				System.out.println(
						"Du kannst Heiltränke 15 Gold, ein Schwert oder einen Bogen kaufen\nDas Schwert ist ein Diamant Schwert mit 18 Schaden und 3 Haltbarkeit 40 Gold\n"
								+ "Der Bogen ist ein Diamant Bogen mit 20 Schaden und 4 Haltbarkeit 50 Gold.");
				System.out.println(
						"[1]: Schwert\n[2]: Bogen\n[3]: Heiltrank\n[4]: Abbrechen\n====================================");
				Scanner scan = new Scanner(System.in);
				String eingabeString = scan.nextLine();

				// Hier wird gekauft
				// Hier wird das Schwert gekauft
				if (eingabeString.equals("1")) {
					// Erst muss geprüft werden ob der Spieler genug gold hat
					if (goldID.getWertID() >= 40) {

						System.out.println(
								"=======================================\nDu hast das Diamantschwert gekauft!");
						goldID.setWertID(goldID.getWertID() - 40);
						System.out
								.println("Dir wurden 40 Gold abgezogen. Du hast noch " + goldID.getWertID() + " Gold!");
						DiaSchwert diaSchwert = new DiaSchwert(); // Hier wird das DiaObjekt erstellt. Das DiaObjekt
																	// wird
																	// mit dem aktuellen WaffenObjekt des Spielers
																	// ausgetauscht
						this.waffeSpieler = diaSchwert;
						System.out.println("Dein Schwert: " + this.waffeSpieler.nameWaffe + "\nSchaden: "
								+ this.waffeSpieler.schadenWaffe);

					} else {

						System.out.println("Du hast nicht genug Gold für das Schwert!");
					}

				}
				if (eingabeString.equals("2")) {
					// Erst muss geprüft werden ob der Spieler genug gold hat
					if (goldID.getWertID() >= 50) {

						System.out
								.println("=======================================\nDu hast den Diamant Bogen gekauft!");
						goldID.setWertID(goldID.getWertID() - 50);
						System.out
								.println("Dir wurden 50 Gold abgezogen. Du hast noch " + goldID.getWertID() + " Gold!");
						DiaBogen diaBogen = new DiaBogen(); // Hier wird das DiaObjekt erstellt. Das DiaObjekt
															// wird
															// mit dem aktuellen WaffenObjekt des Spielers
															// ausgetauscht
						this.waffeSpieler2 = diaBogen;
						System.out.println("Dein Bogen: " + this.waffeSpieler2.nameWaffe + "\nSchaden: "
								+ this.waffeSpieler2.schadenWaffe);

					} else {

						System.out.println("Du hast nicht genug Gold für den Bogen!");
					}

					// Hier wird der Heiltrank gekauft
				} else if (eingabeString.equals("3")) {
					// Erst muss geprüft werden ob der Spieler genug gold hat
					if (goldID.getWertID() >= 15) {

						System.out.println("=========================\nDu hast einen Heiltrank gekauft");
						heiltrankID.setWertID(heiltrankID.getWertID() + 1);// Hier wird der Heiltrank hinzugefügt
						goldID.setWertID(goldID.getWertID() - 15);// Hier wird das Gold abgezogen
						System.out.println("Du hast jetzt " + heiltrankID.getWertID() + " Heiltränke!");
						System.out.println("Dir wurden 15 Gold abgezogen. Du hast noch " + goldID.getWertID()
								+ " Gold!\n==============================================");

					} else {

						System.out.println("Du hast nicht genug Gold!");
					}
				} else if (eingabeString.equals("4")) {

					System.out.println("Du hast den Einkauf abgebrochen!\n=============================");
					kauf = false;
				}

			}
		}
	}

	public void setWaffeSpielerZwischenSpeicher(Waffe waffeSpielerZwischenSpeicher, Spieler spielerID) { // Hier ist der setter für
																						// waffeSpielerZischenSpieler
		spielerID.waffeSpielerZwischenSpeicher = waffeSpielerZwischenSpeicher; // Einsatz -> waffenKonfig oder
																			// kampfwaffenAuswahl
	}

	public Waffe getWaffeSpielerZwischenSpeicher() { // Dieser getter wird gebraucht um die ReferenzID von
		return this.waffeSpielerZwischenSpeicher; // waffeSpielerZwischenSpeicher zu finden
	}

	public void ueberSchreibeWaffeSpielerZwischenSpeicherInGenommenesWaffenObjekt() { // Diese Methode überschreibt
		/*
		 * Diese Methode überschreit die die Zwischengespeicherten Informationen der
		 * Variable waffeSpielerZwischenSpeicher in die passende ObjektVariable.
		 * 
		 * Sie kann aber auch den Typ (Bogen oder Schwert) der waffeGegner erkennen und
		 * in die passende ObjektVariable speichern.
		 */
		// Bei Spieler Waffen
		if (getWaffeSpielerZwischenSpeicher() == waffeSpieler) {
			setWaffe(getWaffeSpielerZwischenSpeicher());
		}
		if (getWaffeSpielerZwischenSpeicher() == waffeSpieler2) {
			setWaffe2(getWaffeSpielerZwischenSpeicher());
		}
		
	}
		
	public void nimmWaffeVonGegner() {
		/*
		 * Bei Gegner Waffen Wenn man den Gegner getötet hat, kann man seine Waffe
		 * looten. Wenn man das macht, erkennt dieser Teil der Methode den Typ der
		 * gegnerWaffe (Bogen oder Schwert) und speichert es in die passende
		 * ObjektVariable.
		 */
		// Schwertern
		if (gegner.waffeGegnerBogenOSchwert == true) {
			setWaffe(gegner.waffeGegner);
			System.out.println("Du hast die Waffe vom Gegner aufgehoben!");
		}
		// Bogen
		if (gegner.waffeGegnerBogenOSchwert == false) {
			setWaffe2(gegner.waffeGegner);
			System.out.println("Du hast die Waffe vom Gegner aufgehoben!");
		}
	}


	public void setWaffeSpielerAngriff(Scanner scan, Spieler spielerID) {
		/*
		 * Diese Methode gibt dem Spieler die Möglichkeit sich eine Waffe, am anfang
		 * jeder Attacke, auszusuchen. Diese Waffe wird in waffeSpielerZwischenSpeicher
		 * gespeichert.
		 */
		System.out.println("Mit welcher Waffe willst du angreifen?\n" + "[1]Schwert: " + waffeSpieler.nameWaffe
				+ "\n Schaden Real: " + waffeSpieler.schadenWaffeReal + "/ Schaden Standart" + waffeSpieler.schadenWaffe + "\n" + "[2]Bogen: " + waffeSpieler2.nameWaffe
				+ "\nSchaden Real:" + waffeSpieler2.schadenWaffeReal + "/ Schaden Standart" + "/" + waffeSpieler2.schadenWaffe );
		String eingabeString = scan.nextLine();
		switch (eingabeString) {
		case "1": {
			setWaffeSpielerZwischenSpeicher(waffeSpieler, spielerID);
			break;
		}
		case "2": {
			setWaffeSpielerZwischenSpeicher(waffeSpieler2, spielerID);
			break;
		}
		}
	}

	public void waffenKonfig(Spieler spielerID) {
		spielerID.waffeSpieler.waffenKonfiguration(spielerID);
	}
	
	public void gegnerAuswahl() {
		// Hier kommt ein zufallsgenerator der entscheiden soll welcher gegner erstellt
		// wird
		int min = 1;
		int max = 6;
		int zufallsZahl = min + (int) (Math.random() * ((max - min) + 1));

		// Diese Kontrollstruktur erkennt welcher gegner erstellt werden soll und
		// erstellt dieses Objekt
		Gegner gegner = null;// Hier wird das Gegner Objekt erstellt

		// Hier wird GegnerOlaf erstellt
		if (zufallsZahl == 1) {
			gegner = new GegnerOlaf();
			setGegner(gegner);
		}
		// Hier wird GegnerJürgen erstellt
		if (zufallsZahl == 2) {
			gegner = new GegnerJuergen();
			setGegner(gegner);
		}
		// Hier wird GegnerDieter erstellt
		if (zufallsZahl == 3) {
			gegner = new GegnerDieter();
			setGegner(gegner);
		}
		// Hier wird Gegner Beber erstellt
		if (zufallsZahl == 4) {
			gegner = new GegnerBeber();
			setGegner(gegner);
		}
		// Hier Wird Gegner Flaga erstellt
		if (zufallsZahl == 5) {
			gegner = new GegnerFlaga();
			setGegner(gegner);
		}
		// Hier wrird Gegner Wardo erstellt
		if (zufallsZahl == 6) {
			gegner = new GegnerWardo();
			setGegner(gegner);
		}

	}
}