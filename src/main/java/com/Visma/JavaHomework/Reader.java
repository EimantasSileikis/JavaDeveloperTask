package com.Visma.JavaHomework;

import java.util.ArrayList;
import java.util.List;

public class Reader {
    private final String name;
    private final List<String> takenBooks = new ArrayList<String>();
    private final List<Integer> periods = new ArrayList<Integer>();

    public Reader(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getTakenBooks() {
        return takenBooks;
    }

    public List<Integer> getBooksPeriods(){
        return periods;
    }
}
