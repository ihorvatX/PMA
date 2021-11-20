package com.example.personalinfoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.personalinfoactivity.models.StudentInfo;
import com.google.android.material.textfield.TextInputEditText;

public class PersonalInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
    }

    public void CourseInfo(View view)
    {
        TextInputEditText nameObj = findViewById(R.id.inptName);
        String name = nameObj.getText().toString();
        TextInputEditText surnameObj = findViewById(R.id.inptSurname);
        String surname = surnameObj.getText().toString();
        EditText birthObj = findViewById(R.id.inptBirth);
        String birth = birthObj.getText().toString();

        StudentInfo data = new StudentInfo(name,surname,birth);

        Intent i = new Intent(this, StudentInfoActivity.class);
        i.putExtra("userInfo", data);
        startActivity(i);

    }


}