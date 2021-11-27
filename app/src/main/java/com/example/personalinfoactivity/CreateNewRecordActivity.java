package com.example.personalinfoactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.personalinfoactivity.adapter.ViewPagerAdapter;

public class CreateNewRecordActivity extends AppCompatActivity {

   private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_record);

        viewPager = findViewById(R.id.fragment_container);
        viewPager.setAdapter(new ViewPagerAdapter(this));
    }

    public void jumpToPage(View view) {
        viewPager.setCurrentItem(viewPager.getCurrentItem() +1, true);

    }
}