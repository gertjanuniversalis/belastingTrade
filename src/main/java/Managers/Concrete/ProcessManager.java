package Managers.Concrete;

import Controllers.Concrete.PasswordController;
import Data.Enums.EGender;
import Entities.DAO.UserDAO;
import Entities.Primary.User;
import Managers.Abstract.AbstractHandler;

import static Data.Enums.EMessage.*;

public class ProcessManager extends AbstractHandler {

    public void login() {
        String email = listener.getString(EnterKnownMail);
        String password = listener.getString(EnterKnownPass);

        try {
            User user = new UserDAO().getUserByEmail(email);

            if (new PasswordController().isPasswordCorrect(user, password)) {
                SessionManager.setUser(user);
                printer.welcome(user.getName());
            } else {
                printer.print(IncorrectLogin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void signUp() {
        String name = listener.getString(SupplyDisplayName);
        String email = listener.getString(SupplyMail);
        int gender = listener.getInt(SupplyGender);

        User user = new User(email, name, EGender.fromOrdinal(gender));

        int userID = new UserDAO().insertUser(user);

        if(userID > 0){
            new PasswordController().assignPassword(user);

            printer.print(SignupSuccess);
        }
    }
}
