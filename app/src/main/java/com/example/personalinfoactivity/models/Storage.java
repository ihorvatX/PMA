package com.example.personalinfoactivity.models;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Object> dataList;
    private Storage()
    {
        dataList = new ArrayList<Object>();
    }
    static private Storage instanca;

    public static Storage getInstance()
    {
        if(instanca==null)
        {
            instanca = new Storage();
        }
        return  instanca;
    }

    public void setStudents(Student student) {
        this.dataList.add(student);
    }

    public List<Object> getStudents() {
        return dataList;
    }
}
