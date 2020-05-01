package Data.Enums.Menus;

public enum EGenericMenuCommand {
    Login,
    Signup,
    Quit;

    private static EGenericMenuCommand[] commands = values();
    public static EGenericMenuCommand fromOrdinal(int n){return commands[n];}
}
