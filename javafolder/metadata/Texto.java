package metadata;
import defaultpck.*;
import metadatagroup.*;
import user.*;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

import org.w3c.dom.Text;

public class Texto implements Serializable {
	// Constructor
    public Texto(String text, String fileName) {
    this.text=text;
    this.fileName=fileName;
    }

   

   public String text;
    public String fileName;


//Methods
    public static void listAllTexts(List<Texto> textList){
           System.out.println("All Text Files:");
        for ( Texto t: textList) {
            System.out.println(t.text + " - " + t.fileName + " - " );
            
        }



    }
    public static List<Texto> AddText(List<Texto> textList) {
        Scanner z = new Scanner(System.in);
        try{
        System.out.println("Enter the text:");
        String text = z.next();
    
        System.out.println("Enter the name of the file:");
        String fileName = z.next();
    
       
    
        Texto newText = new Texto(text,fileName);
    
        textList.add(newText);}
          catch (InputMismatchException e) {
            System.out.println("Invalid input.");
           // scanner.next(); // Consume the invalid input
           e.printStackTrace();
        }
        return textList;
    }
 }






