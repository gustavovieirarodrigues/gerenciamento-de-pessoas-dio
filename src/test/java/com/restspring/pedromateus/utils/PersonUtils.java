package com.restspring.pedromateus.utils;


import com.restspring.pedromateus.dto.request.PersonDTO;
import com.restspring.pedromateus.entity.Person;
import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static final String FIRST_NAME = "Pedro";
    private static final String LAST_NAME = "Mateus";
    private static final String CPF_NUMBER = "999.999.999-99";
    private static final long PERSON_ID = 1L;
    //public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

    public static PersonDTO createFakeDTO() {
        final PersonDTO personDTO = PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
        return personDTO;
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
