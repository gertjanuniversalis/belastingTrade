package Entities.Secondary;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    String streetName;
    String number;
    String City;
}
