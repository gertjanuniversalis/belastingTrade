package Managers.Concrete;

import Data.Enums.EDeliveryType;
import Data.Enums.ELanguage;
import Data.Session;
import Entities.Local.ShoppingCart;
import Entities.Primary.Product;
import Entities.Primary.User;

import java.util.List;

public class SessionManager {
//User
    public static String getUserName() {
        if (isLoggedIn()) {
            return Session.activeUser.getName();
        } else {
            return "";
        }
    }

    public static boolean isLoggedIn() {
        return Session.activeUser != null;
    }

    public static void logout() {
        Session.activeUser = null;
    }

    public static void setUser(User user) {
        Session.activeUser = user;
    }

    public static User getUser() {
        return Session.activeUser;
    }

    public static int getUserId() {
        if (isLoggedIn()) {
            return Session.activeUser.getId();
        } else {
            return -1;
        }
    }

    public static ELanguage getUserLanguage() {
        if(isLoggedIn()) {
            return Session.activeUser.getLanguage();
        } else {
            return ELanguage.English;
        }
    }

    public static List<EDeliveryType> getUserDeliveryTypes() {
        return Session.activeUser.getDeliveryTypes();
    }

//Cart
    public static void addProductToCart(Product product){
        if(Session.shoppingCart == null){Session.shoppingCart = new ShoppingCart();}

        Session.shoppingCart.add(product);
    }

    public static String getCartContents() {
        return Session.shoppingCart.toString();
    }
}
