package com.companyx.demo.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.companyx.demo.services.PositionsService;

@RestController
@RequestMapping("/api/positions")
public class PositionsController {

    @Autowired
    private PositionsService positionsService;
    
    // Endpoint to return all positions
    // GET /api/positions
    @RequestMapping(value={"", "/"})
    public String index() {
        List<HashMap<String, Object>> items = positionsService.getAll();

        return "Number of positions: " + items.size();
    }

    // Endpoint to return a single position given an id
    // GET /api/positions/:id
    @RequestMapping(value="/{id}")
    public String show(@PathVariable int id) {
        HashMap<String, Object> item = positionsService.getById(id);

        return "A single position with id " + id + " and name " + item.get("name");
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
