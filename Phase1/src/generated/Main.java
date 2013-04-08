package generated;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws JAXBException, FileNotFoundException{

		// notwendige Objekte
		JAXBContext jaxbContext = JAXBContext.newInstance("generated"); 
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Scanner in = new Scanner(System.in);
				
		//Testdatensätze
		File buch1 = new File ("xml/aufgabe3d-datensatz1-neu.xml");
		File buch2 = new File ("xml/aufgabe3d-datensatz2-neu.xml");
				
		// Einlesen
		KochbuchTyp chefkochbuch = (KochbuchTyp) ((javax.xml.bind.JAXBElement) unmarshaller.unmarshal(buch1)).getValue();		
		
		//Menü
		menue(in, chefkochbuch);
				
	}
	
	public static void ausgabe(Scanner in, KochbuchTyp chefkochbuch)
	{
		//System.out.println("Anzahl der Rezepte in diesem Buch: " + chefkochbuch.getRezept().size());
		
		for (int i = 0; i<chefkochbuch.getRezept().size(); i++)
		{
			// Allgemeine Daten zum Rezept
			System.out.println("\n\n"+ "----" + chefkochbuch.getRezept().get(i).name + "----");
			System.out.println("Rezept-ID:\t " + chefkochbuch.getRezept().get(i).id);
			System.out.println("Portionen:\t " + chefkochbuch.getRezept().get(i).portionen);
			
			// Zutaten
			System.out.println("\n--Zutaten:--");
			List<ZutatTyp> zutaten = chefkochbuch.getRezept().get(i).getZutaten().getZutat();
			for (int j = 0; j<zutaten.size(); j++)
			{
				ZutatTyp zutat = zutaten.get(j);
				System.out.println("* \t " + zutat.menge + " " + zutat.einheit + " " + zutat.name);
			}
			
			// Zubereitungsschritte
			System.out.println("\n--Zubereitungsschritte--");
			List<String> schritte = chefkochbuch.getRezept().get(i).getSchritte().getSchritt();
			for (int j = 0; j<schritte.size(); j++)
			{
				System.out.println((j+1)+". " + schritte.get(j));
			}
			
			// Kommentare
			System.out.println("\n--Kommentare--");
			if (chefkochbuch.getRezept().get(0).getKommentar().isEmpty())
				System.out.println("Zut Zeit gibt es noch keine Kommentare.");
			else
			{
				List<String> kommis = chefkochbuch.getRezept().get(i).getKommentar();
				for (int j = 0; j<kommis.size(); j++)
				{
					System.out.println("Notiz " + (j+1)+ ": " +kommis.get(j));
				}
			}
			
			System.out.println("\n\n____________________________________________________________");
			menue(in, chefkochbuch);
		}
	}

	public static void menue(Scanner in, KochbuchTyp chefkochbuch)
	{
		System.out.print("\n\nWählen Sie eine Option:\n\n1 - Rezept Ausgeben\n2 - Kommentar zum Rezept hinzufügen\n3 - Kochbuch schließen\n\nAuswahl:  ");
		int auswahl = in.nextInt();
		
		switch(auswahl)
		{
			case 1:
				ausgabe(in, chefkochbuch); break;
			case 2:
				kommentar(in, chefkochbuch); break;
			case 3:
				System.out.println("\n\nLassen Sie es sich schmecken! Bis bald.");break;
			default:
				System.out.println("Es ist nur eine Eingabe von 1 oder 2 erlaubt!");
				menue(in, chefkochbuch);
		}

	}
	
	public static void kommentar(Scanner in, KochbuchTyp chefkochbuch)
	{
		System.out.println("\n\nFügen Sie einen Kommentar hinzu: ");
		in.nextLine();
		String kommi = in.nextLine();
		
		ObjectFactory neuer_kommi = new ObjectFactory();
		neuer_kommi.createKommentar(kommi);
		
		chefkochbuch.getRezept().get(0).getKommentar().add(kommi);
		
		System.out.println("\n\n____________________________________________________________");
		menue(in, chefkochbuch);
	}

}
