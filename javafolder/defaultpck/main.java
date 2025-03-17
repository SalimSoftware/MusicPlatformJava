package defaultpck;
import java.io.*;
import java.util.*;
import metadata.*;
import metadatagroup.*;
import user.*;
import javax.swing.*;
import org.w3c.dom.Text;
import metadata.Texto;
import metadata.audio;
import metadata.image;
import metadata.video;
import metadatagroup.album;
import metadatagroup.playlist;
import user.staff;
import user.user;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.*;
import java.util.List;

public class main {
    private static int flaglog = 2;
    private static JFrame frame;
    private static List<image> imageList;
    private static List<video> videoList;
    private static List<audio> audioList;
    private static List<Texto> textList;
    
    /*
     * The main method to launch the Media App.
     */
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());

        // Initialize data
        imageList = loadDataIntoImageList();
        videoList = loadDataIntoVideoList();
        audioList = loadDataIntoAudioList();
        textList = loadDataIntoTextList();
        imageList = loadListFromFile("data/imageList.ser");
        videoList = loadListFromFile("data/videoList.ser");
        audioList = loadListFromFile("data/audioList.ser");
        textList = loadListFromFile("data/textList.ser");
        saveListToFile(imageList, "data/imageList.ser");
        saveListToFile(videoList, "data/videoList.ser");
        saveListToFile(audioList, "data/audioList.ser");
        saveListToFile(textList, "data/textList.ser");
       
    }
    /*
     * Creates and shows the GUI for the Media App.
     */
    private static void createAndShowGUI() {
        frame = new JFrame("Media App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        frame.add(panel);

        // Add an image
        ImageIcon icon = new ImageIcon("C:\\Users\\selgh\\Downloads\\image.png");
        JLabel imageLabel = new JLabel(icon);
        panel.add(imageLabel);

        placeComponents(panel);

        frame.setVisible(true);
    }
    /*
     * Places components on the GUI panel, including buttons and their actions.
     */
    private static void placeComponents(JPanel panel) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        Color lightBlue = new Color(173, 216, 230);  // Light Blue
        Color lightGreen = new Color(144, 238, 144); // Light Green
        Color lightYellow = new Color(255, 255, 224); // Light Yellow
        Color lightPurple = new Color(221, 160, 221); // Light Purple
        Color lightOrange = new Color(255, 218, 185); // Light Orange
        Color lightCyan = new Color(224, 255, 255);  // Light Cyan
        Color lightPink = new Color(255, 182, 193);   // Light Pink
        Color lightGray = new Color(211, 211, 211);   // Light Gray
        
        JButton loginButton = createButton("Login", lightBlue);
        JButton logoutButton = createButton("Logout", lightGreen);
        JButton changePasswordButton = createButton("Change Password", lightGray);
        JButton exploreButton = createButton("Explore", lightCyan);
        JButton exitButton = createButton("Exit", lightYellow);

        panel.add(Box.createVerticalGlue());
        panel.add(loginButton);
        panel.add(logoutButton);
        panel.add(changePasswordButton);
        panel.add(exploreButton);
        panel.add(exitButton);
        panel.add(Box.createVerticalGlue());

        exploreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showExploreMenu();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user u = new user();
                u.login();
                try {
					flaglog=0;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user u = new user();
                if (flaglog==0) {
                u.logoutGUI();}
                else {
                    JOptionPane.showMessageDialog(null, "Please login before any task", "Login Required", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user u = new user();
                if(flaglog==0) {
                u.ChangePassword();}
                else {
                    JOptionPane.showMessageDialog(null, "Please login before any task", "Login Required", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("THLAAAAAA :)");
                System.exit(0);
            }
        });
    }
    /*
     * Creates a JButton with a specified label and background color.
     */
    private static JButton createButton(String label, Color bgColor) {
        JButton button = new JButton(label);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(150, 50));
        button.setBackground(bgColor);
        button.setFocusPainted(false);
        return button;
    }
    /*
     * Shows the Explore Menu GUI.
     */
    private static void showExploreMenu() {
    	if(flaglog==0) {
        JFrame exploreFrame = new JFrame("Explore Menu");
        exploreFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        exploreFrame.setSize(600, 400);

        JPanel panel = new JPanel();
        exploreFrame.add(panel);

        Color lightBlue = new Color(173, 216, 230);  // Light Blue
        Color lightGreen = new Color(144, 238, 144); // Light Green
        Color lightYellow = new Color(255, 255, 224); // Light Yellow
        Color lightPurple = new Color(221, 160, 221); // Light Purple
        Color lightOrange = new Color(255, 218, 185); // Light Orange
        Color lightCyan = new Color(224, 255, 255);  // Light Cyan
        Color lightPink = new Color(255, 182, 193);   // Light Pink
        Color lightGray = new Color(211, 211, 211);   // Light Gray
        
        JButton listAudiosButton = createButton("List All Audios",lightBlue);
        JButton listVideosButton = createButton("List All Videos", lightGreen);
        JButton listImagesButton = createButton("List All Images", lightYellow);
        JButton listTextsButton = createButton("List All Texts", lightPurple);
        JButton postButton = createButton("Post", lightOrange);
        JButton commentImageButton = createButton("Comment on Image", lightCyan);
        JButton commentVideoButton = createButton("Comment on Video",lightPink);
        JButton commentTextButton = createButton("Comment on Text", lightGray);
        JButton commentAudioButton = createButton("Comment on Audio", lightBlue);
        JButton banButton = createButton("Ban", lightCyan);

       
        JButton returnButton = createButton("Return to Main Menu", lightPink);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalGlue());
        panel.add(listAudiosButton);
        panel.add(listVideosButton);
        panel.add(listImagesButton);
        panel.add(listTextsButton);
        panel.add(postButton);
        panel.add(returnButton);
        panel.add(commentImageButton);
        panel.add(commentVideoButton);
        panel.add(commentTextButton);
        panel.add(commentAudioButton);
        panel.add(banButton);
        panel.add(Box.createVerticalGlue());

        listAudiosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playlist.listAllAudios(audioList);
            }
        });

        listVideosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                album.ListAllVideos(videoList);
            }
        });
        banButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	staff s = new staff();
            	//user u = new user();
            	
                s.ban(user.usage1);
            	
            		
            	
            	
            }
        });

        listImagesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                album.listAllimages(imageList);
            }
        });

        listTextsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Texto tex = new Texto(null, null);
                List<Texto> textList = loadDataIntoTextList();
                Texto.listAllTexts(textList);
            }
        });

        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user u = new user();
                u.importAll(imageList, audioList, videoList);
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exploreFrame.dispose();
            }
        });
        commentImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flaglog == 0) {
                	user u = new user();
                    u.addCommentpic(imageList);
                } else {
                    JOptionPane.showMessageDialog(null, "Please login before commenting", "Login Required", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        commentVideoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flaglog == 0) {
                	user u = new user();
                    u.addCommentvid(videoList);
                } else {
                    JOptionPane.showMessageDialog(null, "Please login before commenting", "Login Required", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        commentTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flaglog == 0) {
                	user u = new user();
                    u.addCommenttext(textList);
                } else {
                    JOptionPane.showMessageDialog(null, "Please login before commenting", "Login Required", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        commentAudioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flaglog == 0) {
                	user u = new user();
                    u.addCommentaudio(audioList);
                } else {
                    JOptionPane.showMessageDialog(null, "Please login before commenting", "Login Required", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        exploreFrame.setVisible(true);
    }else{ JOptionPane.showMessageDialog(null, "Please login before any task", "Login Required", JOptionPane.WARNING_MESSAGE);
    	}
    }
    
    /*
     * Loads image data into the image list.
     */
    public static List<image> loadDataIntoImageList() {
        List<image> imageList = new ArrayList<>();
        imageList.add(new image("Image1", "High", 1024, "2023-01-01"));
        imageList.add(new image("Image2", "Medium", 512, "2023-02-01"));
        imageList.add(new image("Image3", "Low", 256, "2023-03-01"));
        return imageList;
    }
    /*
     * Loads video data into the video list.
     */
    public static List<video> loadDataIntoVideoList() {
        List<video> videoList = new ArrayList<>();
        videoList.add(new video("High", 1024, "2023-01-01", "Hamza", 12));
        videoList.add(new video("Medium", 876, "2023-02-01", "Hamza", 60));
        videoList.add(new video("Low", 99, "2023-03-01", "Hamza", 120));
        return videoList;
    }
    /*
     * Loads audio data into the audio list.
     */
    public static List<audio> loadDataIntoAudioList() {
        List<audio> audioList = new ArrayList<>();
        audioList.add(new audio(15, "2023-01-01", "high", "Sam"));
        audioList.add(new audio(8, "2023-02-01", "medium", "Susan"));
        audioList.add(new audio(3, "2023-02-09", "low", "Salma"));
        return audioList;
    }
    /*
     * Loads text data into the text list.
     */
    public static List<Texto> loadDataIntoTextList() {
        List<Texto> textList = new ArrayList<>();
        textList.add(new Texto("Maria Chmite", "My name 1"));
        textList.add(new Texto("Salim Elghersse", "My name 2"));
        textList.add(new Texto("Nouamane Zanboui", "My name 3"));
        return textList;
    }
    private static <T> void saveListToFile(List<T> list, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(list);
            System.out.println("List saved to: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Deserialize a list from a file
    @SuppressWarnings("unchecked")
    private static <T> List<T> loadListFromFile(String filePath) {
        List<T> list = new ArrayList<>();
        File file = new File(filePath);

        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
                list = (List<T>) ois.readObject();
                System.out.println("List loaded from: " + filePath);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}

