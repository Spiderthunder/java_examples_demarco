package org.protor.sandbox.Aromano.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test02 {

	public static void main(String[] args) {
		System.out.println("Input files will be read from dir:"+ System.getenv("INPUTS_DIR"));


		// "C:\Users\PC5\demarco\github\java_examples_demarco\input"
		//File carsFile =new File("input"+File.separator + fileName);

		// String fileName = "cars.xml";
		if(args.length !=0) {
			// get the file name

			String filePath=args[0];
			File carsFile=new File(filePath);


			// read file line-by-line
			FileReader fileReader;
			try {
				fileReader =new FileReader(carsFile);
				System.out.println("found file:"+ carsFile.getAbsolutePath());
				System.out.println("----------------------------");
				
				BufferedReader br= new BufferedReader(fileReader);
				String currentLine;
				int counter=0;
				while((currentLine= br.readLine()) != null) {
					System.out.println(++counter + ":"+ currentLine);
					
				}
				
				System.exit(0);
				
				
				
				
				
			} catch (FileNotFoundException e) {

				//	e.printStackTrace();
				if (!carsFile.exists()) {
					System.err.println(
							"File"+carsFile.getAbsolutePath()+"not found.\n"+"Terminating.");
					System.exit(1);
				}

			} catch (IOException e) {
				
				//e.printStackTrace();
				System.err.println("A problem occured with file"+ carsFile.getAbsolutePath()+"\n"+"Terminating.");
				System.exit(1);
			}


		} else {
			System.err.println("You must run this program with arguments. \n"+ "Terminating.");
			System.exit(1);
		}

	}
}