package Communication.Interfaces;

public interface IOutput {
    void printGenericMenu();
    void printUserMenu();
    void printAccountMenu();
    void printProductMenu();
    void printPossibleDeliveries();
    void print(String statement);
    void welcome(String userName);
    void printNotImplemented();
}
