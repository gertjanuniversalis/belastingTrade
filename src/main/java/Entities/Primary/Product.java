package Entities.Primary;

import Data.Enums.EDeliveryType;
import Data.Enums.EProductCategory;
import Entities.Secondary.MediaFile;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;
import java.util.Set;

import static javax.persistence.EnumType.STRING;

@Entity
public class Product {
    @Id
    @GeneratedValue
    @Getter
    private int id;

    @Getter
    @Setter
    @NotBlank
    private String name;
    @Getter
    @Setter
    @PositiveOrZero
    private double price;
    @Getter
    @Setter
    private String description;
    @Getter
    @PastOrPresent
    private Date datePlaced = new Date();
    @Getter
    @Setter
    private boolean inStore;
    @Getter
    @Setter
    @Enumerated(value = STRING)
    private EProductCategory category;
    @Getter
    @Setter
    @Enumerated(value = STRING)
    private EDeliveryType deliveryType;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @NotNull
    private User placedBy;

    @Getter
    @Setter
    @ManyToOne
    private User soldTo;

    @Getter
    @Setter
    @OneToMany(mappedBy = "product")
    private Set<MediaFile> media;

    public Product() {
    }

    public Product(String productName, String description, double price, EProductCategory cat, EDeliveryType deliveryType) {
        this.name = productName;
        this.description = description;
        this.price = price;
        this.category = cat;
        this.deliveryType = deliveryType;
    }

    @Override
    public String toString() {
        return "name='" + name + "\n" +
                "Category=" + category.name() +
                "price=" + price + "\n" +
                "description='" + description + "\n" +
                "datePlaced=" + datePlaced + "\n" +
                "in tore=" + inStore + "\n" +
                "soldTo=" + soldTo + "\n";
    }
}
