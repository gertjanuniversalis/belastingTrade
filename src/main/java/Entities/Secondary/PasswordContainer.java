package Entities.Secondary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PasswordContainer {
    @Id
    @Getter
    private int userId;

    @Getter @Setter
    private String password;

    public PasswordContainer(){}

    public PasswordContainer(int id, String generatedPass) {
        this.userId = id;
        this.password = generatedPass;
    }
}
