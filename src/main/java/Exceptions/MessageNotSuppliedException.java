package Exceptions;

public class MessageNotSuppliedException extends RuntimeException {
    public String fileName;
    public String messageName;

    public MessageNotSuppliedException(String dataFile, String messageName) {
        this.fileName = dataFile;
        this.messageName = messageName;
    }
}
