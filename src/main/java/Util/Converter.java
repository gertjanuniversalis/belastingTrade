package Util;

public class Converter {
    public static int intFromChar(char c){
        String cString = Character.toString(c);
        int cInt = Integer.parseInt(cString);
        return cInt;
    }
}
