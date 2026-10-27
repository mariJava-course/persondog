package com.example.persondog;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Person {

    @Id
    private String id;
    private String name;
    private int age;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "PERSON_DOG_JOIN_TABLE",
            joinColumns = @JoinColumn(name = "PERSON_FK"),
            inverseJoinColumns = @JoinColumn(name = "DOG_FK"))
    private List<Dog> dogs = new ArrayList<>();
}
