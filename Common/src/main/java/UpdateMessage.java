import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;

public class UpdateMessage extends AbstractMessage{
    private String login;
    private HashMap<Integer, LinkedList<File>> cloudStorageContents;

    public UpdateMessage(String login) {
        this.login = login;
    }
    public UpdateMessage(HashMap<Integer, LinkedList<File>> cloudStorageContents) {
        this.cloudStorageContents = cloudStorageContents;
    }

    public String getLogin() {
        return login;
    }

    public HashMap<Integer, LinkedList<File>> getCloudStorageContents() {
        return cloudStorageContents;
    }
}
