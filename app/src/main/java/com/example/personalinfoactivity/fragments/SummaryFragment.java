package com.example.personalinfoactivity.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.personalinfoactivity.HomeActivity;
import com.example.personalinfoactivity.R;
import com.example.personalinfoactivity.interfaces.SummaryListener;
import com.example.personalinfoactivity.models.StudentInfo;
import com.example.personalinfoactivity.models.Storage;
import com.example.personalinfoactivity.models.Student;
import com.example.personalinfoactivity.models.PersonalInfo;
import com.example.personalinfoactivity.models.SummaryInfo;
import com.example.personalinfoactivity.models.ViewPagerStorage;


public class SummaryFragment extends Fragment{

    public SummaryListener data;

    private TextView studentName;
    private TextView studentSurname;
    private TextView studentBirth;
    private TextView teacherName;
    private TextView teacherSurname;
    private TextView courseTitle;
    private TextView courseYear;
    private TextView courseHours;
    private TextView courseHoursLV;

    private String ime;
    private String prezime;
    private String predmet;


    public SummaryFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_summary, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        studentName = view.findViewById(R.id.studentName);
        studentSurname = view.findViewById(R.id.studentSurname);
        studentBirth = view.findViewById(R.id.studentBirth);
        teacherName = view.findViewById(R.id.teacherName);
        teacherSurname = view.findViewById(R.id.teacherSurname);
        courseTitle = view.findViewById(R.id.courseTitleInfo);
        courseYear = view.findViewById(R.id.courseYearInfo);
        courseHours = view.findViewById(R.id.courseHours);
        courseHoursLV = view.findViewById(R.id.courseHoursLV);

        Button showHomepage = view.findViewById(R.id.btnHomepage);

        showHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Student student = new Student(ime, prezime, predmet);
                Storage dataStorage = Storage.getInstance();
                dataStorage.setStudents(student);

                ViewPagerStorage viewPagerStorage = ViewPagerStorage.getInstance();
                viewPagerStorage.clearData();

                Intent i = new Intent(getActivity(), HomeActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);



                startActivity(i);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        if(data != null )
        {
            SummaryInfo summaryInfo = data.getSummary();

            if(summaryInfo != null)
            {
                if(summaryInfo.getPersonalInfo() != null)
                {
                    updatePersonalInfo(summaryInfo.getPersonalInfo());
                }
                if(summaryInfo.getStudentInfo() != null)
                {
                    updateStudentInfo(summaryInfo.getStudentInfo());
                }
            }
        }
    }

    public void updatePersonalInfo(PersonalInfo personalInfo)
    {
        ime = personalInfo.Name;
        prezime = personalInfo.Surname;

        studentName.setText(personalInfo.Name);
        studentSurname.setText(personalInfo.Surname);
        studentBirth.setText(personalInfo.Birth);
    }

    public void updateStudentInfo(StudentInfo studentInfo)
    {
        predmet = studentInfo.Course;

        this.teacherName.setText(studentInfo.TeacherName);
        this.teacherSurname.setText(studentInfo.TeacherSurname);
        this.courseTitle.setText(studentInfo.Course);
        this.courseYear.setText(studentInfo.CourseYear);
        this.courseHours.setText(studentInfo.CourseHours);
        this.courseHoursLV.setText(studentInfo.CourseHoursLV);
    }


}