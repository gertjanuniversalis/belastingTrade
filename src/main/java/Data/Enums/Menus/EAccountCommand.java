package Data.Enums.Menus;

public enum EAccountCommand {
    Change_password,
    Change_name,
    Change_delivery_mode,
    View_delivery_modes,
    Back,
    Logout;

    private static EAccountCommand[] commands = values();
    public static EAccountCommand fromOrdinal(int n){return commands[n];}
}
