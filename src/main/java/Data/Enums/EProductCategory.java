package Data.Enums;

public enum EProductCategory {
    Undecided,
    Computer,
    Mobile,
    Art,
    It_Support,
    Tutorial,
    Transport;;

    private static EProductCategory[] categories = values();
    public static EProductCategory fromOrdinal(int n){return categories[n];}
    public static EProductCategory fromCommand(int n) { return fromOrdinal(n-1);  }
}
