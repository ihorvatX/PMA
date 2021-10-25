package com.example.personalinfoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent iData = getIntent();

        String naziv = iData.getStringExtra("Naziv");
        String predmet = iData.getStringExtra("Predmet");

        TextView nazivTV = findViewById(R.id.textViewNaziv);
        TextView predmetTV = findViewById(R.id.textViewPredmet);
        nazivTV.setText(naziv);
        predmetTV.setText(predmet);
    }


    public void ShowHomepage(View view)
    {


        Intent i = new Intent(this, PersonalInfoActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        startActivity(i);
    }

}