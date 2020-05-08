package Entities.Local;

import Data.Enums.EMessage;
import Data.Messages;
import Entities.Primary.Product;
import lombok.Getter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    @Getter
    private List<Product> productsInCart;


    public ShoppingCart() {
        productsInCart = new ArrayList<>();
    }

    public void add(Product product) {
        if (!productsInCart.contains(product)) {
            productsInCart.add(product);
        }
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(Messages.getMessage(EMessage.CartContains));

        for (Product product : productsInCart) {
            builder.append("- " + product.getName() + "\n");
        }

        return builder.toString();
    }
}
