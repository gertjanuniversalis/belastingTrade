package Communication.Concrete;

import Communication.Interfaces.IOutput;
import Data.Enums.EDeliveryType;
import Data.Enums.EMessage;
import Data.Enums.EProductCategory;
import Data.Enums.Menus.*;
import Data.Messages;
import Managers.Concrete.SessionManager;

import static Data.Enums.EMessage.*;
import static Data.Messages.getMessage;


public class Output implements IOutput {
    @Override
    public void printGenericMenu() {
        System.out.println(getMessage(NoAccountWelcome));
        for (EGenericMenuCommand command : EGenericMenuCommand.values()) {
            System.out.println(menuOrdinal(command.ordinal()) + dashToSpace(command.name()));
        }
    }

    @Override
    public void printUserMenu() {
        System.out.println("~~~~~Menu(" + SessionManager.getUserName() + ")~~~~~");
        for (EPersonalMenuCommand command : EPersonalMenuCommand.values()) {
            System.out.println(menuOrdinal(command.ordinal()) + dashToSpace(command.name()));
        }
    }

    @Override
    public void printAccountMenu() {
        System.out.println("~~~~~Account Details~~~~~");
        for (EAccountCommand command : EAccountCommand.values()) {
            System.out.println(menuOrdinal(command.ordinal()) + dashToSpace(command.name()));
        }
    }

    @Override
    public void printProductMenu() {
        System.out.println("~~~~~Products~~~~~");
        for (EProductMenuCommand command : EProductMenuCommand.values()) {
            System.out.println(menuOrdinal(command.ordinal()) + dashToSpace(command.name()));
        }
    }

    @Override
    public void printPossibleDeliveries() {
        System.out.println("~~~~~~~Delivery methods~~~~~~~~");
        for (EDeliveryType command : EDeliveryType.values()) {
            System.out.println(menuOrdinal(command.ordinal()) + dashToSpace(command.name()));
        }
    }

    @Override
    public void printUserCats() {
        System.out.println(getMessage(RequestCats));
        for (EProductCategory cat : EProductCategory.values()){
            System.out.println(menuOrdinal(cat.ordinal())+dashToSpace(cat.name()));
        }
    }

    @Override
    public void print(String statement) {
        System.out.println(statement);
    }

    @Override
    public void print(EMessage message) {
        print(Messages.getMessage(message));
    }

    @Override
    public void welcome(String userName) {
        System.out.println(getMessage(LoginWelcome) + userName);
    }

    @Override
    public void printNotImplemented() {
        System.out.println(getMessage(NotImplemented));
    }


    private String menuOrdinal(int i) {
        return i + 1 + ")\t";
    }

    private String dashToSpace(String s) {
        return s.replace('_', ' ');
    }
}
