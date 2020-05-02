package Controllers;

import Communication.EmailManager;
import Entities.DAO.DAOBase;
import Entities.Primary.User;
import Entities.Secondary.PasswordContainer;

import java.util.Objects;

public class PasswordController extends DAOBase {

    public boolean isPasswordCorrect(User user, String password) {
        try {
            PasswordContainer passContainer = manager().find(PasswordContainer.class, user.getId());

            if(passContainer != null && passContainer.getPassword().equals(password)){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void assignPassword(User user) {
        String generatedPass = generatePassword(user);
        PasswordContainer container = new PasswordContainer(user.getId(), generatedPass);

        try {
            manager().getTransaction().begin();
            manager().persist(container);
            manager().getTransaction().commit();

            new EmailManager().emailPassword(user, container.getPassword());
        } catch (Exception e){
            e.getMessage();
            manager().getTransaction().rollback();
        }
    }

    private String generatePassword(User user){
        int userHash = Objects.hash(user, user.getId());
        return ""+userHash;
    }
}
