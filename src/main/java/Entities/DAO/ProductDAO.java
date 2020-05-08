package Entities.DAO;

import Data.Session;
import Entities.Primary.Product;
import Exceptions.ProductNotFoundException;
import Managers.Concrete.SessionManager;

import javax.persistence.Query;
import java.util.List;

public class ProductDAO extends DAOBase {
    public List<Product> getOwnedProducts() {
        Query query = manager().createQuery("SELECT p FROM Product p WHERE p.placedBy = :user");
        query.setParameter("user", SessionManager.getUser());

        List<Product> userProducts = query.getResultList();

        return userProducts;
    }

    public int insertProduct(Product product) {
        product.setPlacedBy(SessionManager.getUser());
        try {
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

    public List<Product> findByPrice(double lowerBound, double upperBound) {
        Query query;

        if (lowerBound == 0) {
            query = manager().createQuery("SELECT p FROM Product p WHERE p.price > :upper AND p.soldTo = null");
            query.setParameter("upper", upperBound);
        } else if (upperBound == 0) {
            query = manager().createQuery("SELECT p FROM Product p WHERE p.price < :lower AND p.soldTo = null");
            query.setParameter("lower", lowerBound);
        } else {
            query = manager().createQuery("SELECT p FROM Product p WHERE p.price BETWEEN :lower AND :upper AND p.soldTo = null");
            query.setParameter("lower", lowerBound);
            query.setParameter("upper", upperBound);
        }

        List<Product> productsOfPrice = query.getResultList();
        return productsOfPrice;
    }

    public Product getProductById(int prodID) {
        Product product = manager().find(Product.class, prodID);

        if (product != null) {
            return product;
        } else {
            throw new ProductNotFoundException("The product with id " + prodID + " can't be found");
        }
    }

    public void massUpdate(List<Product> productsInCart) {
        try {
            manager().getTransaction().begin();

            for (Product cartProd : productsInCart) {
                Product knowProd = manager().find(Product.class, cartProd.getId());
                manager().persist(knowProd);
                manager().merge(cartProd);
            }

            manager().getTransaction().commit();
        } catch (Exception e) {
            e.getMessage();
            manager().getTransaction().rollback();
        }
    }
}
