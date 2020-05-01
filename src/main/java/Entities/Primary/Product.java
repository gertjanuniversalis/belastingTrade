package Entities.Primary;

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

@Entity
public class Product {
    @Id
    @GeneratedValue
    @Getter
    private int id;

    @Getter @Setter
    @NotBlank
    private String name;
    @Getter @Setter
    @PositiveOrZero
    private double price;
    @Getter @Setter
    private String description;
    @Getter
    @PastOrPresent
    private Date datePlaced = new Date();
    @Getter @Setter
    private boolean inStore;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @NotNull
    private User placedBy;

    @Getter @Setter
    @ManyToOne
    private User soldTo;

    @Getter @Setter
    @OneToMany(mappedBy = "product")
    private Set<MediaFile> media;

    public Product(){}


}
