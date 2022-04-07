package entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
@Entity
@Table(name="Sov",schema="public",catalog = "Money")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sovetskyi {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    @Column(name = "id",nullable = false,length = -1)
    private int id;

@Basic
    @Column(name = "nameC",nullable = false,length = -1)
    private String nameClient;

@Basic
    @Column(name = "nameN",nullable = false,length = -1)
    private Double nameNumber;



    public String getNameClient() {
        return nameClient;
    }
    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public Double getNumber() {
        return nameNumber;
    }
    public void setNumber(Double nameNumber) {
        this.nameNumber = nameNumber;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       Sovetskyi sovetskyi = (Sovetskyi) o;
        return id == sovetskyi.id && nameClient.equals(sovetskyi.nameClient) &&nameNumber.equals(sovetskyi.nameNumber) ;
    }

    @Override
    public String toString() {
        return "Sovetskyi{" +
                "id=" + id +
                ", name='" + nameClient + '\'' +
                ", number=" + nameNumber +

                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(nameClient, nameNumber,  id);
    }

}
