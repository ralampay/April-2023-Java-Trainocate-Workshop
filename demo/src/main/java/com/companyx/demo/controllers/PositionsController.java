package com.companyx.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/positions")
public class PositionsController {
    
    // Endpoint to return all positions
    // GET /api/positions
    @RequestMapping(value={"", "/"})
    public String index() {
        return "All positions";
    }

    // Endpoint to return a single position given an id
    // GET /api/positions/:id
    @RequestMapping(value="/{id}")
    public String show(@PathVariable int id) {
        return "A single position with id " + id;
    }

    // Enpoint to add a new position
    // POST /api/positions
    @RequestMapping(value={"", "/"}, method=RequestMethod.POST)
    public String create() {
        return "Creating new position";
    }

    // Endpoint to edit a position
    // PUT /api/positions/:id
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String edit(@PathVariable int id) {
        return "Editing position with id " + id;
    }

    // Endpoint to delete a position
    // DELETE /api/positions/:id
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String delete(@PathVariable int id) {
        return "Deleting position with id " + id;
    }
}
