package com.example.personalinfoactivity.models;

public class SummaryInfo {
    private PersonalInfo personalInfo;
    private StudentInfo studentInfo;

    public SummaryInfo(PersonalInfo personalInfoData, StudentInfo studentInfoData)
    {
        personalInfo = personalInfoData;
        studentInfo = studentInfoData;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }
}
