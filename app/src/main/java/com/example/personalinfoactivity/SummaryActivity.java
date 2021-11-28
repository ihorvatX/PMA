package com.example.personalinfoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.personalinfoactivity.models.StudentInfo;
import com.example.personalinfoactivity.models.Storage;
import com.example.personalinfoactivity.models.Student;
import com.example.personalinfoactivity.models.PersonalInfo;
import com.example.personalinfoactivity.models.ViewPagerStorage;

public class SummaryActivity extends AppCompatActivity {

    private String ime;
    private String prezime;
    private String predmet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent iData = getIntent();

        PersonalInfo userInfo = (PersonalInfo) iData.getSerializableExtra("userInfo");
        StudentInfo studentInfo = (StudentInfo) iData.getSerializableExtra("courseInfo");

        TextView studentName = findViewById(R.id.studentName);
        TextView studentSurname = findViewById(R.id.studentSurname);
        TextView studentBirth = findViewById(R.id.studentBirth);
        TextView teacherName = findViewById(R.id.teacherName);
        TextView teacherSurname = findViewById(R.id.teacherSurname);
        TextView courseTitle = findViewById(R.id.courseTitleInfo);
        TextView courseYear = findViewById(R.id.courseYearInfo);
        TextView courseHours = findViewById(R.id.courseHours);
        TextView courseHoursLV = findViewById(R.id.courseHoursLV);

        ime = userInfo.Name;
        predmet = studentInfo.Course;
        prezime = userInfo.Surname;

        studentName.setText(userInfo.Name);
        studentSurname.setText(userInfo.Surname);
        studentBirth.setText(userInfo.Birth);

        teacherName.setText(studentInfo.TeacherName);
        teacherSurname.setText(studentInfo.TeacherSurname);
        courseTitle.setText(studentInfo.Course);
        courseYear.setText(studentInfo.CourseYear);
        courseHours.setText(studentInfo.CourseHours);
        courseHoursLV.setText(studentInfo.CourseHoursLV);
    }


    public void ShowHomepage(View view)
    {
        Student student = new Student(ime, prezime, predmet);
        Storage spremnik = Storage.getInstance();
        spremnik.setStudents(student);

        ViewPagerStorage viewPagerStorage = ViewPagerStorage.getInstance();
        viewPagerStorage.clearData();

        Intent i = new Intent(this, HomeActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        startActivity(i);
    }

}