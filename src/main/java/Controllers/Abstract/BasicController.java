package Controllers.Abstract;

import Communication.Concrete.Input;
import Communication.Concrete.Output;
import Communication.Interfaces.IInput;
import Communication.Interfaces.IOutput;
import Managers.Abstract.AbstractHandler;

public abstract class BasicController {
    protected static IOutput printer = new Output();
    protected static IInput listener = new Input();
}
