package Managers.Concrete;

import Data.Enums.EDeliveryType;
import Data.Enums.EProductCategory;
import Entities.DAO.ProductDAO;
import Entities.Primary.Product;
import Managers.Abstract.AbstractHandler;

import java.util.List;

import static Data.Enums.EMessage.*;

public class ProductManager extends AbstractHandler {

    public void placeNewProduct() {
        //todo: cleanup method
        String productName = listener.getString(ProductName);
        String description = listener.getString(ProductDescription);
        double price;
        try {
            price = Double.parseDouble(listener.getString(ProvidePrice));
        } catch (NumberFormatException e) {
            //todo: handle error
            e.printStackTrace();
            return;
        }

        EProductCategory cat;
        try {
            printer.printUserCats();
            String catString = listener.getString();
            int catInt = Integer.parseInt(catString);
            cat = EProductCategory.fromCommand(catInt);
        } catch (NumberFormatException e) {
            //todo: handle error
            e.printStackTrace();
            return;
        }

        EDeliveryType deliveryType = getDeliveryType();

        Product product = new Product(productName, description, price, cat, deliveryType);

        new ProductDAO().insertProduct(product);
    }

    public void printOwnedProducts() {
        List<Product> ownedProducts = new ProductDAO().getOwnedProducts();

        for (Product product :
                ownedProducts) {
            printer.print(product.toString());
        }
    }

    private EDeliveryType getDeliveryType() {
        //todo: implement get delivery type
        return EDeliveryType.Pickup_from_store;
    }
}
