package Entities.Primary;

import Data.Enums.EGender;
import Data.Enums.EAccountType;
import Entities.Secondary.Address;
import Entities.Secondary.MediaFile;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue
    @Getter
    private int id;

    @Getter @Setter
    protected String email;

    @Getter @Setter
    protected String name;
    @Getter @Setter
    protected String lastName;
    @Getter @Setter
    @Enumerated(value = EnumType.STRING)
    protected EGender gender;
    @Getter @Setter
    @Enumerated(value = EnumType.STRING)
    protected EAccountType accountType;

    @Getter @Setter
    @Embedded
    protected Address address;

    @Getter
    @PastOrPresent
    private Date signupDate = new Date();

    @Getter
    @OneToMany(mappedBy = "placedBy", cascade = CascadeType.MERGE)
    private List<Product> placedProducts = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
    Set<MediaFile> media;

    public User(){}
}
