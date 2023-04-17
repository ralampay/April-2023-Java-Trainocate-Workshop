package com.companyx.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PositionsService {

    private ArrayList<HashMap<String, Object>> items = new ArrayList<HashMap<String, Object>>();

    public PositionsService() {
        HashMap<String, Object> position1 = new HashMap<String, Object>();
        position1.put("id", 1);
        position1.put("name", "Finance Manager");

        items.add(position1);

        HashMap<String, Object> position2 = new HashMap<String, Object>();
        position2.put("id", 2);
        position2.put("name", "Dealer");

        items.add(position2);
    }

    public List<HashMap<String, Object>> getAll() {
        return items;
    }

    public HashMap<String, Object> getById(int id) {
        HashMap<String, Object> item = null;

        for (HashMap<String,Object> hashMap : items) {
            if ((int)hashMap.get("id") == id) {
                item = hashMap;
            } 
        }

        return item;
    }
}
