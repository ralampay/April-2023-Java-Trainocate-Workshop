package com.companyx.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagesController {

    @RequestMapping("/api/index")
    public String index() {
        return "Index";
    }
    
    @RequestMapping("/api/about")
    public String about() {
        return "About";
    }

    // Homework:
    // Create an endpoint that returns a string version of the report
    // Notes:
    //  - DO not put the logic in the controller method
    //  - Utilize the command pattern to build the HashMap that represents the report
    //  - Return a string version of the report
}
