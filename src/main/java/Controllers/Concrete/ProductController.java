package Controllers.Concrete;

import Controllers.Abstract.BasicController;
import Data.Enums.Menus.EProductMenuCommand;
import Managers.Concrete.ProductManager;

import static Data.Enums.EMessage.UnknownCommand;

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
                    //todo: implement product edit
                    printer.printNotImplemented();
                    return;
                case Show_my_products:
                    manager.printOwnedProducts();
                    return;
                case Back:
                    return;
                default:
                    printer.print(UnknownCommand);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
