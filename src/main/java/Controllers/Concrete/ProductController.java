package Controllers.Concrete;

import Controllers.Abstract.BasicController;
import Data.Enums.Menus.EProductMenuCommand;
import Managers.Concrete.ProductManager;

public class ProductController extends BasicController {
    private ProductManager manager = new ProductManager();
    public void requestAction() {
        printer.printProductMenu();
        int commandInt = listener.getInt();
        handleInput(commandInt);
    }

    private void handleInput(int commandInt) {
        try {
            EProductMenuCommand command = EProductMenuCommand.fromCommand(commandInt);

            switch (command) {
                case Place_product:
                    manager.placeNewProduct();
                    return;
                case Edit_product:
                    //todo: implement
                    printer.printNotImplemented();
                    return;
                case List_offered_products:
                    manager.printOwnedProducts();
                    return;
                case Back:
                    return;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
