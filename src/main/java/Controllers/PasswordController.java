package Controllers;

import Entities.DAO.DAOBase;
import Entities.Primary.User;
import Entities.Secondary.PasswordContainer;

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
}
