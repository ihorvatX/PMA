package com.example.personalinfoactivity.adapter;

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

public class ViewPagerAdapter  extends FragmentStateAdapter implements PersonalInfoListener, StudentInfoListener, SummaryListener {

    private final int NUM_FRAGMENTS = 3;

   public PersonalInfo personalData;
   public StudentInfo studentData;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new PersonalInfoFragment();
                ((PersonalInfoFragment)fragment).handlePersonalInfo = this;
                break;
            case 1:
                fragment = new StudentInfoFragment();
                ((StudentInfoFragment)fragment).handleStudentInfo = this;
                break;
            case 2:
                fragment = new SummaryFragment();
                ((SummaryFragment)fragment).data = this;
                break;
            default:
                return null;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return NUM_FRAGMENTS;
    }


    @Override
    public void setName(PersonalInfo personalInfo) {
        personalData = personalInfo;
    }

    @Override
    public void setStudentInfo(StudentInfo studentInfo) {
        studentData = studentInfo;
    }

    @Override
    public SummaryInfo getSummary() {
        return new SummaryInfo(personalData,studentData);
    }
}
