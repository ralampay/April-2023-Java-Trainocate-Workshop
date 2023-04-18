package com.companyx.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.companyx.demo.models.Position;
import com.companyx.demo.repositories.PositionRepository;
import com.companyx.demo.services.PositionsService;
import com.google.gson.Gson;

@RestController
@ResponseBody
@RequestMapping(path={"/api/positions"}, produces=MediaType.APPLICATION_JSON_VALUE)
public class PositionsController {

    @Autowired
    private PositionsService positionsService;

    @Autowired
    private PositionRepository positionRepository;
    
    // Endpoint to return all positions
    // GET /api/positions
    @RequestMapping(value={"", "/"})
    public String index() {
        Gson gson = new Gson();

        List<Position> positions = positionRepository.findAll();
        String payload = gson.toJson(positions);

        return payload;
    }

    // Endpoint to return a single position given an id
    // GET /api/positions/:id
    @RequestMapping(value="/{id}")
    public String show(@PathVariable String id) {
        Gson gson = new Gson();
        Optional<Position> res = positionRepository.findById(id);

        if(res.isPresent()) {
            String payload = gson.toJson(res.get());

            return payload;
        } else {
            HashMap<String, Object> result = new HashMap<String, Object>();
            result.put("message", "Not found");

            String payload = gson.toJson(result);

            return payload;
        }
    }

    // Morning Exercise:
    // Implement the create method and delete method of positionService and call it in its respective controller endpoints

    // Enpoint to add a new position
    // POST /api/positions
    @RequestMapping(value={"", "/"}, method=RequestMethod.POST)
    public String create(@RequestBody String params) {
        Gson gson = new Gson();

        HashMap<String, Object> requestParams = gson.fromJson(params, HashMap.class);

        String newId = UUID.randomUUID().toString();
        String newName = requestParams.get("name").toString();

        Position position = new Position(newId, newName);

        positionRepository.save(position);

        String payload = gson.toJson(position);

        return payload;
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
        /*
         * { code: 101, message: "successfully deleted" }
         */
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("code", 101);
        result.put("message", "Successfully deleted");

        Gson gson = new Gson();
        String payload = gson.toJson(result);

        return payload;
    }
}
