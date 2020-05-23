package com.example.demo.Controller;

import com.example.demo.Model.Person;
import com.example.demo.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class HomeController {

    @Autowired
    PersonService personService;

    @GetMapping("/")
    public String index(Model model){
        List<Person> personList = personService.fetchAll();
        model.addAttribute("people", personList);
        return "home/index";
    }

    @GetMapping("/create")
    public  String create(){
        return "home/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Person person){
        personService.addPerson(person);
        return "redirect:/";

    }

    @GetMapping("/viewOne/{people_id}")
    public String viewOne(@PathVariable("people_id") int people_id, Model model){
        model.addAttribute("person", personService.findPersonById(people_id));
        return "home/viewOne";
    }

    @GetMapping("/delete/{people_id}")
    public String delete(@PathVariable("people_id") int people_id){
        boolean deleted = personService.deletePerson(people_id);
        if (deleted){
            return "redirect:/";
        }else {
            return "redirect:/";
        }
    }

    @GetMapping("/update/{people_id}")
    public String update(@PathVariable("people_id") int people_id, Model model){
        model.addAttribute("person", personService.findPersonById(people_id));
        return "home/update";
    }

    @PostMapping("/updatePerson")
    public String updatePerson(@ModelAttribute Person person){
        personService.updatePerson(person.getPeople_id(), person);
        return "redirect:/";
    }

}
