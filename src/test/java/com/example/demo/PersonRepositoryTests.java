package com.example.demo;

import com.example.demo.entities.Person;
import com.example.demo.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class PersonRepositoryTests {

    @Autowired
    private PersonRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    void createPerson() {
        List<Person> persons = Stream.of(
                new Person("Avi", "Cohen", 33),
                new Person("Ariel", "David", 29),
                new Person("Benny", "Segal", 54),
                new Person("Eran", "Or", 15),
                new Person("Bar", "Sharabani", 43),
                new Person("Shir", "Magal", 27)
        )
                .map(repository::save)
                .collect(Collectors.toList());

        System.out.println(persons);
    }

}
