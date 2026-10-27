package com.example.persondog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class PersondogApplicationTests {

	@Autowired
	private PersonRepository personRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testJPA() {

		Person person1 = Person.builder()
				.id("p-002")
				.name("John")
				.age(30)
				.build();

		Person person2 = Person.builder()
				.id("p-003")
				.name("Anna")
				.age(25)
				.build();

		Dog dog1 = Dog.builder()
				.id("d-004")
				.name("Max4").
				breed("Pastor").
				age(15).
				build();
		Dog dog2 = Dog.builder()
				.id("d-005")
				.name("Nano5").
				breed("Pastor").
				age(6).
				build();
		Dog dog3 = Dog.builder()
				.id("d-006")
				.name("Max6").
				breed("Timber").
				age(12).
				build();

		List<Person> persons = new ArrayList<>();
		persons.add(person1);
		persons.add(person2);
		dog1.setPersons(persons);
		dog2.setPersons(persons);
		dog3.setPersons(persons);

		List<Dog> dogs = new ArrayList<>();
		dogs.add(dog1);
		dogs.add(dog2);
		dogs.add(dog3);
		person1.setDogs(dogs);
		person2.setDogs(dogs);


		personRepository.save(person1);
		personRepository.save(person2);

		person1 = personRepository.findById("p-002").get();
		System.out.println(person1.getName());
		person2 = personRepository.findById("p-003").get();
		System.out.println(person2.getName());
	}

	@Test
	void testJPA2() {

		Person person1 = personRepository.findById("p-002").get();
		System.out.println(person1.getName());
		Person person2 = personRepository.findById("p-003").get();
		System.out.println(person2.getName());

		System.out.println("Dogs of " + person1.getName());
		for (Dog dog : person1.getDogs()) {
			System.out.println(dog.getName());
		}

		System.out.println("Dogs of " + person2.getName());
		for (Dog dog : person2.getDogs()) {
			System.out.println(dog.getName());
		}

		Dog dog1 = person1.getDogs().getFirst();
		System.out.println("Persons of " + dog1.getName());
		for (Person person : dog1.getPersons()) {
			System.out.println(person.getName());
		}

	}
}
