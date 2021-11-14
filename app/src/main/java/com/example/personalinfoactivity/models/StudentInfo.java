package com.example.personalinfoactivity.models;

import java.io.Serializable;
import java.util.Date;

public class StudentInfo implements Serializable {

    public String Name;
    public String Surname;
    public String Birth;

    public StudentInfo(String name, String surname, String birth )
    {
        this.Name = name;
        this.Surname = surname;
        this.Birth = birth;
    }
}
