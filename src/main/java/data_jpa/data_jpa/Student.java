package data_jpa.data_jpa;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            unique = true,
            updatable = false
    )
    private Long id;
    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "VARCHAR(200)"
    )
    private String name;
    @Column(
            name = "gmail",
            unique = true,
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String gmail;
    @Column(nullable = false)
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gmail='" + gmail + '\'' +
                ", age=" + age +
                '}';
    }

    public String getGmail() {
        return gmail;
    }

    public Student(String name, String gmail, int age) {
        this.name = name;
        this.gmail = gmail;
        this.age = age;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
