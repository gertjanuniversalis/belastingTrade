package Data;

import Data.Enums.ELanguage;
import Data.Enums.EMessage;
import Exceptions.MessageNotSuppliedException;
import Managers.Concrete.SessionManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Messages {

    ELanguage language = SessionManager.getUserLanguage();

    public static String getMessage(EMessage message){
        String dataFile = getFile();

        return MessageReader.getMessage(dataFile, message.name());
    }

    private static String getFile(){
        switch(SessionManager.getUserLanguage()){
            default:
            case Nederlands:
                return "Localisation/Nederlands.properties";
            case English:
                //English is the default language
                return "Localisation/English.properties";
        }
    }

    private static class MessageReader {
        public static String getMessage(String dataFile, String messageName) {
            try(InputStream stream = MessageReader.class.getClassLoader().getResourceAsStream(dataFile)){
                Properties properties = new Properties();

                if(stream != null){
                    properties.load(stream);
                } else {
                    throw new FileNotFoundException("Language file not found");
                }

                String messageText = properties.getProperty(messageName);

                if(messageText != null && !messageText.isEmpty()) {
                    return messageText;
                } else {
                    throw new MessageNotSuppliedException(dataFile, messageName);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
    }
}
