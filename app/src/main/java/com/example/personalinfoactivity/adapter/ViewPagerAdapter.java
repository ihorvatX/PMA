package com.example.personalinfoactivity.adapter;

import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.personalinfoactivity.fragments.PersonalInfoFragment;
import com.example.personalinfoactivity.fragments.StudentInfoFragment;
import com.example.personalinfoactivity.fragments.SummaryFragment;
import com.example.personalinfoactivity.interfaces.PersonalInfoListener;
import com.example.personalinfoactivity.interfaces.StudentInfoListener;
import com.example.personalinfoactivity.interfaces.SummaryListener;
import com.example.personalinfoactivity.models.PersonalInfo;
import com.example.personalinfoactivity.models.Student;
import com.example.personalinfoactivity.models.StudentInfo;
import com.example.personalinfoactivity.models.SummaryInfo;
import com.example.personalinfoactivity.models.ViewPagerStorage;

public class ViewPagerAdapter  extends FragmentStateAdapter implements PersonalInfoListener, StudentInfoListener, SummaryListener {

    private final int NUM_FRAGMENTS = 3;

   public PersonalInfo personalData;
   public StudentInfo studentData;
   public Uri uriData;

   private ViewPagerStorage viewPagerStorage = ViewPagerStorage.getInstance();

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Fragment fragment = null;
        switch (position) {
            case 1:
                fragment = new StudentInfoFragment();
                ((StudentInfoFragment)fragment).handleStudentInfo = this;
                break;
            case 2:
                fragment = new SummaryFragment();
                ((SummaryFragment)fragment).data = this;
                break;
            default:
                fragment = new PersonalInfoFragment();
                ((PersonalInfoFragment)fragment).handlePersonalInfo = this;
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return NUM_FRAGMENTS;
    }

    @Override
    public void setPersonal(PersonalInfo personalInfo) {
        viewPagerStorage.setPersonalInfo(personalInfo);
    }

    @Override
    public PersonalInfo getPersonal() {
        return viewPagerStorage.getPerInfo();
    }

    @Override
    public Uri getUriPicture() {
        return uriData;
    }

    @Override
    public void setStudent(StudentInfo studentInfo) {
        viewPagerStorage.SetStudentInfo(studentInfo);
    }

    @Override
    public StudentInfo getStudent() {
        return viewPagerStorage.getStuInfo();
    }


    @Override
    public SummaryInfo getSummary() {
        return new SummaryInfo(viewPagerStorage.getPerInfo(), viewPagerStorage.getStuInfo());
    }
}
