package com.example.orm1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrmController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/save")
    public ModelAndView save(@RequestParam("username") String username,
                             @RequestParam("email") String email){
        jdbcTemplate.update("insert into person values(null, ?, ?)",username, email);
        return new ModelAndView("result");
    }

    @GetMapping("/all")
    public ModelAndView all(){
        ModelAndView modelAndView = new ModelAndView("persons");
        List<Person> personList = jdbcTemplate.query("select * from person", new PersonRowMapper());
        modelAndView.addObject("personList", personList);
        return modelAndView;
    }

}
