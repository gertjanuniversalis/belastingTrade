package Data.Enums;

public enum EProductSearchType {
    Name,
    Category,
    PriceRange;

    private static EProductSearchType[] searchTypes = values();
    public static EProductSearchType fromOrdinal(int n){return searchTypes[n];}
    public static EProductSearchType fromCommand(int n){return fromOrdinal(n-1);}
}
