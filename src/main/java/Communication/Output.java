package Communication;

import Data.Enums.Menus.*;
import Managers.Concrete.SessionManager;

public class Output {
    public void printGenericmenu() {
        System.out.println("Welcome to BDPlace.\nChoose your action.");

        for (EGenericMenuCommand command : EGenericMenuCommand.values()) {
            System.out.println("" + (command.ordinal() + 1) + ")\t" + command.name().replace('_', ' '));
        }
    }

    public void printUserMenu() {
        System.out.println("~~~~~Menu(" + SessionManager.getUserName() + ")~~~~~");
        for (EPersonalMenuCommand command : EPersonalMenuCommand.values()) {
            System.out.println("" + (command.ordinal() + 1) + ")\t" + command.name().replace('_', ' '));
        }
    }

    public void printAccountMenu() {
        System.out.println("~~~~~Account Details~~~~~");
        for (EAccountCommand command : EAccountCommand.values()) {
            System.out.println("" + (command.ordinal() + 1) + ")\t" + command.name().replace('_', ' '));
        }
    }

    public void printProductMenu() {
        System.out.println("~~~~~Products~~~~~");
        for (EProductMenuCommand command : EProductMenuCommand.values()) {
            System.out.println("" + (command.ordinal() + 1) + ")\t" + command.name().replace('_', ' '));
        }
    }

    public void print(String statement) {
        System.out.println(statement);
    }

    public void welcome(String userName) {
        System.out.println("Login successful.\nWelcome " + userName);
    }

    public void printNotImplemented() {
        System.out.println("This functionality is not yet implemented, return later");
    }
}
