package Managers.Concrete;

import Communication.Input;
import Communication.Output;
import Controllers.PasswordController;
import Data.Enums.Menus.EPersonalMenuCommand;
import Entities.DAO.UserDAO;
import Entities.Primary.User;
import Managers.Abstract.AbstractHandler;

public class ProcessManager extends AbstractHandler {

    public void login() {
        String email = listener.getInput("Please enter your email.");
        String password = listener.getInput("Please enter your password.");

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
        //todo: implement
    }

    public void requestAction() {
        printer.printUserMenu();
        int commandInt = listener.getCommand();
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
