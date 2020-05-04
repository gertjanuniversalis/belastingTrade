package Managers.Concrete;

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
        return Session.activeUser.getId();
    }
}
