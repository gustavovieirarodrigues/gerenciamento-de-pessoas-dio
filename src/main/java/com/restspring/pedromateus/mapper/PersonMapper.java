package com.restspring.pedromateus.mapper;

import com.restspring.pedromateus.dto.request.PersonDTO;
import com.restspring.pedromateus.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE= Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate",source = "birthDate",dateFormat = "dd/MM/yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
