package Communication.Interfaces;

import Data.Enums.EMessage;

public interface IOutput {
    void printGenericMenu();
    void printUserMenu();
    void printAccountMenu();
    void printProductMenu();
    void printPossibleDeliveries();
    void printStoreMenu();
    void printUserCats();
    void print(String statement);
    void print(EMessage message);
    void welcome(String userName);

    void printNotImplemented();

    void printProductSearch();

    void printLanguageOptions();
}
