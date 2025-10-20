package org.dataJpa.jpa_e1.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String PassportNumber;

    @OneToOne(mappedBy = "passport")
    private Person person;

    @Override
    public String toString() {
        return "Passport{" +
                "Id=" + Id +
                ", PassportNumber='" + PassportNumber + '\'' +
                ", person=" + person.getName() +
                '}';
    }
}
