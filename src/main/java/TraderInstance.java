import Controllers.Concrete.GeneralController;

public class TraderInstance {
    private boolean run = true;

    public void run(){
        while(run) {
            GeneralController handler = new GeneralController();
            handler.requestAction();
        }
    }
}
