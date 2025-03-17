package metadatagroup;

import defaultpck.*;
import user.*;
import metadata.*;
import java.util.List;

import java.util.Scanner;

import metadata.audio;
import metadata.media;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class playlist extends media  {
   

	// Display all audios in the audioList
    
    public static void listAllAudios(List<audio> audioList) {
        System.out.println("All Audio Files:");
        for (audio aud : audioList) {
            System.out.println(aud.duration + " - " + aud.date + " - " + aud.quality + " - " + aud.creator);
            
        }
        }
   
    // Add an audio to the audioList
 public List<audio> Addaudio(List<audio> audioList) {
        Scanner z = new Scanner(System.in);
        try{
        System.out.println("Enter audio duration:");
        int duration = z.nextInt();
    
        System.out.println("Enter audio date:");
        String date = z.next();
    
        System.out.println("Enter size of audio:");
        String quality = z.next();
    
        System.out.println("Enter date created:");
        String creator = z.next();
    
        audio newAudio = new audio(duration, date, quality, creator);
    
        audioList.add(newAudio);}
          catch (InputMismatchException e) {
            System.out.println("Invalid input.");
           // scanner.next(); // Consume the invalid input
           e.printStackTrace();
        }
        return audioList;
    }
 }








    

