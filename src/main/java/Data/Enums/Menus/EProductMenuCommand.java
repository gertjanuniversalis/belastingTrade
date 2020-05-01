package Data.Enums.Menus;

public enum EProductMenuCommand {
    Place_product,
    Edit_product,
    List_offered_products,
    Back;

    private static EProductMenuCommand[] commands = values();
    public static EProductMenuCommand fromOrdinal(int n){return commands[n];}
}
