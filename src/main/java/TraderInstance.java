import Communication.Input;
import Communication.Output;
import Data.Enums.Menus.EGenericMenuCommand;
import Managers.Concrete.GeneralHandler;
import Managers.Concrete.ProcessManager;
import Managers.Concrete.SessionManager;

public class TraderInstance {
    private boolean run = true;

    public void run(){
        while(run) {
            GeneralHandler handler = new GeneralHandler();
            handler.requestAction();
        }
    }
}
