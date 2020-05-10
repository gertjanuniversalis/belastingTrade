package Controllers.Concrete;

import Controllers.Abstract.BasicController;
import Data.Enums.EMessage;
import Data.Enums.EProductSearchType;
import Entities.DAO.ProductDAO;
import Entities.Primary.Product;
import Managers.Concrete.SearchManager;

import java.util.List;

import static Data.Enums.EMessage.*;

public class SearchController extends BasicController {
    public void searchProducts() {
        try {
            printer.printProductSearch();
            int searchTypeInt = listener.getInt();
            EProductSearchType type = EProductSearchType.fromCommand(searchTypeInt);

            switch (type) {
                case Name:
                    break;
                case Category:
                    break;
                case PriceRange:
                    new SearchManager().searchProductByPriceRange();
                    break;
                case Back:
                    return;
                default:
                    printer.print(UnknownCommand);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
