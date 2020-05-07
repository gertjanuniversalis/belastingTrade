package Data.Enums.Menus;

public enum EAccountCommand {
    Change_delivery_mode,
    Change_address,
    Change_name,
    Change_password,
    View_delivery_modes,
    Back,
    Logout;

    private static EAccountCommand[] commands = values();
    public static EAccountCommand fromOrdinal(int n){return commands[n];}
    public static EAccountCommand fromCommand(int n) { return fromOrdinal(n-1);  }
}
