package Communication.Concrete;

import Communication.Interfaces.IInput;
import Data.Enums.EMessage;
import Data.Messages;
import Util.InputValidator;

import java.util.Scanner;

public class Input implements IInput {
    private InputValidator validator = new InputValidator();
    private Output printer = new Output();

    private static Scanner scanner = new Scanner(System.in);

    @Override
    public String getString(){
        String input = scanner.nextLine();
        String cleanInput = validator.cleanInput(input);
        return cleanInput;
    }

    @Override
    public String getString(String question){
        printer.print(question);
        return getString();
    }

    @Override
    public String getString(EMessage message) {
        return getString(Messages.getMessage(message));
    }

    @Override
    public int getInt(){
        int inputInt = scanner.nextInt();
        scanner.nextLine(); //This is needed to accept a next string input normally
        return inputInt;
    }

    @Override
    public int getInt(String question){
        printer.print(question);
        return getInt();
    }

    @Override
    public int getInt(EMessage message) {
        return getInt(Messages.getMessage(message));
    }
}
