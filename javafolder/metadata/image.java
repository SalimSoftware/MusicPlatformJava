package metadata;
import defaultpck.*;
import metadatagroup.*;
import user.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class image extends media implements Serializable {
    public String name;
    public String imagequa;
    public int size;
    public String datecreated;
    //private List<Comment> comments;

    // Constructor
    public image(String name, String imagequa, int size, String datecreated) {
        this.name = name;
        this.imagequa = imagequa;
        this.size = size;
        this.datecreated = datecreated;
    }}
