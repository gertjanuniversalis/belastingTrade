package Entities.DAO;

import Data.Session;
import Entities.Primary.Product;
import Managers.Concrete.SessionManager;

import javax.persistence.Query;
import java.util.List;

public class ProductDAO extends DAOBase {
    public List<Product> getOwnedProducts() {
        manager().persist(SessionManager.getUser());
        return SessionManager.getUser().getPlacedProducts();
    }
}
