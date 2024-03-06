package kg.example.spring_demo.controllers;

import kg.example.spring_demo.PersonRepository;
import kg.example.spring_demo.entity.PersonEntity;
import kg.example.spring_demo.models.PersonModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping("/get-all")
    public ResponseEntity<List<PersonEntity>> getAllPersons(){
        return ResponseEntity.ok().body(personRepository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<PersonEntity> createPerson(@RequestBody PersonModel personModel){
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(personModel.getName());
        personEntity.setSurname(personModel.getSurname());
        personEntity.setAge(personModel.getAge());
        personEntity.setNationality(personModel.getNationality());
        personEntity.setGender(personModel.getGender());
        return ResponseEntity.ok().body(personRepository.save(personEntity));
    }

}
