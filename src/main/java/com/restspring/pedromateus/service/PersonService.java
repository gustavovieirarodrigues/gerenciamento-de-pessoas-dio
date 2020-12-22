package com.restspring.pedromateus.service;


import com.restspring.pedromateus.dto.MessageResponseDTO;
import com.restspring.pedromateus.dto.request.PersonDTO;
import com.restspring.pedromateus.entity.Person;
import com.restspring.pedromateus.exceptions.PersonNotFoundException;
import com.restspring.pedromateus.mapper.PersonMapper;
import com.restspring.pedromateus.repository.PersonRespository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
    private PersonRespository personRespository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRespository.save(personToSave);
        return createMessageResponse(savedPerson.getId(), "Created person with id: ");
    }

    public List<PersonDTO> listAll() {
        List<Person> list=personRespository.findAll();
        return list.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExist(id);
        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        Person person = verifyIfExist(id);
        personRespository.delete(person);
    }

    private Person verifyIfExist(Long id) throws PersonNotFoundException {
        return personRespository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    public MessageResponseDTO update(PersonDTO personDTO, Long id) throws PersonNotFoundException {
        verifyIfExist(id);
        Person personToUpdate = personMapper.toModel(personDTO);
        Person updatePerson = personRespository.save(personToUpdate);
        return createMessageResponse(updatePerson.getId(), "updated person with id: ");


    }

    private MessageResponseDTO createMessageResponse(Long id, String s) {
        return MessageResponseDTO.builder().message(s + id).build();
    }
}
