package com.graphqldemo.domain.person.service;

import com.graphqldemo.domain.person.entity.Person;
import com.graphqldemo.domain.person.model.PersonRequestDTO;
import com.graphqldemo.domain.person.model.PersonUpdateDTO;
import org.springframework.data.domain.Page;

public interface PersonService {

    Person findOne(Integer id);

    Person create(PersonRequestDTO personRequestDTO);

    Person delete(Integer id);

    Person update(PersonUpdateDTO personUpdateDTO, Integer id);

    Page<Person> findPaged(int page, int size);
}
