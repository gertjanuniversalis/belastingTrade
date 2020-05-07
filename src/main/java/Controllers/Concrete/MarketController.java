package Controllers.Concrete;

import Controllers.Abstract.BasicController;
import Data.Enums.EMessage;
import Data.Enums.Menus.EStoreCommand;
import Entities.DAO.ProductDAO;
import Entities.Primary.Product;
import Managers.Concrete.CartManager;
import Managers.Concrete.SessionManager;

import static Data.Enums.EMessage.*;

public class MarketController extends BasicController {
    public void requestAction(){
        printer.printStoreMenu();
        int commandInt = listener.getInt();
        handleInput(commandInt);
    }

    private void handleInput(int commandInt){
        try{
            EStoreCommand command = EStoreCommand.fromCommand(commandInt);

            switch (command){
                case Select_Product:
                    selectProductById();
                    break;
                case Search_products:
                    new SearchController().searchProducts();
                    return;
                case Display_cart_contents:
                    PrintCart();
                    return;
                default:
                    printer.print(UnknownCommand);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void PrintCart() {
        String cartContents = SessionManager.getCartContents();
        printer.print(cartContents);
    }

    private void selectProductById() {
        int prodID = listener.getInt(InsertProductID);
        Product selectedProduct = new ProductDAO().getProductById(prodID);
        printer.print(selectedProduct.toString());

        int productCommand = listener.getInt(DealWithProduct);
        if(productCommand == 1) {
            new CartManager().addProduct(selectedProduct);
        }
    }
}
