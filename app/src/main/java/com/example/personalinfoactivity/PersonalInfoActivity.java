package com.example.personalinfoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class PersonalInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
    }


    public void StudentInfo(View view)
    {
        TextInputEditText inptTextObj = findViewById(R.id.inptTxt);
        String naziv = inptTextObj.getText().toString();


        Intent i = new Intent(this, StudentInfoActivity.class);
        i.putExtra("Naziv", naziv);
        startActivity(i);

    }

}