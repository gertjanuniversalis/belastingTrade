package Managers.Concrete;

import Data.Enums.Menus.EPersonalMenuCommand;
import Managers.Abstract.AbstractHandler;

public class AccountManager extends AbstractHandler {
    public void requestAction() {
        printer.printAccountMenu();
        String commandStr = listener.getInput();
        handleInput(commandStr);
    }

    private void handleInput(String commandStr) {
        try {
            int commandInt = Integer.parseInt(commandStr);
            EPersonalMenuCommand command = EPersonalMenuCommand.fromOrdinal(commandInt - 1);

            switch (command) {
                case Products:
                    //todo: write
                    break;
                case Account:
                    //todo: write
                    break;
                case Logout:
                    SessionManager.logout();
                    break;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
