package generated;

import generated.Kommentare.Kommentar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws JAXBException, FileNotFoundException, DatatypeConfigurationException {
		// zum Einlesen/ Ausgeben notwendige Objekte
		JAXBContext jaxbContext = JAXBContext.newInstance("generated"); 
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Scanner in = new Scanner(System.in);
						
		// Einlesen / unmarshalling
		Kochbuch chefkochbuch = (Kochbuch) unmarshaller.unmarshal(new File ("xml/aufgabe3d-data.xml"));		
						
		// Men�aufruf
		menue(in, chefkochbuch, jaxbContext);
	}
	
	public static void menue(Scanner in, Kochbuch chefkochbuch, JAXBContext jaxbContext) throws JAXBException
	{

		// Allgemeine Option-Auswahl
		int anzahl_rezepte = chefkochbuch.getRezept().size();
		System.out.println("\nDieses Buch enth�lt " + anzahl_rezepte + " Rezepte.");
		System.out.print("\nW�hlen Sie eine Option:\n\n1 - Rezept Ausgeben\n2 - Kommentar zum Rezept hinzuf�gen\n3 - Kochbuch schlie�en\n\nAuswahl:  ");
		int auswahl_option = in.nextInt();
		
		if (auswahl_option == 3)
			System.out.println("\n\nLassen Sie es sich schmecken! Bis bald.");
		else{
			
			// Rezeptauswahl
			System.out.print("W�hlen Sie ein Rezept: ");
			int auswahl_rezept = in.nextInt();
			
			if( (auswahl_rezept>anzahl_rezepte) || (auswahl_rezept<1))
			{
				System.out.println("Dieses Rezept existiert nicht. Geben Sie eine Zahl zwischen 1 und " + anzahl_rezepte + " ein." );
				menue(in, chefkochbuch, jaxbContext);
			}
			
			else{
				
				// Raussuchen des ausgew�hlten Rezeptes
				Rezept rezept = chefkochbuch.getRezept().get(0);
				for (int i = 0; i<anzahl_rezepte; i++)
				{
					if ( (i+1)==auswahl_rezept ) // i+1, da Indizes ab 0 gez�hlt werden, die Rezeptaufz�hlung jedoch ab 1
						rezept = chefkochbuch.getRezept().get(i);
				}
				
				System.out.println("\n\n____________________________________________________________");

				// Funktionsaufruf nach Optionswahl
				switch(auswahl_option)
				{
					case 1:
						ausgabe(rezept, in, chefkochbuch, jaxbContext); break;
					case 2:
						kommentar(rezept, in, chefkochbuch, jaxbContext); break;
					default:
						System.out.println("F�r die Auswahl der Option ist nur eine Eingabe von 1, 2 oder 3 erlaubt!");
						menue(in, chefkochbuch, jaxbContext);
				}
			}			
		}
	}
	
	public static void ausgabe(Rezept rezept, Scanner in, Kochbuch chefkochbuch, JAXBContext jaxbContext) throws JAXBException
	{
		// zur Hervorhebung des Rezeptitels
		String deko = "=================================================================================";
		
		// Allgemeine Daten zum Rezept
		System.out.println("\n\n======" + deko.substring(0, rezept.rezeptname.length()) +"======" );
		System.out.println("***** " + rezept.rezeptname + " *****");
		System.out.println("======" + deko.substring(0, rezept.rezeptname.length()) +"======" );
		System.out.println("\nRezept-ID:\t " + rezept.id);
		System.out.println("Portionen:\t " + rezept.portionen);
		
		// optionale Daten
		if(rezept.kcal!=null)
			System.out.println("Brennwert:\t " + rezept.kcal);
		if(rezept.schwierigkeit!=null)
			System.out.println("Schwierigkeit:\t " + rezept.schwierigkeit);
		if(rezept.kochBackzeit!=null)
			System.out.println("Koch-/Backzeit:\t " + rezept.kochBackzeit.stunde + " Stunde/n " + rezept.kochBackzeit.minute + " Minuten.");
		if(rezept.bilder!=null)
		{
			for(int j=0; j<rezept.bilder.getBild().size(); j++)
			{
				System.out.println("Bild von "+ rezept.bilder.getBild().get(j).user + ":\t " + rezept.bilder.getBild().get(j).bildUrl);
			}
		}
				
		// Zutaten
		System.out.println("\n-- Zutaten --");
		List<Zutaten.Zutat> zutaten = rezept.zutaten.getZutat();
		for (int j = 0; j<zutaten.size(); j++)
			System.out.println("*" + rezept.zutaten.getZutat().get(j).menge + " " + rezept.zutaten.getZutat().get(j).einheit + " " + rezept.zutaten.getZutat().get(j).zutatname);
				
		// Zubereitungsschritte
		System.out.println("\n-- Zubereitungsschritte --");
		List<String> schritte = rezept.getSchritte().getSchritt();
		for (int j = 0; j<schritte.size(); j++)
			System.out.println((j+1)+". " + schritte.get(j));
				
		// Kommentare
		System.out.println("\n-- Kommentare --");
		if (rezept.kommentare.getKommentar().isEmpty())
				System.out.println("Zur Zeit gibt es noch keine Kommentare.");
		else
			{
				List<Kommentar> kommis = rezept.kommentare.getKommentar();
				for (int j = 0; j<kommis.size(); j++)
				{
					System.out.println("\n" + kommis.get(j).nachricht);
					System.out.println("- Von " + kommis.get(j).user + " am " + kommis.get(j).uhrzeit);
				}
			}
		
		System.out.println("\n\n____________________________________________________________");
		menue(in, chefkochbuch, jaxbContext);
	}
	
	public static void kommentar(Rezept rezept, Scanner in, Kochbuch chefkochbuch, JAXBContext jaxbContext) throws JAXBException
	{
		if (rezept.kommentare.kommentar == null)
		{
			List<Kommentare.Kommentar> neueListe = new ArrayList<Kommentare.Kommentar>();
			rezept.kommentare.kommentar = neueListe;
		}
	
		// Einlesen des Kommentars
		System.out.print("\n\nIhr username: ");
		String username = in.next();
		in.nextLine();
		System.out.println("F�gen Sie einen Kommentar hinzu: ");
		String kommi = in.nextLine();

		// Hinzuf�gen der eingegebenen Informationen zum neu erstelltem Kommentarobjekt, XML-Baumstruktur wird erweitert
		Kommentare.Kommentar K = new Kommentare.Kommentar();
		K.setNachricht(kommi);
		K.setUser(username);
		
		// Datum/ Uhrzeit Speicherung
		GregorianCalendar kalender = new GregorianCalendar();
		kalender.setTime(new Date());
        XMLGregorianCalendar zeit;
        try {
        	zeit = DatatypeFactory.newInstance().newXMLGregorianCalendar(kalender);
            K.setUhrzeit(zeit);
        } catch (DatatypeConfigurationException e) {}
		

        // Hinzuf�gen des Kommentarobjekts zum aktuellem Rezept
		rezept.kommentare.kommentar.add(K);

		System.out.println("\n\n____________________________________________________________");
		
		// marshalling, persistente Speicherung der Kommentare
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.marshal(chefkochbuch, new File ("xml/aufgabe3d-data.xml"));
		
		menue(in, chefkochbuch, jaxbContext);
	}


}
