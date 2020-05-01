package Managers;

import Communication.Input;
import Communication.Output;
import Data.Enums.Menus.EProductMenuCommand;

public class ProductManager {
    private Output printer = new Output();
    private Input listener = new Input();

    public void requestAction() {
        printer.printUserMenu();
        String commandStr = listener.getInput();
        handleInput(commandStr);
    }

    private void handleInput(String commandStr) {
        try{
            int commandInt = Integer.parseInt(commandStr);
            EProductMenuCommand command = EProductMenuCommand.fromOrdinal(commandInt);

            switch (command) {
                case Place_product:
                    placeNewProduct();
                    return;
                case Edit_product:
                    //todo: implement
                    printer.printNotImplemented();
                    return;
                case List_offered_products:
                    printOwnedProducts();
                    return;
                case Back:
                    return;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
