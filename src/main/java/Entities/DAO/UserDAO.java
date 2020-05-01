package Entities.DAO;

import Entities.Primary.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Query;
import java.util.List;

public class UserDAO extends DAOBase {
    Logger logger = LoggerFactory.getLogger(UserDAO.class);


    public User getUserByEmail(String email) {
        try {
            Query query = manager().createQuery("SELECT u FROM User u WHERE u.email = :email");
            query.setParameter("email", email);

            List<User> userList = query.getResultList();
            if (!userList.isEmpty()) {
                return userList.get(0);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
