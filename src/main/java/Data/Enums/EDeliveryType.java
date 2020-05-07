package Data.Enums;

public enum EDeliveryType {
    Pickup_from_store,
    Pickup_from_home,
    Mailed, Unset;

    private static EDeliveryType[] types = values();
    public static EDeliveryType fromOrdinal(int n){return types[n];}
}
