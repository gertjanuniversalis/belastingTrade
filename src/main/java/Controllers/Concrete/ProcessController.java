package Controllers.Concrete;

import Controllers.Abstract.BasicController;
import Data.Enums.EMessage;
import Data.Enums.Menus.EPersonalMenuCommand;
import Managers.Concrete.ProcessManager;
import Managers.Concrete.SessionManager;

import static Data.Enums.EMessage.UnknownCommand;

public class ProcessController extends BasicController {
    private ProcessManager manager = new ProcessManager();

    public void requestAction() {
        printer.printUserMenu();
        int commandInt = listener.getInt();
        handleInput(commandInt);
    }

    private void handleInput(int commandInt) {
        try {
            EPersonalMenuCommand command = EPersonalMenuCommand.fromCommand(commandInt);

            switch (command) {
                case My_products:
                    new ProductController().requestAction();
                    return;
                case My_account:
                    new AccountController().requestAction();
                    return;
                case Logout:
                    SessionManager.logout();
                    return;
                default:
                    printer.print(UnknownCommand);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
