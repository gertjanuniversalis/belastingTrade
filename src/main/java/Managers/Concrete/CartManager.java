package Managers.Concrete;

import Entities.Primary.Product;
import Managers.Abstract.AbstractHandler;

public class CartManager extends AbstractHandler {
    public void addProduct(Product selectedProduct) {
        SessionManager.addProductToCart(selectedProduct);
    }
}
