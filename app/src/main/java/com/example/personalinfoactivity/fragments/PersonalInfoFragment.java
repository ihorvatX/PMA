package com.example.personalinfoactivity.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraX;
import androidx.camera.core.ImageCapture;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.personalinfoactivity.R;
import com.example.personalinfoactivity.interfaces.PersonalInfoListener;
import com.example.personalinfoactivity.models.PersonalInfo;
import com.google.common.util.concurrent.ListenableFuture;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;


public class PersonalInfoFragment extends Fragment {

    public PersonalInfoListener handlePersonalInfo;

    ActivityResultLauncher<Intent> someActivityResultLauncher;

    EditText nameObj;
    EditText surnameObj;
    EditText birthObj;

    String firstName, lastName, birthDate, currentPhotoPath;;

    PreviewView imageObj;



    PreviewView mPreviewView;


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

        someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK && result.getData() !=null) {
                            Bundle bundle = result.getData().getExtras();
                            Bitmap imageBitmap = (Bitmap) bundle.get("data");

                            Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                            File f = new File(currentPhotoPath);
                            Uri contentUri = Uri.fromFile(f);
                            mediaScanIntent.setData(contentUri);
                            getActivity().sendBroadcast(mediaScanIntent);

//                            imageObj.setImageBitmap(imageBitmap);

                        }
                    }
                });

//        imageObj.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                if(takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null)
//                {
//
//                    File photoFile = null;
//                    try {
//                        photoFile = handlePersonalInfo.createImageFile();
//                    } catch (IOException ioExceptio) {
//                        ioExceptio.printStackTrace();
//                    }
//                    // Continue only if the File was successfully created
//                    if (photoFile != null) {
//                        Uri photoURI = FileProvider.getUriForFile(getActivity().getBaseContext(),
//                                "com.example.android.fileprovider",
//                                photoFile);
//                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
//                        someActivityResultLauncher.launch(takePictureIntent);
//                    }
//
//                }
//            }
//        });
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

            handlePersonalInfo.setName(new PersonalInfo(firstName,lastName,birthDate));
        }

    };



}