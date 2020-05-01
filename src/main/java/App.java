import Communication.Input;
import Communication.Output;
import Data.Enums.Menus.EGenericMenuCommand;
import Managers.Concrete.ProcessManager;
import Managers.Concrete.SessionManager;

public class App {
    public static void main(String[] args) {
        new TraderInstance().run();
    }
}
