package Managers.Concrete;

import Controllers.Concrete.PasswordController;
import Data.Enums.EDeliveryType;
import Data.Messages;
import Entities.DAO.UserDAO;
import Entities.Primary.User;
import Entities.Secondary.PasswordContainer;
import Managers.Abstract.AbstractHandler;
import Util.Converter;

import java.util.*;

public class AccountManager extends AbstractHandler {
    public void editDeliveryModes() {
        User user = SessionManager.getUser();

        printer.printPossibleDeliveries();
        String wantedDeliveryString = listener.getString(Messages.requestDeliveryTypes);

        if (!wantedDeliveryString.isEmpty()) {
            List<EDeliveryType> typeList = new ArrayList<>();

            for (int i = 0; i < wantedDeliveryString.length(); i++) {
                int typeInt = Converter.intFromChar(wantedDeliveryString.charAt(i));
                typeList.add(EDeliveryType.fromOrdinal(typeInt - 1));
            }

            if(!addressNeededAndMissing(typeList)) {
                user.setDeliveryTypes(typeList);
                new UserDAO().updateUser(user);
                SessionManager.setUser(user);
            } else {
                printer.print(Messages.addressNeeded);
            }
        }
    }

    private boolean addressNeededAndMissing(List<EDeliveryType> typeList) {
        if (typeList.contains(EDeliveryType.Pickup_from_home)){
            if(SessionManager.getUser().getAddress() == null){
                return true;
            }
        }
        return false;
    }

    public void displayCurrentDeliveryModes() {
        List<EDeliveryType> currentTypes = SessionManager.getUser().getDeliveryTypes();
        if (!currentTypes.isEmpty()) {
            StringBuilder builder = new StringBuilder("Your current delivery modes are:\n");
            for (EDeliveryType type : currentTypes) {
                builder.append("-\t" + type.name() + "\n");
            }
            printer.print(builder.toString());
        } else {
            printer.print(Messages.noDeliverySet);
        }
    }

    public void changePass() {
        String currentPass = listener.getString(Messages.securityConfirm);
        PasswordController passCon = new PasswordController();

        if(passCon.isPasswordCorrect(currentPass)){
            String newPassOne = listener.getString(Messages.enterNewPass);
            String newPassTwo = listener.getString(Messages.confirmNewPass);

            if(newPassOne.equals(newPassTwo)){
                passCon.changePassword(newPassOne);
            } else {
                printer.print(Messages.passwordsDontMatch);
            }

        } else {
            printer.print(Messages.incorrectLogin);
        }
    }
}
