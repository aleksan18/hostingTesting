package com.example.demo.Model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

    // Fields
    @Id
    private int people_id;
    private String first_name;
    private String last_name;

    // Constructors

    public Person(){}

    public Person(int people_id, String first_name, String last_name) {
        this.people_id = people_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    // Setters and Getters


    public int getPeople_id() {
        return people_id;
    }

    public void setPeople_id(int people_id) {
        this.people_id = people_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
