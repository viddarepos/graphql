package com.graphqldemo.domain.person.model;

public record PersonRequestDTO(
        String firstName,
        String lastName,
        String address,
        Integer age
) {
}
