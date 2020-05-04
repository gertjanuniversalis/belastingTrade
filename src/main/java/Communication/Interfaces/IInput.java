package Communication.Interfaces;

import Data.Enums.EMessage;

public interface IInput {
    String getString();
    String getString(String question);
    String getString(EMessage message);
    int getInt();
    int getInt(String question);
    int getInt(EMessage message);
}
