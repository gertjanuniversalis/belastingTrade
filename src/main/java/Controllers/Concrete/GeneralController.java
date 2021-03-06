package Controllers.Concrete;

import Controllers.Abstract.BasicController;
import Data.Enums.Menus.EGenericMenuCommand;
import Managers.Concrete.ProcessManager;
import Managers.Concrete.SessionManager;

import static Data.Enums.EMessage.UnknownCommand;

public class GeneralController extends BasicController {
    public void requestAction() {
        if (!SessionManager.isLoggedIn()) {
            printer.printGenericMenu();
            int commandInt = listener.getInt();
            handleInput(commandInt);
        } else {
            new ProcessController().requestAction();
        }
    }

    private void handleInput(int commandInt) {
        try {
            EGenericMenuCommand command = EGenericMenuCommand.fromCommand(commandInt);

            switch (command) {
                case Login:
                    new ProcessManager().login();
                    return;
                case Signup:
                    new ProcessManager().signUp();
                    return;
                case Quit:
                    System.exit(0);
                default:
                    printer.print(UnknownCommand);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
