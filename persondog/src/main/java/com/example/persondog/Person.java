package com.example.persondog;

import jakarta.persistence.*;
import lombok.*;

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

    // the annotation will be @OneToMany
    // one person can have many dogs
    // person is NOT the owner, it is the dog
    // so person is the inverse side
    // and dog is the owner side
    // at inverse side, we need to define/map the owner side with
    // the name of the owner side in the owner side class
    @OneToMany(mappedBy = "personMapped" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Dog> dogs ;
}
