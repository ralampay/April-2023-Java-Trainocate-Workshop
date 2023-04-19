package com.companyx.demo.operations;

import java.util.ArrayList;
import java.util.HashMap;

public class ValidateCreatePosition {
    private HashMap<String, Object> params;
    private HashMap<String, ArrayList<String>> errors;

    public ValidateCreatePosition(HashMap<String, Object> params) {
        this.params = params;

        this.errors = new HashMap<String, ArrayList<String>>();

        // name
        ArrayList<String> nameErrors = new ArrayList<String>();
        this.errors.put("name", nameErrors);
    }

    public void run() {
        // validate name. Rules:
        // 1. Should be present
        // 2. Should be unique
        if (params.get("name") == null) {
            this.errors.get("name").add("Name is required");
        }
    }

    public boolean valid() {
        int count = 0;

        for (String key : this.errors.keySet()) {
            count += this.errors.get(key).size();
        }

        return count == 0;
    }

    public HashMap<String, ArrayList<String>> getErrors() {
        return this.errors;
    }
}
