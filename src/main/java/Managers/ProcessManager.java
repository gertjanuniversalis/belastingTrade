package Managers;

import Communication.Input;
import Communication.Output;
import Controllers.PasswordController;
import Data.Enums.Menus.EAccountCommand;
import Data.Enums.Menus.EPersonalMenuCommand;
import Data.Enums.Menus.EProductMenuCommand;
import Entities.DAO.UserDAO;
import Entities.Primary.User;

public class ProcessManager {
    private Output printer = new Output();
    private Input listener = new Input();

    public void login() {
        String email = listener.getInput("Please enter your email.");
        String password = listener.getInput("Please enter your password.");

        try {
            User user = new UserDAO().getUserByEmail(email);

            if(new PasswordController().isPasswordCorrect(user, password)){
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
        String commandStr = listener.getInput();
        handleInput(commandStr);
    }

    private void handleInput(String commandStr) {
        try{
            int commandInt = Integer.parseInt(commandStr);
            EPersonalMenuCommand command = EPersonalMenuCommand.fromOrdinal(commandInt);

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
