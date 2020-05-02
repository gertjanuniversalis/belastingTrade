package Managers.Concrete;

import Communication.Input;
import Data.Enums.Menus.EGenericMenuCommand;
import Managers.Abstract.AbstractHandler;

public class GeneralHandler extends AbstractHandler {

    public void requestAction() {
        if (!SessionManager.isLoggedIn()) {
            printer.printGenericmenu();
            String inputStr = listener.getInput();
            handleInput(inputStr);
        } else {
            new ProcessManager().requestAction();
        }
    }

    private void handleInput(String inputStr) {
        try {
            int commandInt = Integer.parseInt(inputStr);
            EGenericMenuCommand command = EGenericMenuCommand.fromOrdinal(commandInt - 1);

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
