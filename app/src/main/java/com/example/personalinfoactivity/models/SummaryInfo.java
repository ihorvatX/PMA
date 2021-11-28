package com.example.personalinfoactivity.models;

public class SummaryInfo {
    private PersonalInfo personalInfo;
    private StudentInfo studentInfo;

    public SummaryInfo(PersonalInfo personalInfoData, StudentInfo studentInfoData)
    {
        personalInfo = personalInfoData;
        studentInfo = studentInfoData;
    }

    public SummaryInfo() {

    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }
}
