package com.graphqldemo.infrastructure.mapper;

import com.graphqldemo.domain.person.entity.Person;
import com.graphqldemo.domain.person.model.PersonRequestDTO;
import com.graphqldemo.domain.person.model.PersonUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person toPerson(PersonRequestDTO personRequestDTO);

    PersonRequestDTO toPersonDTO(Person person);

    void updateEmployeeFromDto(PersonUpdateDTO personUpdateDTO, @MappingTarget Person entity);

}
