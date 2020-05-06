package Controllers.Concrete;

import Controllers.Abstract.BasicController;
import Data.Enums.EMessage;
import Data.Enums.Menus.EAccountCommand;
import Managers.Concrete.AccountManager;
import Managers.Concrete.SessionManager;

import static Data.Enums.EMessage.UnknownCommand;

public class AccountController extends BasicController {
    private AccountManager manager = new AccountManager();


    public void requestAction() {
        printer.printAccountMenu();
        int commandInt = listener.getInt();
        handleInput(commandInt);
    }

    private void handleInput(int commandInt) {
        try {
            EAccountCommand command = EAccountCommand.fromCommand(commandInt);

            switch (command) {
                case Change_password:
                    manager.changePass();
                    break;
                case Change_name:
                    //todo: implement name change
                    break;
                case Change_address:
                    //todo: implement address change
                    break;
                case Change_delivery_mode:
                    manager.displayCurrentDeliveryModes();
                    manager.editDeliveryModes();
                    break;
                case View_delivery_modes:
                    manager.displayCurrentDeliveryModes();
                    break;
                case Back:
                    break;
                case Logout:
                    SessionManager.logout();
                    break;
                default:
                    printer.print(UnknownCommand);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
