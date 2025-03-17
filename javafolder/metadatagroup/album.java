package metadatagroup;

import metadata.image;
import metadata.video;
import java.util.List;
import java.util.Scanner;
import defaultpck.*;
import metadata.*;
import user.*;
import metadata.media;


import java.util.ArrayList;
import java.util.InputMismatchException;

public class album extends media {
    
List<image> imageList;

//List<image> imageList = new ArrayList<>();
// Load data into the imageList

    public static List<image> loadDataIntoImageList() {
                
        
List<image> imageList;
imageList = new ArrayList<>();

        // Assuming you have some data to load into the imageList
        // You can modify this part based on your actual data source
        imageList.add(new image("Image1", "High", 1024, "2023-01-01"));
        imageList.add(new image("Image2", "Medium", 512, "2023-02-01"));
        imageList.add(new image("Image3", "Low", 256, "2023-03-01"));
        
        return(imageList);
    }
    // Add an image to the imageList
    public List<image> Addimage(List<image> imageList) {
        Scanner z = new Scanner(System.in);
    try{
        System.out.println("Enter image name:");
        String name = z.nextLine();
    
        System.out.println("Enter image quality:");
        String imagequa = z.nextLine();
    
        System.out.println("Enter size of image:");
        int size = z.nextInt();
    
        System.out.println("Enter date created:");
        String dateCreated = z.next();
    
        image newImage = new image(name, imagequa, size, dateCreated);
    
        imageList.add(newImage);}
        catch (InputMismatchException e) {
            System.out.println("Invalid input.");
           // scanner.next(); // Consume the invalid input
           e.printStackTrace();
        }
        return imageList;
    }
 // Display all images in the imageList
  public static void listAllimages(List<image> imageList) {
        System.out.println("All image Files:");
        for (image img : imageList) {
            System.out.println(img.name + " - " + img.imagequa + " - " + img.size + " - " + img.datecreated);
            
        }
    }




  // Load data into the videoList
      public static List<video> loadDataIntoVideoList() {
    List<video> videoList = new ArrayList<>();

        // Assuming you have some data to load into the imageList
        // You can modify this part based on your actual data source
        videoList.add(new video("High", 1024, "2023-01-01","Hamza",12));
        videoList.add(new video("Medium", 876,  "2023-02-01","Hamza",60));
        videoList.add(new video("Low", 99, "2023-03-01","Hamza",120));

        return videoList;
    }

    
   // Display all videos in the videoList

    public static void ListAllVideos(List<video> videolist){
        System.out.println("All videos files:");
        for(video vid : videolist){
            System.out.println(vid.vidqua+ " - " + vid.size + " - " + vid.datecreated + " - " + vid.creator + "-" + vid.duration);
        }}
   

        public static List<video> addvideo(List<video> videolist) {
            Scanner z = new Scanner(System.in);
            try{
    
            System.out.println("Enter video quality:");
            String vidqua = z.nextLine();
    
            System.out.println("Enter size of video:");
            int size = z.nextInt();
    
            System.out.println("Enter date created:");
            String dateCreated = z.next();
    
            System.out.println("Enter video creator:");
            String creator = z.next();
    
            System.out.println("Enter video duration:");
            int duration = z.nextInt();
    
            video newVideo = new video(vidqua, size, dateCreated, creator, duration);
                videolist.add(newVideo);
            }
            catch (InputMismatchException e) {
            System.out.println("Invalid input.");
           // scanner.next(); // Consume the invalid input
           e.printStackTrace();
        }

             return videolist;

}}
