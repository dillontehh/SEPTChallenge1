package com.example.septchallenge1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeptChallenge1Controller {

    @RequestMapping
    public String testController(){
        return "Hello World";
    }

}
