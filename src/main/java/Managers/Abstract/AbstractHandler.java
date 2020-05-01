package Managers.Abstract;

import Communication.Input;
import Communication.Output;

public abstract class AbstractHandler {
    protected Output printer = new Output();
    protected Input listener = new Input();
}
