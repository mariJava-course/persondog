package com.example.persondog;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @OneToMany(mappedBy = "personMapped", cascade = CascadeType.ALL)
    private List<Dog> dogs = new ArrayList<Dog>();
}
