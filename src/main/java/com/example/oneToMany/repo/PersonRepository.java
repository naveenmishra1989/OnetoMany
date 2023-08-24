package com.example.oneToMany.repo;

import com.example.oneToMany.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}