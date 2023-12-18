package com.graphqldemo.web;

import com.graphqldemo.domain.person.entity.Person;
import com.graphqldemo.domain.person.model.PersonRequestDTO;
import com.graphqldemo.domain.person.model.PersonUpdateDTO;
import com.graphqldemo.domain.person.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @QueryMapping
    public Page<Person> findPaged(@Argument int page, @Argument int size) {
        return personService.findPaged(page, size);
    }

    @QueryMapping
    public Person findOne(@Argument Integer id) {
        return personService.findOne(id);
    }

    @MutationMapping
    public Person create(@Argument("person") PersonRequestDTO personRequestDTO) {
        return personService.create(personRequestDTO);
    }

    @MutationMapping
    public Person update(@Argument("updatedPerson") PersonUpdateDTO personUpdateDTO, @Argument(value = "id") Integer id) {
        return personService.update(personUpdateDTO, id);
    }

    @MutationMapping
    public Person delete(@Argument Integer id) {
      return  personService.delete(id);
    }
}