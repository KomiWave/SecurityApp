package ru.kozhevnikov.course.FirstSecurityApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kozhevnikov.course.FirstSecurityApp.models.Person;
import ru.kozhevnikov.course.FirstSecurityApp.repositories.PeopleRepository;

import java.util.Optional;

@Service
public class PersonService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Optional<Person> findByUserName(String username) {
        Optional<Person> person = peopleRepository.findByUsername(username);
        return person;
    }
}
