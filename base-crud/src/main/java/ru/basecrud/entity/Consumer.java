package ru.basecrud.entity;


import lombok.Data;

import javax.persistence.*;

@Table(name = "consumer")
@Entity
@Data
public class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String firstName;
    private String lastName;
    private int age;
}
