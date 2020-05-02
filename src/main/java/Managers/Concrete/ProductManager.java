package Managers.Concrete;

import Communication.Input;
import Communication.Output;
import Data.Enums.Menus.EProductMenuCommand;
import Entities.DAO.ProductDAO;
import Entities.Primary.Product;
import Managers.Abstract.AbstractHandler;

import java.util.List;

public class ProductManager extends AbstractHandler {

    public void requestAction() {
        printer.printUserMenu();
        String commandStr = listener.getInput();
        handleInput(commandStr);
    }

    private void handleInput(String commandStr) {
        try {
            int commandInt = Integer.parseInt(commandStr);
            EProductMenuCommand command = EProductMenuCommand.fromOrdinal(commandInt - 1);

            switch (command) {
                case Place_product:
//                    placeNewProduct();
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

    private void printOwnedProducts() {
        List<Product> ownedProducts = new ProductDAO().getOwnedProducts();

        for (Product product :
                ownedProducts) {
            printer.print(product.toString());
        }
    }
}
