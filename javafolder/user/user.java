package user;
import metadatagroup.*;
import metadata.*;
import defaultpck.*;
import defaultpck.main;

import java.util.*;
import javax.print.attribute.standard.Media;

import metadata.Texto;
import metadata.audio;
import metadata.comments;
import metadata.image;
import metadata.video;
import metadatagroup.album;
import metadatagroup.playlist;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*public class user {
  public String email;
  public String password;
  public int id;
  public String usage;
  public int usage1;
  public String text;
  public String fileName;

 public void login()  {
    Scanner sc = new Scanner(System.in);
    System.out.println(
        "Hi, Press 1 if you are a staff, press 2 if you are a creator, and press 3 if you want just to explore");
    usage1 = sc.nextInt();
    if (usage1 == 1) {

      staff s = new staff();
   
      s.loginS();
    }
    if (usage1 == 2) {
    	creator c= new creator();

    c.loginC();

    
      }
    if (usage1 == 3) {
       // usage = "user";
    	guest g= new guest();
    	g.g();
    }

  }

  public void logout() {
    System.out.println("LOGGED OUT SUCCESSEFULY");
   
  }

  public void ChangePassword() {
    Scanner s = new Scanner(System.in);
    try{
    String oldPassword;
    int flag;
    String validpass;
    System.out.println("If you remember you old password press 1 , else press 2");
    flag = s.nextInt();
    if (flag == 1) {
      System.out.println("Enter your old password:");
      validpass = s.next();
      while (!validpass.equals(password)) {
        System.out.println("PASSWORD WRONG, re enter your old password");
        validpass = s.next();
      }
      oldPassword = password;
      System.out.println("Enter your new password:");

      password = s.next();
      System.out.println("your old password was : " + oldPassword);
      System.out.println("your new password is : " + password);

    }
    if (flag == 2) {
      System.out.println("a new link was sent to the following email to reset your password" + email);
      }}
      catch (InputMismatchException e) {
        System.out.println("Invalid input.");
       // scanner.next(); // Consume the invalid input
       e.printStackTrace();
    }

  }

  public void importAll(List<image> imageList2, List<audio> audioList, List<video> videoList2) {
    album alb = new album();
    playlist play = new playlist();

    System.out.println(
        "Please choose what you want to do:\n1. Import image\n2. Import video\n3. Import audio\n4. Import text\n");
    Scanner sc = new Scanner(System.in);
    try{
    int z = sc.nextInt();
    if (z == 1) {
      // List<image> imageList = main.loadDataIntoImageList();

      imageList2 = alb.Addimage(imageList2);

      alb.listAllimages(imageList2);
    } else if (z == 2) {
      // List<video> videoList = main.loadDataIntoVideoList();
      videoList2 = alb.addvideo(videoList2);
      alb.ListAllVideos(videoList2);
    } else if (z == 3) {
      // List<audio> audioList = audioList;
      audioList = play.Addaudio(audioList);
      play.listAllAudios(audioList);
    } else if (z == 4) {
      List<Texto> textList = main.loadDataIntoTextList();
      textList = Texto.AddText(textList);
      Texto.listAllTexts(textList);

    }}
    catch (InputMismatchException e) {
      System.out.println("Invalid input.");
     // scanner.next(); // Consume the invalid input
     e.printStackTrace();
  }

  }

  public void addCommentpic(List<image> imageList) {
    Scanner scanner = new Scanner(System.in);
    
    int flag = 0;


    System.out.println("Enter the index of the image to comment on:");
    int index = scanner.nextInt();
    try {
      if (index >= 0 && index < imageList.size()) {
        image im = imageList.get(index);

        System.out.println("Enter your comment:");
        String commentContent = scanner.next();

        comments comment = new comments(this.id, this.email, commentContent);

        System.out.println("Comment added successfully!");
      } else if (index < 0 && index < imageList.size()) {
        System.out.println("Invalid index. Comment addition failed.");
      }
    } catch (InputMismatchException e) {
      System.err.println("Invalid input. Please enter a valid index.");
      throw e;
    } catch (Exception e) {
      System.err.println("An unexpected error occurred: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public void addCommentvid(List<video> videolist1) {
    try{
    Scanner scanner = new Scanner(System.in);
    int flag = 0;

    System.out.println("Enter the index of the video to comment on:");
    int index = scanner.nextInt();

    if (index >= 0 && index < videolist1.size()) {
      video v = videolist1.get(index);

      System.out.println("Enter your comment:");
      String commentContent = scanner.next();

      comments comment = new comments(this.id, this.email, commentContent);

      System.out.println("Comment added successfully!");
    } else if (index < 0 && index < videolist1.size()) {
      System.out.println("Invalid index. Comment addition failed.");
      }}
      catch (InputMismatchException e) {
      System.err.println("Invalid input. Please enter a valid index.");
      throw e;
    } catch (Exception e) {
      System.err.println("An unexpected error occurred: " + e.getMessage());
      e.printStackTrace();
    }

  }

  public void addCommenttext(List<Texto> textlist1) {
    Scanner scanner = new Scanner(System.in);
    try{
    int flag = 0;

    System.out.println("Enter the index of the text to comment on:");
    int index = scanner.nextInt();

    if (index >= 0 && index < textlist1.size()) {
      Texto t = textlist1.get(index);

      System.out.println("Enter your comment:");
      String commentContent = scanner.next();

      comments comment = new comments(this.id, this.email, commentContent);

      System.out.println("Comment added successfully!");
    } else if (index < 0 && index < textlist1.size()) {
      System.out.println("Invalid index. Comment addition failed.");
    }}
    catch (InputMismatchException e) {
      System.err.println("Invalid input. Please enter a valid index.");
      throw e;
    } catch (Exception e) {
      System.err.println("An unexpected error occurred: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public void addCommentaudio(List<audio> audiolist1) {
    Scanner scanner = new Scanner(System.in);
  try{
    int flag = 0;

    System.out.println("Enter the index of the audio to comment on:");
    int index = scanner.nextInt();

    if (index >= 0 && index < audiolist1.size()) {
      audio a = audiolist1.get(index);

      System.out.println("Enter your comment:");
      String commentContent = scanner.next();

      comments comment = new comments(this.id, this.email, commentContent);

      System.out.println("Comment added successfully!");
    } else if (index < 0 && index < audiolist1.size()) {
      System.out.println("Invalid index. Comment addition failed.");
    }}
    catch (InputMismatchException e) {
      System.err.println("Invalid input. Please enter a valid index.");
      throw e;
    } catch (Exception e) {
      System.err.println("An unexpected error occurred: " + e.getMessage());
      e.printStackTrace();
    }
  }
*/


/*private boolean validateEmail(String email) {
  String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
  Pattern pattern = Pattern.compile(regex);
  Matcher matcher = pattern.matcher(email);
  return matcher.matches();
}*/


import javax.swing.JOptionPane;
import java.util.List;

public class user {
	 public String email;
	  public String password;
	  public int id;
	  public String usage;
	  public static int usage1;
	  public String text;
	  public String fileName;
	  /**
	     * Initiates the login process based on user type.
	     */
    public void login() {
        try {
            String userInput = JOptionPane.showInputDialog(null,
                    "Hi, Press 1 if you are a staff, press 2 if you are a creator, and press 3 if you want just to explore");
            usage1 = Integer.parseInt(userInput);
            if (usage1 == 1) {
                staff s = new staff();
                s.loginS();
            } else if (usage1 == 2) {
                creator c = new creator();
                c.loginC();
            } else if (usage1 == 3) {
                guest g = new guest();
                g.welcomeGuest();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
            e.printStackTrace();
        }
    }
    
    /**
     * Changes the password for staff and creator users.
     */

    public void ChangePassword() {
       if(usage1==1 || usage1==2) { try {
            String oldPassword;
            int flag;
            String validpass;
            
            flag = Integer.parseInt(JOptionPane.showInputDialog("If you remember your old password press 1, else press 2"));
            if (flag == 1) {
                validpass = JOptionPane.showInputDialog("Enter your old password:");
                while (!validpass.equals(password)) {
                    validpass = JOptionPane.showInputDialog("PASSWORD WRONG, re-enter your old password");
                }
                oldPassword = password;
                password = JOptionPane.showInputDialog("Enter your new password:");
                JOptionPane.showMessageDialog(null, "Your old password was: " + oldPassword
                        + "\nYour new password is: " + password);
            } else if (flag == 2) {
                JOptionPane.showMessageDialog(null, "A new link was sent to the following email to reset your password" + email);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
            e.printStackTrace();
        }}
       else if(usage1==3) {
    	   JOptionPane.showMessageDialog(null, "This is not available for you");
        }
    }
    /**
     * Imports media files for staff and creator users.
     */
    public void importAll(List<image> imageList2, List<audio> audioList, List<video> videoList2) {
    	if(usage1==1|| usage1==2) {
    	album alb = new album();
        playlist play = new playlist();

        System.out.println(
            "Please choose what you want to do:\n1. Import image\n2. Import video\n3. Import audio\n4. Import text\n");
        Scanner sc = new Scanner(System.in);
        try{
        int z = sc.nextInt();
        if (z == 1) {
          // List<image> imageList = main.loadDataIntoImageList();

          imageList2 = alb.Addimage(imageList2);

          alb.listAllimages(imageList2);
        } else if (z == 2) {
          // List<video> videoList = main.loadDataIntoVideoList();
          videoList2 = alb.addvideo(videoList2);
          alb.ListAllVideos(videoList2);
        } else if (z == 3) {
          // List<audio> audioList = audioList;
          audioList = play.Addaudio(audioList);
          play.listAllAudios(audioList);
        } else if (z == 4) {
          List<Texto> textList = main.loadDataIntoTextList();
          textList = Texto.AddText(textList);
          Texto.listAllTexts(textList);

        }}
        catch (InputMismatchException e) {
          System.out.println("Invalid input.");
         // scanner.next(); // Consume the invalid input
         e.printStackTrace();
      }}
    	else if(usage1==3) {
    		 JOptionPane.showMessageDialog(null, "This is not available for you");
    	}

      
    }
    /**
     * Adds comments to images for all users.
     */
    public void addCommentpic(List<image> imageList) {
    	  Scanner scanner = new Scanner(System.in);
    	    try{
    	    int flag = 0;

    	    System.out.println("Enter the index of the image to comment on:");
    	    int index = scanner.nextInt();

    	    if (index >= 0 && index < imageList.size()) {
    	      image t = imageList.get(index);

    	      System.out.println("Enter your comment:");
    	      String commentContent = scanner.next();

    	      comments comment = new comments(this.id, this.email, commentContent);

    	      System.out.println("Comment added successfully!");
    	    } else if (index < 0 && index < imageList.size()) {
    	      System.out.println("Invalid index. Comment addition failed.");
    	    }}
    	    catch (InputMismatchException e) {
    	      System.err.println("Invalid input. Please enter a valid index.");
    	      throw e;
    	    } catch (Exception e) {
    	      System.err.println("An unexpected error occurred: " + e.getMessage());
    	      e.printStackTrace();
    	    }
    	  }
    /**
     * Adds comments to videos for all users.
     */
    public void addCommentvid(List<video> videolist1) {
    	 try{
    		    Scanner scanner = new Scanner(System.in);
    		    int flag = 0;

    		    System.out.println("Enter the index of the video to comment on:");
    		    int index = scanner.nextInt();

    		    if (index >= 0 && index < videolist1.size()) {
    		      video v = videolist1.get(index);

    		      System.out.println("Enter your comment:");
    		      String commentContent = scanner.next();

    		      comments comment = new comments(this.id, this.email, commentContent);

    		      System.out.println("Comment added successfully!");
    		    } else if (index < 0 && index < videolist1.size()) {
    		      System.out.println("Invalid index. Comment addition failed.");
    		      }}
    		      catch (InputMismatchException e) {
    		      System.err.println("Invalid input. Please enter a valid index.");
    		      throw e;
    		    } catch (Exception e) {
    		      System.err.println("An unexpected error occurred: " + e.getMessage());
    		      e.printStackTrace();
    		    }

    		  }
    /**
     * Adds comments to text files for all users.
     */
    public void addCommenttext(List<Texto> textlist1) {
    	 Scanner scanner = new Scanner(System.in);
    	    try{
    	    int flag = 0;

    	    System.out.println("Enter the index of the text to comment on:");
    	    int index = scanner.nextInt();

    	    if (index >= 0 && index < textlist1.size()) {
    	      Texto t = textlist1.get(index);

    	      System.out.println("Enter your comment:");
    	      String commentContent = scanner.next();

    	      comments comment = new comments(this.id, this.email, commentContent);

    	      System.out.println("Comment added successfully!");
    	    } else if (index < 0 && index < textlist1.size()) {
    	      System.out.println("Invalid index. Comment addition failed.");
    	    }}
    	    catch (InputMismatchException e) {
    	      System.err.println("Invalid input. Please enter a valid index.");
    	      throw e;
    	    } catch (Exception e) {
    	      System.err.println("An unexpected error occurred: " + e.getMessage());
    	      e.printStackTrace();
    	    }
    	  }

    public void addCommentaudio(List<audio> audiolist1) {
    	Scanner scanner = new Scanner(System.in);
    	  try{
    	    int flag = 0;

    	    System.out.println("Enter the index of the audio to comment on:");
    	    int index = scanner.nextInt();

    	    if (index >= 0 && index < audiolist1.size()) {
    	      audio a = audiolist1.get(index);

    	      System.out.println("Enter your comment:");
    	      String commentContent = scanner.next();

    	      comments comment = new comments(this.id, this.email, commentContent);

    	      System.out.println("Comment added successfully!");
    	    } else if (index < 0 && index < audiolist1.size()) {
    	      System.out.println("Invalid index. Comment addition failed.");
    	    }}
    	    catch (InputMismatchException e) {
    	      System.err.println("Invalid input. Please enter a valid index.");
    	      throw e;
    	    } catch (Exception e) {
    	      System.err.println("An unexpected error occurred: " + e.getMessage());
    	      e.printStackTrace();
    	    }
    	  }


    	protected boolean validateEmail(String email) {
    		  String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    		  Pattern pattern = Pattern.compile(regex);
    		  Matcher matcher = pattern.matcher(email);
    		  return matcher.matches();
    		}

        public void logoutGUI() {
            JOptionPane.showMessageDialog(null, "Logout successful.", "Logout", JOptionPane.INFORMATION_MESSAGE);
        }

    		
    
}

