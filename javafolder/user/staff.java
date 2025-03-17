package user;
	
import metadatagroup.*;	
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
	
	public class staff extends user {
	    private JTextField idField;
	    private JTextField emailField;
	    private JPasswordField passwordField;
	    /**
	     * Initiates the staff login process.
	     */
	    public void loginS() {
	    	 JFrame frame = new JFrame("Staff Login");
	         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	         JPanel panel = new JPanel();
	         frame.getContentPane().add(panel);
	         placeComponents(panel);

	         frame.setSize(300, 200);
	         frame.setVisible(true);
	    }
	    /**
	     * Places components on the login panel.
	     * @param panel The panel on which components are placed.
	     */
	    private void placeComponents(JPanel panel) {
	        panel.setLayout(null);
	
	        JLabel idLabel = new JLabel("ID:");
	        idLabel.setBounds(10, 20, 80, 25);
	        panel.add(idLabel);
	
	        idField = new JTextField(20);
	        idField.setBounds(100, 20, 165, 25);
	        panel.add(idField);
	
	        JLabel emailLabel = new JLabel("Email:");
	        emailLabel.setBounds(10, 50, 80, 25);
	        panel.add(emailLabel);
	
	        emailField = new JTextField(20);
	        emailField.setBounds(100, 50, 165, 25);
	        panel.add(emailField);
	
	        JLabel passwordLabel = new JLabel("Password:");
	        passwordLabel.setBounds(10, 80, 80, 25);
	        panel.add(passwordLabel);
	
	        passwordField = new JPasswordField(20);
	        passwordField.setBounds(100, 80, 165, 25);
	        panel.add(passwordField);
	
	        JButton loginButton = new JButton("Login");
	        loginButton.setBounds(10, 110, 80, 25);
	        panel.add(loginButton);
	
	        loginButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                handleLogin();
	            }
	        });
	    }
	    /**
	     * Handles the login process.
	     */

	    private void handleLogin() {
	        try {
	            id = Integer.parseInt(idField.getText());
	            
	            boolean isValidID = false;
	            isValidID = checkStaffID(id);
	
	            if (isValidID==false) {
	                JOptionPane.showMessageDialog(null, "Invalid Staff ID. Please try again.");
	                return;
	            }
	
	            email = emailField.getText();
	            boolean validEmail = validateEmail(email);
	            if (!validEmail) {
	                JOptionPane.showMessageDialog(null, "Invalid email format. Please enter a valid email.");
	                return;
	            }
	
	            password = new String(passwordField.getPassword());
	
	            JOptionPane.showMessageDialog(null, "Login Successful!");
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(null, "Invalid ID format. Please enter a valid ID.");
	        }
	    }
	    /**
	     * Bans a user based on staff status.
	     * @param usage1 The usage status.
	     */
	public void ban(int usage1) {
		user.usage1=usage1;
		if(usage1==1) {
			String username = JOptionPane.showInputDialog("Please enter the name of the person you want to ban:");
	        String reason = JOptionPane.showInputDialog("Please enter the reason you want to ban that person:");

	        if (username != null && reason != null) {
	           
	            // User pressed Cancel or closed the dialog
	        	   JOptionPane.showMessageDialog(null, "User " + username + " banned for reason: " + reason);
	        } 
	        
	        
	    }		else { JOptionPane.showMessageDialog(null, "option available only for staff" );}
	}
	  /**
     * Validates an email address.
     * @param email The email address to validate.
     * @return True if the email is valid, false otherwise.
     */
	    protected boolean validateEmail(String email) {
	  	  String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	  	  Pattern pattern = Pattern.compile(regex);
	  	  Matcher matcher = pattern.matcher(email);
	  	  return matcher.matches();
	  	}
	    /**
	     * Checks the staff ID.
	     * @param id The staff ID to check.
	     * @return True if the staff ID is valid, false otherwise.
	     */
	  private boolean checkStaffID(int id) {
	      // Convert the StaffIDEnum values to an array
	      ids[] staffIDs = ids.values();
	
	      // Check if the provided ID is in the enum values
	      for (ids staffID : staffIDs) {
	          if (id == staffID.ordinal() ) {
	              return true;
	          }
	      }
	
	      return false;
	  }
	  }


