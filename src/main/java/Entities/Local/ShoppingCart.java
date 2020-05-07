package Entities.Local;

import Entities.Primary.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> mappedProducts;

    public ShoppingCart(){
        mappedProducts = new HashMap<>();
    }

    public void add(Product product){
        if(mappedProducts.containsKey(product)){
            int oldAmount = mappedProducts.get(product);

            mappedProducts.replace(product, ++oldAmount);
        } else {
            mappedProducts.put(product, 1);
        }
    }



    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<Product, Integer> entry : mappedProducts.entrySet()){
            builder.append(String.format("%s times %s\n",
                    entry.getValue(),
                    entry.getKey().getName()
            ));
        }

        return builder.toString();
    }
}
