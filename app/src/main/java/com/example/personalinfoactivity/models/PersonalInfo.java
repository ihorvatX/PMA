package com.example.personalinfoactivity.models;

import java.io.Serializable;
import java.util.Date;

public class PersonalInfo implements Serializable {

    public String Name;
    public String Surname;
    public String Birth;

    public PersonalInfo(String name, String surname, String birth )
    {
        this.Name = name;
        this.Surname = surname;
        this.Birth = birth;
    }
}
