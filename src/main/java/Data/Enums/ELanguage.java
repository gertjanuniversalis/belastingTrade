package Data.Enums;

public enum ELanguage {
    English;

    private static ELanguage[] languages = values();
    public static ELanguage fromOrdinal(int n){return languages[n];}
}
