package com.example.personalinfoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.personalinfoactivity.models.CourseInfo;
import com.example.personalinfoactivity.models.StudentInfo;
import com.google.android.material.textfield.TextInputEditText;

public class StudentInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
    }

    public void ShowDetails(View view)
    {
        Intent iData = getIntent();
        StudentInfo userInfo = (StudentInfo) iData.getSerializableExtra("userInfo");


        TextInputEditText teacherNameObj = findViewById(R.id.inptTeacherName);
        String teacherName = teacherNameObj.getText().toString();
        TextInputEditText teacherSurnameObj = findViewById(R.id.inptTxt2);
        String teacherSurname = teacherSurnameObj.getText().toString();

        TextInputEditText courseTitleObj = findViewById(R.id.inptCourseTitle);
        String courseTitle = courseTitleObj.getText().toString();
        TextInputEditText courseYearObj = findViewById(R.id.inptCourseYear);
        String courseYear = courseYearObj.getText().toString();
        TextInputEditText courseHoursObj = findViewById(R.id.inptCourseHours);
        String courseHours = courseHoursObj.getText().toString();
        TextInputEditText courseHoursLVObj = findViewById(R.id.inptCourseHoursLV);
        String courseHoursLV = courseHoursLVObj.getText().toString();


        CourseInfo courseInfo = new CourseInfo(teacherName, teacherSurname,courseTitle,
                                    courseYear, courseHours, courseHoursLV);

        Intent i = new Intent(this, SummaryActivity.class);
        i.putExtra("userInfo", userInfo);
        i.putExtra("courseInfo", courseInfo);
        startActivity(i);
    }
}