package org.dataJpa.jpa_e1.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @OneToOne(cascade = CascadeType.PERSIST ) //fetch = FetchType.LAZY
    @JoinColumn(name = "passport")
    private Passport passport;

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", passport=" + passport.getPassportNumber() +
                '}';
    }
}
