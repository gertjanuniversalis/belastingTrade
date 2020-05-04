package Managers.Concrete;

import Data.Enums.ELanguage;
import Data.Session;
import Entities.Primary.User;

public class SessionManager {


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
}
