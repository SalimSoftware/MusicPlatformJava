package metadata;
import defaultpck.*;
import metadatagroup.*;
import user.*;

import java.io.Serializable;
import java.util.List;

public class audio extends media implements Serializable {
    public int duration;
    public String date;
    public String quality;
    public String creator;

    public audio(int duration, String date, String quality, String creator) {
        this.duration = duration;
        this.date = date;
        this.quality = quality;
        this.creator = creator;
    }
    

    public void importAudio() {
        System.out.println("Audio was imported successfully");
    }

    public void upgradequa() {
        // Placeholder method
    }

    public void noisecancel() {
        // Placeholder method
    }

    public void addbackgrsound() {
        // Placeholder method
    }
}

