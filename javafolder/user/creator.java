package user;

import metadatagroup.*;
import metadata.*;
import defaultpck.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class creator extends user {
	  private JTextField emailField;
	  private JPasswordField passwordField;
	  
    Scanner z = new Scanner(System.in);
    public String name;
    public String imagequa;
    public int size;
    public String datecreated;
    /**
     * Logs in the creator user with email and password.
     */

    
    public void loginC() {
        boolean validEmail = false;

        while (!validEmail) {
            String emailInput = JOptionPane.showInputDialog(null, "Enter Email:");

            if (emailInput == null) {
                // User pressed Cancel or closed the dialog
                return;
            }

            validEmail = validateEmail(emailInput);

            if (!validEmail) {
                JOptionPane.showMessageDialog(null, "Invalid email format. Please enter a valid email.");
            } else {
                email = emailInput;
            }
        }

        String passwordInput = JOptionPane.showInputDialog(null, "Enter Password:");

        if (passwordInput == null) {
            // User pressed Cancel or closed the dialog
            return;
        }

        password = passwordInput;
        JOptionPane.showMessageDialog(null, "Login Successful!");
    }
    public void importImage()
    {
        System.out.println("imported successfully");
    }

    public void ImportVideo()
    {
 System.out.println();
    }

     public void ImportAudio()
    {
 System.out.println();
    }
     /**
      * Validates the format of an email address.
      *
      * @param email The email address to validate.
      * @return True if the email address is valid, otherwise false.
      */
protected boolean validateEmail(String email) {
  String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
  Pattern pattern = Pattern.compile(regex);
  Matcher matcher = pattern.matcher(email);
  return matcher.matches();
}

    
}
