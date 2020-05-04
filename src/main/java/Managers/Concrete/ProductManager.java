package Managers.Concrete;

import Data.Enums.Menus.EProductMenuCommand;
import Entities.DAO.ProductDAO;
import Entities.Primary.Product;
import Managers.Abstract.AbstractHandler;

import java.util.List;

public class ProductManager extends AbstractHandler {

    public void placeNewProduct() {
        //todo: implement
    }

    public void printOwnedProducts() {
        List<Product> ownedProducts = new ProductDAO().getOwnedProducts();

        for (Product product :
                ownedProducts) {
            printer.print(product.toString());
        }
    }
}
