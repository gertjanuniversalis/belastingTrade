package Managers.Abstract;

import Communication.Concrete.Input;
import Communication.Concrete.Output;
import Communication.Interfaces.IInput;
import Communication.Interfaces.IOutput;


public abstract class AbstractHandler {
    protected static IOutput printer = new Output();
    protected static IInput listener = new Input();
}
