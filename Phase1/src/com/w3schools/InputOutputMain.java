package com.w3schools;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.Node;

public class InputOutputMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// notwendige Objekte
		JAXBContext jaxbContext = JAXBContext.newInstance("com.w3schools"); 
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		
		//Testdatensätze
		File buch1 = new File ("xml/aufgabe3d-datensatz1.xml");
		File buch2 = new File ("xml/aufgabe3d-datensatz2.xml");
		
		// Eingabe
		KochbuchTyp chefkochbuch = (KochbuchTyp) unmarshaller.unmarshal(buch1);
		
		// Ausgabe
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
		}

	}
	

}
