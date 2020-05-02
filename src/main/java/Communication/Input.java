package Communication;

import Util.InputValidator;

import java.util.Scanner;

public class Input {
    private InputValidator validator = new InputValidator();
    private Output printer = new Output();

    private static Scanner scanner = new Scanner(System.in);

    public String getString(){
        String input = scanner.nextLine();
        String cleanInput = validator.cleanInput(input);
        return cleanInput;
    }
    public String getString(String question){
        printer.print(question);
        return getString();
    }

    public int getInt(){
        int inputInt = scanner.nextInt();
        scanner.nextLine(); //This is needed to accept a next string input normally
        return inputInt;
    }

    public int getInt(String question){
        printer.print(question);
        return getInt();
    }
}
