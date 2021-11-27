package com.example.personalinfoactivity.models;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Object> dataList;
    static private Storage instanca;

    private Storage()
    {
        dataList = new ArrayList<Object>();
    }

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

    public List<Object> getDataList() {
        return dataList;
    }
}
