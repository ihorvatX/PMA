package com.example.personalinfoactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.personalinfoactivity.adapter.ViewPagerAdapter;

public class CreateNewRecordActivity extends AppCompatActivity {

   private ViewPager2 viewPager;
   public Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_record);

        Intent iData = getIntent();
        if(iData.getExtras() != null)
        {
            uri = iData.getParcelableExtra("photoPathUri");
        }

        ViewPagerAdapter  viewPagerAdapter = new ViewPagerAdapter(this);
        viewPagerAdapter.uriData = uri;

        viewPager = findViewById(R.id.fragment_container);
        viewPager.setAdapter(viewPagerAdapter);
    }

    public void jumpToPage(View view) {
        viewPager.setCurrentItem(viewPager.getCurrentItem() +1, true);
    }
}