package user;

import javax.swing.*;

public class guest extends user {
	
    public static void main(String[] args) {
        welcomeGuest();
        
    }
    /**
     * Displays a welcome message for the guest.
     */
    public static void welcomeGuest() {
        JOptionPane.showMessageDialog(null, "Welcome Guest", "Guest", JOptionPane.INFORMATION_MESSAGE);
    }
}
