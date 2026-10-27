package com.example.persondog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootTest
class PersondogApplicationTests {

	@Autowired
	private PersonRepository personRepository;

	@Test
	void contextLoads() {
	}


	@Test
	void testJPA() {

		ArrayList<Dog> dogs = new ArrayList<>();
		Dog dog = new Dog("B","Lila","Mastín", 8, null);
		dogs.add(dog);

		Person person = new Person("2", "Anna", 25, dogs );
		dog.setPersonMapped(person);

		person = personRepository.save(person);

		int count = Math.toIntExact(personRepository.count());
		System.out.println(count);
		System.out.println(person.getName());
		//System.out.println(person);
	}

}
