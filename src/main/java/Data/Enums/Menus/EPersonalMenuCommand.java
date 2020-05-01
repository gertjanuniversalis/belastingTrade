package Data.Enums.Menus;

public enum EPersonalMenuCommand {
    Products,
    Account,
    Logout;

    private static EPersonalMenuCommand[] commands = values();
    public static EPersonalMenuCommand fromOrdinal(int n){return commands[n];}
}
