package Communication;

import Entities.Primary.User;

public class EmailManager {
    public void emailPassword(User user, String password) {
        Output printer = new Output();

        printer.print(String.format("The password for %s will be send to %s\n" +
                "The password is: %s",
                user.getName(),
                user.getEmail(),
                password));
    }
}
