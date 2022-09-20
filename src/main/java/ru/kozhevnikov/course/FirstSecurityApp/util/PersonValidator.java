package ru.kozhevnikov.course.FirstSecurityApp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kozhevnikov.course.FirstSecurityApp.models.Person;
import ru.kozhevnikov.course.FirstSecurityApp.services.PersonService;

@Component
public class PersonValidator implements Validator {

    private final PersonService personService;

    @Autowired
    public PersonValidator(PersonService personService) {
        this.personService = personService;
    }

    // Validation class type
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person)target;
        if (personService.findByUserName(person.getUsername()).isPresent())
                errors.rejectValue("username", "", "User with the current username is already exists");
    }
}
