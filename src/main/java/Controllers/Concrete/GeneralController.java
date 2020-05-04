package Controllers.Concrete;

import Controllers.Abstract.BasicController;
import Data.Enums.Menus.EGenericMenuCommand;
import Managers.Concrete.GeneralManager;
import Managers.Concrete.ProcessManager;
import Managers.Concrete.SessionManager;

public class GeneralController extends BasicController {
    private GeneralManager manager = new GeneralManager();
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
                case Quit:
                default:
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
