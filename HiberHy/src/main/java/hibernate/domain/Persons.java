package hibernate.domain;
import javax.persistence.*;
@Entity
@Table(name = "persons")
public class Persons {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")

    private Long personId;
    @Column(name = "first_name")

    private String firstName;
    @Column(name = "last_name")

    private String lastName;

    public Long getPersonId() {
        return personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
