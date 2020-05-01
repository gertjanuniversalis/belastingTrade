package Communication;

import Data.Enums.Menus.*;
import Entities.Primary.User;
import Managers.SessionManager;

public class Output {
    public void printGenericmenu() {
        System.out.println("Welcome to BDPlace.\nChoose your action.");

        for (EGenericMenuCommand command : EGenericMenuCommand.values()) {
            System.out.println("" + (command.ordinal() + 1) + ")\t" + command.name().replace('_', ' ') + "\n");
        }
    }

    public void printUserMenu() {
        System.out.println("~~~~~Menu(" + SessionManager.getUserName() + ")~~~~~");
        for (EPersonalMenuCommand command : EPersonalMenuCommand.values()) {
            System.out.println("" + (command.ordinal() + 1) + ")\t" + command.name().replace('_', ' ') + "\n");
        }
    }

    public void printAccountMenu() {
        System.out.println("~~~~~Account Details~~~~~");
        for (EAccountCommand command : EAccountCommand.values()) {
            System.out.println("" + (command.ordinal() + 1) + ")\t" + command.name().replace('_', ' ') + "\n");
        }
    }

    public void printProductMenu() {
        System.out.println("~~~~~Products~~~~~");
        for (EProductMenuCommand command : EProductMenuCommand.values()) {
            System.out.println("" + (command.ordinal() + 1) + ")\t" + command.name().replace('_', ' ') + "\n");
        }
    }

    public void print(String question) {
        System.out.println(question);
    }

    public void welcome(String userName) {
        System.out.println("Login successful.\nWelcome " + userName);
    }

    public void printNotImplemented() {
        System.out.println("This functionality is not yet implemented, return later");
    }
}
