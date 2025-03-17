package defaultpck;
import javax.swing.*;
public class menu {
	 // Inner class named Menu
    class Menu{
    	 // Main method
       public static void main(String args[]){
    	   // Create a JFrame
          JFrame frame = new JFrame();

          // Create a JMenuBar
          JMenuBar menuBar = new JMenuBar();     //create menu bar.
          JMenu menu = new JMenu("A JMenu");          // create menu
     
          JMenuItem menuItem1 = new JMenuItem("text");
          menu.add(menuItem1);
         
          JMenuItem menuItem2 = new JMenuItem("images");
          menu.add(menuItem2);
     
          menu.addSeparator(); // line to separate different items types
          JRadioButtonMenuItem menuItem3 = new JRadioButtonMenuItem("files");
          menu.add(menuItem3);
     
          JRadioButtonMenuItem menuItem4 = new JRadioButtonMenuItem("folders");
          menu.add(menuItem4);
     
          menuBar.add(menu);          
          frame.setJMenuBar(menuBar);
       // Set JFrame properties
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setSize(400,400);  
          frame.setVisible(true);
       }
    }
    
}
