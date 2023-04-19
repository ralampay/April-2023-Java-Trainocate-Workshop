package com.companyx.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.companyx.demo.models.Position;
import com.companyx.demo.operations.ValidateCreatePosition;
import com.companyx.demo.repositories.PositionRepository;
import com.companyx.demo.services.PositionsService;
import com.google.gson.Gson;

@RestController
@ResponseBody
@RequestMapping(path={"/api/positions"}, produces=MediaType.APPLICATION_JSON_VALUE)
public class PositionsController {

    @Autowired
    private PositionsService positionsService;
    
    // Endpoint to return all positions
    // GET /api/positions
    @RequestMapping(value={"", "/"})
    public ResponseEntity<String> index() {
        Gson gson = new Gson();

        List<HashMap<String, Object>> items = positionsService.getAll();
        String payload = gson.toJson(items);

        return new ResponseEntity<String>(payload, HttpStatus.OK);
    }

    // Endpoint to return a single position given an id
    // GET /api/positions/:id
    @RequestMapping(value="/{id}")
    public ResponseEntity<String> show(@PathVariable String id) {
        Gson gson = new Gson();

        if(positionsService.exists(id)) {
            String payload = gson.toJson(positionsService.getById(id));

            return new ResponseEntity<String>(payload, HttpStatus.OK);
        } else {
            HashMap<String, Object> result = new HashMap<String, Object>();
            result.put("message", "Not found");

            String payload = gson.toJson(result);

            return new ResponseEntity<String>(payload, HttpStatus.NOT_FOUND);
        }
    }

    // Morning Exercise:
    // Implement the create method and delete method of positionService and call it in its respective controller endpoints

    // Enpoint to add a new position
    // POST /api/positions
    @RequestMapping(value={"", "/"}, method=RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody String params) {
        Gson gson = new Gson();

        HashMap<String, Object> requestParams = gson.fromJson(params, HashMap.class);

        ValidateCreatePosition validator = new ValidateCreatePosition(requestParams);
        validator.run();

        if (validator.valid()) {
            Position position = positionsService.create(requestParams);

            return new ResponseEntity<String>(gson.toJson(position, position.getClass()), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(gson.toJson(validator.getErrors(), validator.getErrors().getClass()), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    // Endpoint to edit a position
    // PUT /api/positions/:id
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<String> edit(@PathVariable String id, @RequestBody String params) {
        Gson gson = new Gson();
        
        if(positionsService.exists(id)) {
            HashMap<String, Object> requestParams = gson.fromJson(params, HashMap.class);

            Position pos = positionsService.update(id, requestParams);

            return new ResponseEntity<String>(gson.toJson(pos, Position.class), HttpStatus.OK);
        } else {
            HashMap<String, Object> result = new HashMap<String, Object>();
            result.put("message", "Not found");

            String payload = gson.toJson(result);

            return new ResponseEntity<String>(payload, HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete a position
    // DELETE /api/positions/:id
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable String id) {
        /*
         * { code: 101, message: "successfully deleted" }
         */
        if (positionsService.exists(id)) {
            positionsService.deleteById(id);
            
            HashMap<String, Object> result = new HashMap<String, Object>();
            result.put("code", 101);
            result.put("message", "Successfully deleted");

            Gson gson = new Gson();
            String payload = gson.toJson(result);

            return new ResponseEntity<String>(payload, HttpStatus.OK);
        } else {
            HashMap<String, Object> result = new HashMap<String, Object>();
            result.put("code", 401);
            result.put("message", "Something went wrong");

            Gson gson = new Gson();
            String payload = gson.toJson(result);

            return new ResponseEntity<String>(payload, HttpStatus.NOT_FOUND);
        }
    }
}
