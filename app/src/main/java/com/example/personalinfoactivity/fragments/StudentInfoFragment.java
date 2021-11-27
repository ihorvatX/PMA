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
import android.widget.EditText;

import com.example.personalinfoactivity.R;
import com.example.personalinfoactivity.interfaces.StudentInfoListener;
import com.example.personalinfoactivity.models.PersonalInfo;
import com.example.personalinfoactivity.models.StudentInfo;
import com.google.android.material.textfield.TextInputEditText;

public class StudentInfoFragment extends Fragment {
    public StudentInfoListener handleStudentInfo;

    private EditText teacherNameObj;
    private EditText teacherSurnameObj;
    private EditText courseTitleObj;
    private EditText courseYearObj;
    private EditText courseHoursObj;
    private EditText courseHoursLVObj;


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


         teacherNameObj = view.findViewById(R.id.inptTeacherName);
         teacherSurnameObj = view.findViewById(R.id.inptTxt2);
         courseTitleObj = view.findViewById(R.id.inptCourseTitle);
         courseYearObj = view.findViewById(R.id.inptCourseYear);
         courseHoursObj = view.findViewById(R.id.inptCourseHours);
         courseHoursLVObj = view.findViewById(R.id.inptCourseHoursLV);


        teacherNameObj.addTextChangedListener(studentInfoWatcher);
        teacherSurnameObj.addTextChangedListener(studentInfoWatcher);
        courseTitleObj.addTextChangedListener(studentInfoWatcher);
        courseYearObj.addTextChangedListener(studentInfoWatcher);
        courseHoursObj.addTextChangedListener(studentInfoWatcher);
        courseHoursLVObj.addTextChangedListener(studentInfoWatcher);
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
            String teacherName = teacherNameObj.getText().toString();
            String teacherSurname = teacherSurnameObj.getText().toString();
            String courseTitle = courseTitleObj.getText().toString();
            String courseYear = courseYearObj.getText().toString();
            String courseHours = courseHoursObj.getText().toString();
            String courseHoursLV = courseHoursLVObj.getText().toString();

            handleStudentInfo.setStudentInfo(new StudentInfo(teacherName, teacherSurname,courseTitle,
                    courseYear, courseHours, courseHoursLV));
        }

    };

}