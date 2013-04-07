package com.w3schools;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class InputOutputMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// notwendige Objekte
		JAXBContext jaxbContext = JAXBContext.newInstance("com.w3schools"); 
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		
		// Eingabe
		KochbuchTyp chefkochbuch = (KochbuchTyp) unmarshaller.unmarshal(new File ("(:aufgabe3d-datensatz1.xml"));
		
		// Ausgabe
		for(int i=0; i<chefkochbuch.getRezept().size(); i++)
		{
			
		}

	}
	

}
