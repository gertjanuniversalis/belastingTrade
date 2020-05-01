package Entities.Secondary;

import Data.Enums.EMediaType;
import Entities.Joins.MediaKey;
import Entities.Primary.Product;
import Entities.Primary.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class MediaFile {

    @EmbeddedId
    MediaKey key;

    @Getter @Setter
    String fileName;
    @Getter @Setter
    String localPath;
    @Getter @Setter
    @Enumerated(value = EnumType.STRING)
    EMediaType mediaType;


    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    Product product;

    public MediaFile(){}
}
