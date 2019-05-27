package org.protor.sandbox.Aromano.tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.protor.filesio.utils.XMLUtils;
import org.protor.sandbox.Aromano.Car;
import org.protor.sandbox.Aromano.EnumEngineType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Test03 {

	public static void main(String[] args) {

		// "C:\Users\PC5\demarco\github\java_examples_demarco\input"
		//File carsFile =new File("input"+File.separator + fileName);

		// String fileName = "cars.xml";

		if(args.length !=0) {
			// get the file name

			String filePath=args[0];
			File carsFile=new File(filePath);

			if(!carsFile.exists()) {
				System.err.println("File"+ carsFile.getAbsolutePath()+"not found.");
				System.exit(1);
			}

			System.out.println("found file:"+ carsFile.getAbsolutePath());
			System.out.println("---Now readin XML content...");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;

			//Document doc;

			try {
				dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(carsFile);

				System.out.println("File XML parsed.");

				doc.getDocumentElement().normalize();

				System.out.println("Root element:"+ doc.getDocumentElement().getNodeName());
				NodeList nodeList = doc.getElementsByTagName("car");
				System.out.println("N. cars:"+ nodeList.getLength());
				List<Car> cars = new ArrayList<>();


				for(int iNode=0; iNode < nodeList.getLength(); iNode++) {
					Node node = nodeList.item(iNode);
					System.out.println("\nCurrent Element :" + node.getNodeName());

					if(node.getNodeType()== Node.ELEMENT_NODE) {
						Element elem = (Element) node; //casting mi trasforma una variabile in un altra variabile
						NamedNodeMap attributesMap =elem.getAttributes();
						System.out.println("N.attributes:"+ attributesMap.getLength());
						System.out.println("Car id :"+ elem.getAttribute("id"));

						String carName= XMLUtils.getXMLPropertyByPath(node, "//name/text()");//XPATH cercami "name" ovunque si trovi e dammi il contenuto
						System.out.println("Car name:"+ carName);
						
						String passString= XMLUtils.getXMLAttributesByPath(node, "//passengers", "value").get(0);
						System.out.println("Passengers:"+passString);
						int pass= Integer.parseInt(passString);
						
						// task: create an object of class car...
						
						double range= Double.parseDouble(
								XMLUtils.getXMLAttributesByPath(node, "//range_km", "value").get(0)
								);
						System.out.println("Range (km):"+ range);
						
						EnumEngineType engineType;
					
						
					//	Car c= new Car();
								
								
					}
				}
			}

			catch(ParserConfigurationException e) {
				e.printStackTrace();

			}catch (SAXException e) {
				e.printStackTrace();
			}
			catch(IOException e){
				e.printStackTrace();
			}

		} else {
			System.err.println(
					"This program must be used with arguments!\n"+ "terminating.");
			System.exit(1);


		}

	}
}