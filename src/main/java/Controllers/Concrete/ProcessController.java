package Controllers.Concrete;

import Controllers.Abstract.BasicController;
import Data.Enums.Menus.EPersonalMenuCommand;
import Managers.Concrete.AccountManager;
import Managers.Concrete.ProcessManager;
import Managers.Concrete.ProductManager;
import Managers.Concrete.SessionManager;

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
                case Products:
                    new ProductController().requestAction();
                    return;
                case Account:
                    new AccountController().requestAction();
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
