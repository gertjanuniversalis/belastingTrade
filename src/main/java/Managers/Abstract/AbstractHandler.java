package Managers.Abstract;

import Communication.Input;
import Communication.Output;

public abstract class AbstractHandler {
    protected static Output printer = new Output();
    protected static Input listener = new Input();
}
