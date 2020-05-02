package Managers.Concrete;

import Controllers.PasswordController;
import Data.Enums.EGender;
import Data.Enums.Menus.EPersonalMenuCommand;
import Entities.DAO.UserDAO;
import Entities.Primary.User;
import Managers.Abstract.AbstractHandler;

public class ProcessManager extends AbstractHandler {

    public void login() {
        String email = listener.getString("Please enter your email.");
        String password = listener.getString("Please enter your password.");

        try {
            User user = new UserDAO().getUserByEmail(email);

            if (new PasswordController().isPasswordCorrect(user, password)) {
                SessionManager.setUser(user);
                printer.welcome(user.getName());
            } else {
                printer.print("Incorrect credentials, please try again");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void signUp() {
        printer.print("Choose a name");
        String name = listener.getString();
        printer.print("Enter your email");
        String email = listener.getString();
        printer.print("provide your gender (1=male, 2=female");
        int gender = listener.getInt();

        User user = new User(email, name, EGender.fromOrdinal(gender));

        int userID = new UserDAO().insertUser(user);

        if(userID > 0){
            new PasswordController().assignPassword(user);
        }
    }

    public void requestAction() {
        printer.printUserMenu();
        int commandInt = listener.getInt();
        handleInput(commandInt);
    }

    private void handleInput(int commandInt) {
        try {
            EPersonalMenuCommand command = EPersonalMenuCommand.fromOrdinal(commandInt - 1);

            switch (command) {
                case Products:
                    new ProductManager().requestAction();
                    return;
                case Account:
                    new AccountManager().requestAction();
                    return;
                case Logout:
                    SessionManager.logout();
                    return;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
