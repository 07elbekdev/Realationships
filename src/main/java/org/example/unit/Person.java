package org.example.unit;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String name;
    private int age;
    @OneToOne
    @JoinColumn(name = "phones_id")
    private Phones phones;

    public Person() {
    }

    public Person(String name, int age, Phones phones) {
        this.name = name;
        this.age = age;
        this.phones = phones;
    }
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
//                ", phones=" + phones +
                '}';
    }
}