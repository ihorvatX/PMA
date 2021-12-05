package com.example.personalinfoactivity.apiModels;

import java.util.ArrayList;

public class Course {
    private String title;
    private ArrayList<Instructor> instructors;



    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    public String getTitle() {
        return title;
    }
}
