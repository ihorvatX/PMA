package com.example.personalinfoactivity.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.personalinfoactivity.R;
import com.example.personalinfoactivity.apiModels.Course;
import com.example.personalinfoactivity.apiModels.Courses;
import com.example.personalinfoactivity.apiModels.Instructor;
import com.example.personalinfoactivity.interfaces.StudentInfoListener;
import com.example.personalinfoactivity.models.ApiManager;
import com.example.personalinfoactivity.models.StudentInfo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentInfoFragment extends Fragment implements Callback<Courses>, AdapterView.OnItemSelectedListener {
    public StudentInfoListener handleStudentInfo;

    private EditText teacherNameObj;
    private EditText teacherSurnameObj;
    private EditText courseTitleObj;
    private EditText courseYearObj;
    private EditText courseHoursObj;
    private EditText courseHoursLVObj;

    private  Spinner spinnerName;
    private  Spinner spinnerCourse;


    Courses courses = new Courses();

    String teacherName;
    String teacherSurname;
    String courseTitle;
    String courseYear;
    String courseHours;
    String courseHoursLV;
    List<String> coursesList;
    List<String> instructorsList;

    public StudentInfoFragment() {
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
        return inflater.inflate(R.layout.fragment_student_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


//         teacherNameObj = view.findViewById(R.id.inptTeacherName);
//         teacherSurnameObj = view.findViewById(R.id.inptTxt2);
//         courseTitleObj = view.findViewById(R.id.inptCourseTitle);
         courseYearObj = view.findViewById(R.id.inptCourseYear);
         courseHoursObj = view.findViewById(R.id.inptCourseHours);
         courseHoursLVObj = view.findViewById(R.id.inptCourseHoursLV);


//        teacherNameObj.addTextChangedListener(studentInfoWatcher);
//        teacherSurnameObj.addTextChangedListener(studentInfoWatcher);
//        courseTitleObj.addTextChangedListener(studentInfoWatcher);
        courseYearObj.addTextChangedListener(studentInfoWatcher);
        courseHoursObj.addTextChangedListener(studentInfoWatcher);
        courseHoursLVObj.addTextChangedListener(studentInfoWatcher);

        spinnerName =  view.findViewById(R.id.spinnerName);
        spinnerCourse =  view.findViewById(R.id.spinnerCourse);


        ApiManager.getInstance().service().getCourses().enqueue(this);
    }


    @Override
    public void onResume() {
        super.onResume();

        if(handleStudentInfo.getStudent() != null )
        {
            StudentInfo personalInfo = handleStudentInfo.getStudent();

            if(personalInfo != null)
            {
                updateStudentInfo(handleStudentInfo.getStudent());
            }
        }
    }

    private void updateStudentInfo(StudentInfo student) {
//        teacherNameObj.setText(student.TeacherName);
//        teacherSurnameObj.setText(student.TeacherSurname);
//        courseTitleObj.setText(student.Course);
        courseYearObj.setText(student.CourseYear);
        courseHoursObj.setText(student.CourseHours);
        courseHoursLVObj.setText(student.CourseHoursLV);
    }


    @Override
    public void onDetach() {
        super.onDetach();
        handleStudentInfo = null;
    }

    private final TextWatcher studentInfoWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence,int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable editable) {

            courseYear = courseYearObj.getText().toString();
            courseHours = courseHoursObj.getText().toString();
            courseHoursLV = courseHoursLVObj.getText().toString();

            handleStudentInfo.setStudent(new StudentInfo(teacherName, teacherSurname,courseTitle,
                    courseYear, courseHours, courseHoursLV));
        }

    };

    @Override
    public void onResponse(Call<Courses> call, Response<Courses> response) {
        if (response.isSuccessful() && response.body() != null){
            courses = response.body();
            coursesList = new ArrayList<>();
            instructorsList = new ArrayList<>();

            for ( Course course: courses.getCourses()) {
                if(!course.getTitle().equals(""))
                {
                    coursesList.add(course.getTitle());
                }


                if (course.getInstructors() != null)
                {
                for ( Instructor instructor: course.getInstructors()){
                    instructorsList.add(instructor.getName());
                }
                }
            }


            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,coursesList);
            ArrayAdapter<String> adapterInstuctor=new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,instructorsList);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapterInstuctor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinnerName.setOnItemSelectedListener(this);
            spinnerCourse.setOnItemSelectedListener(this);

            spinnerName.setAdapter(adapterInstuctor);
            spinnerCourse.setAdapter(adapter);
        }
    }

    @Override
    public void onFailure(Call<Courses> call, Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()) {
            case R.id.spinnerName:
                teacherName = instructorsList.get(i);

                handleStudentInfo.setStudent(new StudentInfo(teacherName, teacherSurname,courseTitle,
                        courseYear, courseHours, courseHoursLV));
                break;
            case R.id.spinnerCourse:

                courseTitle = coursesList.get(i);

                handleStudentInfo.setStudent(new StudentInfo(teacherName, teacherSurname,courseTitle,
                        courseYear, courseHours, courseHoursLV));
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}