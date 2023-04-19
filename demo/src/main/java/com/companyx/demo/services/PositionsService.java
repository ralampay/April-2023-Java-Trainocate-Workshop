package com.companyx.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyx.demo.models.Position;
import com.companyx.demo.repositories.PositionRepository;

@Service
public class PositionsService {

    @Autowired
    private PositionRepository positionRepository;

    public PositionsService() {}

    public void deleteById(String id) {
        positionRepository.deleteById(id);
    }

    public Position create(HashMap<String, Object> params) {
        String id = UUID.randomUUID().toString();
        String name = params.get("name").toString();

        Position pos = new Position(id, name);
        pos = positionRepository.save(pos);

        return pos;
    }

    public Position update(Position pos, String name) {
        pos.setName(name);

        return this.update(pos);
    }

    public Position update(Position pos) {
        positionRepository.save(pos);

        return pos;
    }

    public Position update(String id, String name) {
        Position pos = positionRepository.findById(id).get();

        pos.setName(name);

        return positionRepository.save(pos);
    }

    public Position update(String id, HashMap<String, Object> params) {
        Position pos = positionRepository.findById(id).get();

        return this.update(pos, params);
    }

    public Position update(Position pos, HashMap<String, Object> params) {
        for (String key : params.keySet()) {
            if (key.equals("name")) {
                pos.setName(params.get("name").toString());
            }
        }

        return positionRepository.save(pos);
    }

    public Position create(String name) {
        String id = UUID.randomUUID().toString();

        Position pos = new Position(id, name);
        pos = positionRepository.save(pos);

        return pos;
    }

    public List<HashMap<String, Object>> getAll() {
        ArrayList<HashMap<String, Object>> items = new ArrayList<HashMap<String, Object>>();

        List<Position> positions = positionRepository.findAll();

        for (Position pos : positions) {
            HashMap<String, Object> posItem = new HashMap<String, Object>();
            posItem.put("id", pos.getId());
            posItem.put("name", pos.getName());

            items.add(posItem);
        }

        return items;
    }

    public HashMap<String, Object> getById(String id) {
        HashMap<String, Object> item = new HashMap<String, Object>();

        Position pos = positionRepository.findById(id).get();
        item.put("id", pos.getId());
        item.put("name", pos.getName());

        return item;
    }

    public boolean exists(String id) {
        return positionRepository.findById(id).isPresent();
    }
}
