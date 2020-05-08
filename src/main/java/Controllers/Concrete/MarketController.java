package Controllers.Concrete;

import Controllers.Abstract.BasicController;
import Data.Enums.Menus.EStoreCommand;
import Entities.DAO.ProductDAO;
import Entities.Primary.Product;
import Managers.Concrete.CartManager;
import Managers.Concrete.SessionManager;

import java.util.List;

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
                case Buy_product:
                    directBuyFromId();
                    break;
                case Display_cart_contents:
                    printCart();
                    return;
                case Buy_all_selected:
                    buyAll();
                    break;
                default:
                    printer.print(UnknownCommand);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void directBuyFromId() {
        int prodId = listener.getInt(InsertProductID);
        Product boughtProd = new ProductDAO().getProductById(prodId);
        SessionManager.addProductToCart(boughtProd);
    }

    private void buyAll() {
        List<Product> productsInCart = SessionManager.getCartContents();
        for (Product product:productsInCart){
            product.setSoldTo(SessionManager.getUser());
        }
        new ProductDAO().massUpdate(productsInCart);
    }

    private void printCart() {
        String cartContents = SessionManager.getCartString();
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
