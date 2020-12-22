package com.restspring.pedromateus.controller;

import com.restspring.pedromateus.dto.MessageResponseDTO;
import com.restspring.pedromateus.dto.request.PersonDTO;
import com.restspring.pedromateus.exceptions.PersonNotFoundException;
import com.restspring.pedromateus.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO getBook(@RequestBody PersonDTO personDTO){
        return personService.createPerson(personDTO);

    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO update(@RequestBody PersonDTO personDTO, @PathVariable @Valid Long id) throws PersonNotFoundException {
        return personService.update(personDTO, id);
    }

}
