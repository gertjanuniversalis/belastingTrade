package Managers.Concrete;

import Controllers.Concrete.PasswordController;
import Data.Enums.EDeliveryType;
import Entities.DAO.UserDAO;
import Entities.Primary.User;
import Managers.Abstract.AbstractHandler;
import Util.Converter;

import java.util.*;

import static Data.Enums.EMessage.*;
import static Data.Messages.getMessage;

public class AccountManager extends AbstractHandler {
    public void editDeliveryModes() {
        User user = SessionManager.getUser();

        printer.printPossibleDeliveries();
        String wantedDeliveryString = listener.getString(RequestDeliveryTypes);

        if (!wantedDeliveryString.isEmpty()) {
            List<EDeliveryType> typeList = new ArrayList<>();

            for (int i = 0; i < wantedDeliveryString.length(); i++) {
                int typeInt = Converter.intFromChar(wantedDeliveryString.charAt(i));
                typeList.add(EDeliveryType.fromOrdinal(typeInt - 1));
            }

            if (!addressNeededAndMissing(typeList)) {
                user.setDeliveryTypes(typeList);
                new UserDAO().updateUser(user);
                SessionManager.setUser(user);
            } else {
                printer.print(AddressNeeded);
            }
        }
    }

    private boolean addressNeededAndMissing(List<EDeliveryType> typeList) {
        if (typeList.contains(EDeliveryType.Pickup_from_home)) {
            if (SessionManager.getUser().getAddress() == null) {
                return true;
            }
        }
        return false;
    }

    public void displayCurrentDeliveryModes() {
        List<EDeliveryType> currentTypes = SessionManager.getUser().getDeliveryTypes();
        if (!currentTypes.isEmpty()) {
            StringBuilder builder = new StringBuilder(getMessage(DeliveryTypeList));
            for (EDeliveryType type : currentTypes) {
                builder.append("-\t" + type.name() + "\n");
            }
            printer.print(builder.toString());
        } else {
            printer.print(NoDeliverySet);
        }
    }

    public void changePass() {
        String currentPass = listener.getString(SecurityConfirm);
        PasswordController passCon = new PasswordController();

        if (passCon.isPasswordCorrect(currentPass)) {
            String newPassOne = listener.getString(EnterNewPass);
            String newPassTwo = listener.getString(ConfirmNewPass);

            if (newPassOne.equals(newPassTwo)) {
                passCon.changePassword(newPassOne);
            } else {
                printer.print(PasswordsDontMatch);
            }

        } else {
            printer.print(IncorrectLogin);
        }
    }
}
