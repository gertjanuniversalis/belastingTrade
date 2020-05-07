package Data.Enums.Menus;

public enum EPersonalMenuCommand {
    Marketplace,
    My_products,
    My_account,
    Logout;

    private static EPersonalMenuCommand[] commands = values();
    public static EPersonalMenuCommand fromOrdinal(int n){return commands[n];}
    public static EPersonalMenuCommand fromCommand(int n) { return fromOrdinal(n-1);}
}
