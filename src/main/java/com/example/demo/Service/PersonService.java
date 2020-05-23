package com.example.demo.Service;

import com.example.demo.Model.Person;
import com.example.demo.Repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepo personRepo;

    public List<Person> fetchAll(){
        return personRepo.fetchAll();
    }

    public Person addPerson(Person p){
        return personRepo.addPerson(p);
    }

    public Person findPersonById(int id){
        return personRepo.findPersonById(id);
    }

    public Boolean deletePerson(int id){
        return personRepo.deletePerson(id);
    }

    public Person updatePerson(int id, Person p){
        return personRepo.updatePerson(id, p);
    }
}
