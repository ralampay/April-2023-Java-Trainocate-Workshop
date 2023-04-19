package com.companyx.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyx.demo.models.Position;
import com.companyx.demo.repositories.PositionRepository;

@Service
public class PositionsService {

    @Autowired
    private PositionRepository positionRepository;

    public PositionsService() {}

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
}
