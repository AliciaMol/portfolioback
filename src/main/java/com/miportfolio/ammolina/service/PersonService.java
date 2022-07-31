/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.service;

import com.miportfolio.ammolina.exception.UserNotFoundException;
import com.miportfolio.ammolina.model.Person;
import com.miportfolio.ammolina.repository.IPersonRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sisita
 */
@Service
@Transactional
public class PersonService implements IPersonService {

    //inyecto la dependencia del repositorio mediante la annotation @AutoWired.
    //Asi evito crear objetos de conexion como se suele hacer con JDBC
    @Autowired
    public IPersonRepository ipersonRepository;

    @Override
    public List<Person> getAllPerson() {
        //el metodo findAll de hibernate nos trae todos los registros de la tabla
        return ipersonRepository.findAll();
    }

    @Override
    public Person addPerson(Person person) {
        //Este metodo save crea o modifica los datos de una persona
        return ipersonRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        ipersonRepository.deleteById(id);
    }

    @Override
    public Person getPersonById(Long id) {
        //si no encuentra la persona, entonces devuelve null
        return ipersonRepository.getPersonById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found."));
    }

    @Override
    public Person updatePerson(Person person) {
        return ipersonRepository.save(person);
    }
}
