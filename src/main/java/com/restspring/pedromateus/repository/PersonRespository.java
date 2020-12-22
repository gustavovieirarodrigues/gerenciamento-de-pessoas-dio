package com.restspring.pedromateus.repository;

import com.restspring.pedromateus.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRespository extends JpaRepository<Person,Long> {
}
