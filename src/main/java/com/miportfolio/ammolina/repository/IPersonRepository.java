/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.repository;

import com.miportfolio.ammolina.model.Person;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sisita
 */
@Repository
public interface IPersonRepository extends JpaRepository<Person, Long>{
    public Optional <Person> getPersonById(Long id);
}
/*Le pasamos que tome de la clase Person, y el tipo de dato que 
es la primary key que es id, por eso Long*/