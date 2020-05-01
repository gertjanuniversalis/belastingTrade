package Communication;

import Util.InputValidator;

import java.util.Scanner;

public class Input {
    private InputValidator validator = new InputValidator();
    private Output printer = new Output();

    private static Scanner scanner = new Scanner(System.in);

    public String getInput(){
        String input = scanner.nextLine();
        String cleanInput = validator.cleanInput(input);
        return cleanInput;
    }
    public String getInput(String question){
        printer.print(question);
        return getInput();
    }
}
