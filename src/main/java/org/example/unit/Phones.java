package org.example.unit;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "phones")
@Data
public class Phones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "model")
    private String model;
    private int date;
    @OneToOne(mappedBy = "phones", cascade = CascadeType.ALL)
    private Person person;

    public Phones() {
    }

    public Phones(String model, int date) {
        this.model = model;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Phones{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", date=" + date +
                '}';
    }
}