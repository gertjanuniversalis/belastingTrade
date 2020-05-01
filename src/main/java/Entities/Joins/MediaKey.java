package Entities.Joins;

import Entities.Secondary.MediaFile;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MediaKey implements Serializable {

    @Column(name = "user_id")
    int userId;

    @Column(name = "product_id")
    int productId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public MediaKey(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MediaKey mediaKey = (MediaKey) o;
        return userId == mediaKey.userId &&
                productId == mediaKey.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, productId);
    }
}
