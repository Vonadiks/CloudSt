import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileMessage extends AbstractMessage {
    private String fileName;
    private String login;
    private byte[] data;
    private Path path;
    private boolean isDirectory;
    private boolean isEmpty;
    public FileMessage(Path path) throws IOException {
        fileName = path.getFileName().toString();
        data = Files.readAllBytes(path);
        this.isDirectory = false;
        this.isEmpty = false;
    }
    public FileMessage(String fileName, boolean isDirectory, boolean isEmpty) {
        this.fileName = fileName;
        this.isDirectory = isDirectory;
        this.isEmpty = isEmpty;
    }
    public FileMessage(String login, Path path) throws IOException {
        this.login = login;
        fileName = path.getFileName().toString();
        data = Files.readAllBytes(path);


    }

public String getFileName() {return fileName;}
public String getLogin() {return login;}
public boolean isDirectory() {return isDirectory;}
public boolean isEmpty() {return isEmpty;}
public byte[] getData() {return data;}



}
