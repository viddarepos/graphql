package com.graphqldemo.domain.person.repository;

import com.graphqldemo.domain.person.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    boolean existsByAddress(String name);
}
