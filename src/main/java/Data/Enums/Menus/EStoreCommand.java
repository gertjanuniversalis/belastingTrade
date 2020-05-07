package Data.Enums.Menus;

public enum EStoreCommand {
    Buy_product,
    Display_cart_contents,
    Search_products,
    Select_Product;

    private static EStoreCommand[] commands = values();
    public static EStoreCommand fromOrdinal(int n){return commands[n];}
    public static EStoreCommand fromCommand(int n) {return fromOrdinal(n-1);}
}
