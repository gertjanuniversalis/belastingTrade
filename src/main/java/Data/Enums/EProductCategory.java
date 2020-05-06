package Data.Enums;

public enum EItemCat {
    Undecided,
    Computer,
    Mobile,
    Art;

    private static EItemCat[] categories = values();
    public static EItemCat fromOrdinal(int n){return categories[n];}
    public static EItemCat fromCommand(int n) { return fromOrdinal(n-1);  }
}
