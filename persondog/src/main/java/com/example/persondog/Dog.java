package com.example.persondog;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Dog {

    @Id
    private String id;
    private String name;
    private String breed;
    private int age;

    // uni-directional, dog side is owner
    // many dogs can have one owner
    // so the annotation will be @ManyToOne
    // @JoinColumn is used to define the FK from Person
    // @JsonIgnore is not necessary
    @JoinColumn(name = "PERSON_FK")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Person person;
}
