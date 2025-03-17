package metadata;
import defaultpck.*;
import metadatagroup.*;
import user.*;

import java.io.Serializable;
import java.util.List;

public class video implements Serializable {

    public String vidqua;
    public int size;
    public String datecreated;
    public String creator;
    public int duration;
private List<comments> comments;
//Constructor
    public video(String vidqua, int size, String datecreated, String creator, int duration) {
        this.vidqua = vidqua;
        this.size = size;
        this.datecreated = datecreated;
        this.creator = creator;
        this.duration=duration;     }


    // Methods
    
    public void download(){  
    System.out.println("Downloading...");

    }
    public void share()
    {
        System.out.println("Sharing....");
    }
          // Add a comment to the video
          public void addCommentvid(comments comment) {
            comments.add(comment);
        }
    
        // Get all comments for the video
        public List<comments> getCommentsvid() {
            return comments;
        }
}
