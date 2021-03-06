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

    public int insertUser(User user){
        try{
            manager().getTransaction().begin();
            manager().persist(user);
            manager().getTransaction().commit();

            return user.getId();
        } catch (Exception e){
            e.getMessage();
            manager().getTransaction().rollback();
            return -1;
        }
    }

    public void updateUser(User updatedUser) {
        try{
            User dbState = manager().find(User.class, updatedUser.getId());

            manager().getTransaction().begin();
            manager().persist(dbState);
            manager().merge(updatedUser);
            manager().getTransaction().commit();
        } catch (Exception e){
            e.getMessage();
            manager().getTransaction().rollback();
        }
    }
}
