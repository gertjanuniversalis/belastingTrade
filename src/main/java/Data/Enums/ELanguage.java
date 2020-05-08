package Data.Enums;

public enum ELanguage {
    English, Nederlands;

    private static ELanguage[] languages = values();
    public static ELanguage fromOrdinal(int n){return languages[n];}

    public static ELanguage fromCommand(int n) { return fromOrdinal(n-1);}
}
