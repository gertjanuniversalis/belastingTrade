package Entities.DAO;

import Data.Session;
import Entities.Primary.Product;
import Managers.Concrete.SessionManager;

import javax.persistence.Query;
import java.util.List;

public class ProductDAO extends DAOBase {
    public List<Product> getOwnedProducts() {
           Query query = manager().createQuery("SELECT p FROM Product p WHERE p.placedBy = :user");
           query.setParameter("user",SessionManager.getUser());

           List<Product> userProducts = query.getResultList();

           return userProducts;
    }

    public int insertProduct(Product product) {
        product.setPlacedBy(SessionManager.getUser());
        try{
            manager().getTransaction().begin();
            manager().persist(product);
            manager().getTransaction().commit();

            return product.getId();
        } catch (Exception e) {
            e.getMessage();
            manager().getTransaction().rollback();
            return -1;
        }
    }
}
