package com.example.personalinfoactivity.interfaces;

import android.net.Uri;

import com.example.personalinfoactivity.models.PersonalInfo;

public interface PersonalInfoListener {
    void setPersonal(PersonalInfo personalInfo);
    PersonalInfo getPersonal();
    Uri getUriPicture();
}
