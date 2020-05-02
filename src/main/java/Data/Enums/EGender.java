package Data.Enums;

public enum EGender {
    Unknown,
    Male,
    Female;

    private static EGender[] genders = values();
    public static EGender fromOrdinal(int n){ return genders[n];}
}
