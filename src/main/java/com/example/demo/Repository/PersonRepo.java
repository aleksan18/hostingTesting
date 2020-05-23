package com.example.demo.Repository;

import com.example.demo.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepo {

    @Autowired
    JdbcTemplate template;

    public List<Person> fetchAll(){
        String sql = "SELECT * FROM people;";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        return template.query(sql, rowMapper);
    }

    public Person addPerson(Person p){
        String sql = "INSERT INTO people (first_name, last_name) VALUES (?, ?);";
        template.update(sql, p.getFirst_name(), p.getLast_name());
        return null;
    }

    public Person findPersonById(int id){
        String sql = "SELECT * FROM people WHERE people_id = ?;";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        Person p = template.queryForObject(sql, rowMapper, id);
        return p;
    }

    public Boolean deletePerson(int id){
        String sql = "DELETE FROM people WHERE people_id = ?;";
        return template.update(sql, id) < 0;
    }

    public Person updatePerson(int id, Person p){
        String sql = "UPDATE people SET first_name = ?, last_name = ? WHERE people_id = ?;";
        template.update(sql, p.getFirst_name(), p.getLast_name(),id);
        return null;
    }
}
