package com.example.personalinfoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class StudentInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
    }

    public void ShowInfo(View view)
    {
        Intent iData = getIntent();

        String naziv = iData.getStringExtra("Naziv");


        TextInputEditText inptPredmet = findViewById(R.id.inptPredmet);
        String predmet = inptPredmet.getText().toString();


        Intent i = new Intent(this, SummaryActivity.class);
        i.putExtra("Naziv", naziv);
        i.putExtra("Predmet", predmet);
        startActivity(i);
    }
}