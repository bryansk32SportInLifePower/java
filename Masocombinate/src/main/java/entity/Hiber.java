package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name="task",schema="public",catalog = "Money")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hiber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,length = -1)
    private int id;

    @Column(name = "tovar",nullable = false,length = -1)
    private String tovar;

    @Column(name = "chena",nullable = false,length = -1)
    private Double chena;

    @Column(name = "data",nullable = true,length = -1)
    private Date date;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hiber hiber = (Hiber) o;
        return id == hiber.id && tovar.equals(hiber.tovar) && chena.equals(hiber.chena) && date.equals(hiber.date);
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id=" + id +
                ", client='" + tovar + '\'' +
                ", phone number=" + chena +

                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(tovar, chena, date, id);
    }

}
