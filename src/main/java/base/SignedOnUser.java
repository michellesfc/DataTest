package base;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "UserTable")
public class SignedOnUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    protected SignedOnUser() {
    }

    public SignedOnUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("SignedOnUser[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
    }
}
