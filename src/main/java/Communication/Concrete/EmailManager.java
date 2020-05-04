package Communication.Concrete;

import Data.Enums.EMessage;
import Data.Messages;
import Entities.Primary.User;

public class EmailManager {
    public void emailPassword(User user, String password) {
        Output printer = new Output();

        printer.print(String.format(Messages.getMessage(EMessage.PasswordEmailed),
                user.getName(),
                user.getEmail(),
                password));
    }
}
