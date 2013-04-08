package generated;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws JAXBException, FileNotFoundException{
		// TODO Auto-generated method stub
		// notwendige Objekte
		JAXBContext jaxbContext = JAXBContext.newInstance("generated"); 
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Scanner in = new Scanner(System.in);
				
		//Testdatensätze
		File buch1 = new File ("xml/aufgabe3d-datensatz1.xml");
		File buch2 = new File ("xml/aufgabe3d-datensatz2.xml");
				
		// Einlesen
		KochbuchTyp chefkochbuch = (KochbuchTyp) ((javax.xml.bind.JAXBElement) unmarshaller.unmarshal(buch1)).getValue();		
		
		//Menü
		menue(in, chefkochbuch);
				
	}
	public static void ausgabe(KochbuchTyp chefkochbuch)
	{
		System.out.println("Anzahl der Rezepte in diesem Buch: " + chefkochbuch.getRezept().size());
		
		for (int i = 0; i<chefkochbuch.getRezept().size(); i++)
		{
			// Allgemeine Daten zum Rezept
			System.out.println("Rezept-ID: " + chefkochbuch.getRezept().get(i).id);
			System.out.println("Name: " + chefkochbuch.getRezept().get(i).name);
			System.out.println("Portionen: " + chefkochbuch.getRezept().get(i).portionen);
			
			// Zutaten
			List<ZutatTyp> zutaten = chefkochbuch.getRezept().get(i).getZutaten().getZutat();
			for (int j = 0; j<zutaten.size(); j++)
			{
				ZutatTyp zutat = zutaten.get(i);
				System.out.println("Zutat: " + zutat.name + "Menge: " + zutat.menge + zutat.einheit);
			}
			
			// Zubereitungsschritte
			List<String> schritte = chefkochbuch.getRezept().get(i).getSchritte().getSchritt();
			for (int j = 0; j<schritte.size(); j++)
			{
				System.out.println((j+1)+".: " + schritte.get(j));
			}
			
			// Kommentare
			
		}
	}

	public static void menue(Scanner in, KochbuchTyp chefkochbuch)
	{
		System.out.print("Geben Sie 1 für die Ausgabe des Rezept ein und 2 um ihm ein Kommentar hinzuzufügen: ");
		int auswahl = in.nextInt();
		
		switch(auswahl)
		{
			case 1:
				ausgabe(chefkochbuch); break;
			case 2:
				kommentar(in, chefkochbuch); break;
			default:
				System.out.println("Es ist nur eine Eingabe von 1 oder 2 erlaubt!");
				menue(in, chefkochbuch);
		}

	}
	
	public static void kommentar(Scanner in, KochbuchTyp chefkochbuch)
	{
		System.out.println("Geben Sie Ihren Kommentar ein: ");
		String kommi = in.next();
		in.nextLine();
		
		ObjectFactory neuer_kommi = new ObjectFactory();
		neuer_kommi.createKommentar(kommi);
		
		chefkochbuch.getRezept().get(0).getKommentar().add(kommi);
		
		menue(in, chefkochbuch);
	}

}
