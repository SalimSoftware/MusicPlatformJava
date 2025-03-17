package metadata;
import java.util.Date;
import defaultpck.*;
import metadatagroup.*;
import user.*;

public class comments {
    public int userId;
    public String userName;
    public String content;
    public Date timestamp;

    public comments(int userId, String userName, String content) {
        this.userId = userId;
        this.userName = userName;
        this.content = content;
        this.timestamp = new Date(); // Automatically set the current date and time
    }

    // Getters for accessing comment information
    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getContent() {
        return content;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}