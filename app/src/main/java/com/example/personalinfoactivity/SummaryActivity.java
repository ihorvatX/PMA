package com.example.personalinfoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.personalinfoactivity.models.CourseInfo;
import com.example.personalinfoactivity.models.StudentInfo;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent iData = getIntent();

        StudentInfo userInfo = (StudentInfo) iData.getSerializableExtra("userInfo");
        CourseInfo courseInfo = (CourseInfo) iData.getSerializableExtra("courseInfo");

        TextView studentName = findViewById(R.id.studentName);
        TextView studentSurname = findViewById(R.id.studentSurname);
        TextView studentBirth = findViewById(R.id.studentBirth);
        TextView teacherName = findViewById(R.id.teacherName);
        TextView teacherSurname = findViewById(R.id.teacherSurname);
        TextView courseTitle = findViewById(R.id.courseTitleInfo);
        TextView courseYear = findViewById(R.id.courseYearInfo);
        TextView courseHours = findViewById(R.id.courseHours);
        TextView courseHoursLV = findViewById(R.id.courseHoursLV);


        studentName.setText(userInfo.Name);
        studentSurname.setText(userInfo.Surname);
        studentBirth.setText(userInfo.Birth);

        teacherName.setText(courseInfo.TeacherName);
        teacherSurname.setText(courseInfo.TeacherSurname);
        courseTitle.setText(courseInfo.Course);
        courseYear.setText(courseInfo.CourseYear);
        courseHours.setText(courseInfo.CourseHours);
        courseHoursLV.setText(courseInfo.CourseHoursLV);

    }


    public void ShowHomepage(View view)
    {
        Intent i = new Intent(this, PersonalInfoActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        startActivity(i);
    }

}