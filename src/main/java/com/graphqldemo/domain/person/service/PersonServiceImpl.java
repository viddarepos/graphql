package com.graphqldemo.domain.person.service;

import com.graphqldemo.domain.person.model.PersonRequestDTO;
import com.graphqldemo.domain.person.model.PersonUpdateDTO;
import com.graphqldemo.infrastructure.exception.customException.InvalidInputException;
import com.graphqldemo.infrastructure.mapper.PersonMapper;
import com.graphqldemo.domain.person.repository.PersonRepository;
import com.graphqldemo.domain.person.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonMapper personMapper;
    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonMapper personMapper, PersonRepository personRepository) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    @Override
    public Person findOne(Integer id) {
        return personRepository.findById(id).orElseThrow(() -> new InvalidInputException("Person with %d id doesn't found!".formatted(id)));
    }

    @Override
    public Person create(PersonRequestDTO personRequestDTO) {
        Person person = personMapper.toPerson(personRequestDTO);

        if (personRepository.existsByAddress(personRequestDTO.address())) {
            throw new InvalidInputException("User with address %s already exists!".formatted(personRequestDTO.address()));
        }

        return personRepository.save(person);
    }

    @Override
    public Person delete(Integer id) {
        if (!personRepository.existsById(id)) {
            throw new InvalidInputException("User with %d doesn't exists!".formatted(id));
        }
        Person deletedPerson = findOne(id);
        personRepository.deleteById(id);

        return deletedPerson;
    }

    @Override
    public Person update(PersonUpdateDTO personUpdateDTO, Integer id) {
        Person currentPerson = findOne(id);
        personMapper.updateEmployeeFromDto(personUpdateDTO, currentPerson);
        personRepository.save(currentPerson);

        return currentPerson;
    }

    @Override
    public Page<Person> findPaged(int page, int size) {
        PageRequest pr = PageRequest.of(page, size);

        return personRepository.findAll(pr);
    }
}