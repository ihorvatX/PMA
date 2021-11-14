package com.example.personalinfoactivity.models;

import java.io.Serializable;

public class CourseInfo implements Serializable {

    public String TeacherName;
    public String TeacherSurname;
    public String Course;
    public String CourseYear;
    public String CourseHours;
    public String CourseHoursLV;

    public CourseInfo(String teacherName, String teacherSurname, String course, String courseYear,
                      String courseHours, String courseHoursLV)
    {
        this.TeacherName = teacherName;
        this.TeacherSurname = teacherSurname;
        this.Course = course;
        this.CourseYear = courseYear;
        this.CourseHours = courseHours;
        this.CourseHoursLV = courseHoursLV;
    }

}
