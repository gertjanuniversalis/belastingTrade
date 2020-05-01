import Communication.Input;
import Communication.Output;
import Data.Enums.Menus.EGenericMenuCommand;
import Managers.ProcessManager;
import Managers.SessionManager;

public class App {
    private static Output printer = new Output();
    private static boolean run = true;

    public static void main(String[] args) {
        Input listener = new Input();
        while (run) {
            if (!SessionManager.isLoggedIn()) {
                printer.printGenericmenu();
                String inputStr = listener.getInput();
                handleInput(inputStr);
            } else {
                new ProcessManager().requestAction();
            }
        }
    }

    private static void handleInput(String inputStr) {
        try {
            int commandInt = Integer.parseInt(inputStr);
            EGenericMenuCommand command = EGenericMenuCommand.fromOrdinal(commandInt);

            switch (command) {
                case Login:
                    new ProcessManager().login();
                    return;
                case Signup:
                    new ProcessManager().signUp();
                    return;
                case Quit:
                    run = false;
                    return;
                default:
                    return;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return;
    }
}
