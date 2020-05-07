package Managers.Concrete;

import Entities.DAO.ProductDAO;
import Entities.Primary.Product;
import Managers.Abstract.AbstractHandler;
import com.sun.org.apache.xml.internal.utils.SuballocatedByteVector;

import java.util.List;

import static Data.Enums.EMessage.ProvidePriceRange;

public class SearchManager extends AbstractHandler {

    public void searchProductByPriceRange() {
        printer.print(ProvidePriceRange);
        String lowerBoundStr = listener.getString("min");
        String upperBoundStr = listener.getString("max");

        double lowerBound = Double.parseDouble(lowerBoundStr);
        double upperBound = Double.parseDouble(upperBoundStr);

        List<Product> products = new ProductDAO().findByPrice(lowerBound, upperBound);

        for (Product product:products){
            printer.print(product.toString());
        }
    }
}
