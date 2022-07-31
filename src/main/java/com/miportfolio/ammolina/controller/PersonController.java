/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.controller;

import com.miportfolio.ammolina.model.Person;
import com.miportfolio.ammolina.service.IPersonService;
// import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sisita
 */
@RestController
@RequestMapping("/person")

public class PersonController {

    /*mediante una inyeccion de dependencia, conectamos nuestra
    controladora a nuestro servicio, el cual se conecta al 
    repositorio, el cual ,a su vez, se conecta a la base de datos
    De esta manera mantenemos la app separada en multicapas y
    evitamos crear objetos, sino q las relacionamos mediante la 
    inyeccion de dependencias. Asi, la app se vuelve mantenible
    y escalable*/
    
    private final IPersonService ipersonService; //Es una interface
    @Autowired
    public PersonController(IPersonService ipersonService) {
        this.ipersonService = ipersonService;
    }
    
//    List<Persona> listaPersonas = new ArrayList();
    //A continuacion vamos generando todos los endpoints.
    @PostMapping("/add")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        Person newPerson = ipersonService.addPerson(person);
       return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    //@ResponseBody
    public ResponseEntity<List<Person>> getAllPerson() {
        //Llamamos al servicio para hacer que nos devuelva la lista de personas
//        return listaPersonas;
        List<Person> persons= ipersonService.getAllPerson();
        return new ResponseEntity<> (persons, HttpStatus.OK);
//      Entonces dentro de la respuesta, ponemos la lista de personas
//      en el cuerpo y pasamos además el código de estado http que
//      será un éxito.
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable("id") Long id) {
//        listaPersonas.remove(id);
        ipersonService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person){
        Person updatePerson = ipersonService.updatePerson(person);
        return new ResponseEntity<> (updatePerson, HttpStatus.OK);
    }
    
//    @PutMapping("/update/{id}")
//    public Person editPerson(@PathVariable Long id,
//            @RequestParam("name") String newName,
//            @RequestParam("lastname") String newLastName,
//            @RequestParam("email") String email,
//            @RequestParam("ocupation") String newOcupation,
//            @RequestParam("aboutMeDescription") String newAboutMeDesc,
//            @RequestParam("imageURL") String newImg){
//        Person person = ipersonService.searchPerson(id);
//        person.setName(newName);
//        person.setLastname(newLastName);
//        person.setEmail(email);
//        person.setOcupation(newOcupation);
//        person.setAboutMeDescription(newAboutMeDesc);
//        person.setImageURL(newImg);
//        ipersonService.savePerson(person);
//        return person;
//    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id) { //searchPerson(@PathVariable Long id) {
        Person person = ipersonService.getPersonById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
    /* Si quiero buscar por id, agregar lo que difiere de lo comentado,
    ** logre hacerlo funcionar*/
    
    
//     @GetMapping("/getone")  //@GetMapping("/person/getone/{id}")
//    public Person searchPerson() { //searchPerson(@PathVariable Long id) {
//        return ipersonService.searchPerson((long)1);
//    }
}
