package com.example.personalinfoactivity.interfaces;

import com.example.personalinfoactivity.models.StudentInfo;

public interface StudentInfoListener {
    void setStudent(StudentInfo studentInfo);
    StudentInfo getStudent();
}
