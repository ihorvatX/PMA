package com.example.personalinfoactivity.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.personalinfoactivity.CameraActivity;
import com.example.personalinfoactivity.R;
import com.example.personalinfoactivity.interfaces.PersonalInfoListener;
import com.example.personalinfoactivity.models.PersonalInfo;
import com.example.personalinfoactivity.models.SummaryInfo;


public class PersonalInfoFragment extends Fragment {

    public PersonalInfoListener handlePersonalInfo;


    EditText nameObj;
    EditText surnameObj;
    EditText birthObj;

    String firstName, lastName, birthDate;

    ImageView imageObj;


    public PersonalInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personal_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        nameObj = view.findViewById(R.id.inptName);
        surnameObj = view.findViewById(R.id.inptSurname);
        birthObj = view.findViewById(R.id.inptBirth);
        imageObj = view.findViewById(R.id.Avatar);


        nameObj.addTextChangedListener(personalInfoWatcher);
        surnameObj.addTextChangedListener(personalInfoWatcher);
        birthObj.addTextChangedListener(personalInfoWatcher);

        imageObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), CameraActivity.class);
                startActivity(i);
            }
        });

        Uri pictureUri = handlePersonalInfo.getUriPicture();
        if(pictureUri != null)
        {
            imageObj.setImageURI(pictureUri);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if(handlePersonalInfo.getPersonal() != null )
        {
            PersonalInfo personalInfo = handlePersonalInfo.getPersonal();

            if(personalInfo != null)
            {
                updatePersonalInfo(handlePersonalInfo.getPersonal());
            }
        }
    }

    private void updatePersonalInfo(PersonalInfo personal) {
        nameObj.setText(personal.Name);
        surnameObj.setText(personal.Surname);
        birthObj.setText(personal.Birth);
    }


    @Override
    public void onDetach() {
        super.onDetach();
        handlePersonalInfo = null;
    }


    private final TextWatcher personalInfoWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence,int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable editable) {
            firstName = nameObj.getText().toString();
            lastName = surnameObj.getText().toString();
            birthDate = birthObj.getText().toString();

            handlePersonalInfo.setPersonal(new PersonalInfo(firstName,lastName,birthDate));
        }

    };



}