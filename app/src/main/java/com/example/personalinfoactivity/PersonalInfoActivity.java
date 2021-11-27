package com.example.personalinfoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.personalinfoactivity.models.PersonalInfo;
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
        TextInputEditText surnameObj = findViewById(R.id.inptSurname);
        EditText birthObj = findViewById(R.id.inptBirth);
        String name = nameObj.getText().toString();
        String surname = surnameObj.getText().toString();
        String birth = birthObj.getText().toString();

        PersonalInfo data = new PersonalInfo(name,surname,birth);

        Intent i = new Intent(this, StudentInfoActivity.class);
        i.putExtra("userInfo", data);
        startActivity(i);

    }


}