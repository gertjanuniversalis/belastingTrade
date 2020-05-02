package Managers.Concrete;

import Data.Enums.Menus.EAccountCommand;
import Data.Enums.Menus.EPersonalMenuCommand;
import Managers.Abstract.AbstractHandler;

public class AccountManager extends AbstractHandler {
    public void requestAction() {
        printer.printAccountMenu();
        int commandInt = listener.getCommand();
        handleInput(commandInt);
    }

    private void handleInput(int commandInt) {
        try {
            EAccountCommand command = EAccountCommand.fromOrdinal(commandInt - 1);

            switch (command) {
                case Change_password:
                    break;
                case Change_name:
                    break;
                case Change_delivery_mode:
                    break;
                case View_delivery_modes:
                    break;
                case Back:
                    break;
                case Logout:
                    break;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
