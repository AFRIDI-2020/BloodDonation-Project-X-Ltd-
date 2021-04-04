package com.example.blooddonation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignUp8Activity extends AppCompatActivity {

    private CircleImageView profileImage;
    private int STORAGE_PERMISSION_CODE = 1;

    private String username, email, password, phoneNo, altPhoneNo, social, bloodGroup, weight, gender,
            street,city, postalCode, age, birthDate, profileImageLink = "";
    private StorageReference storageReference;
    private FirebaseAuth firebaseAuth;
    private AlertDialog registerWaitingDialog, uploadingDialog;
    private Uri resultUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up8);

        username = getIntent().getStringExtra("username");
        email = getIntent().getStringExtra("email");
        password = getIntent().getStringExtra("password");
        phoneNo = getIntent().getStringExtra("phoneNo");
        altPhoneNo = getIntent().getStringExtra("altPhoneNo");
        social = getIntent().getStringExtra("social");
        bloodGroup = getIntent().getStringExtra("bloodGroup");
        weight = getIntent().getStringExtra("weight");
        gender = getIntent().getStringExtra("gender");
        street = getIntent().getStringExtra("street");
        city = getIntent().getStringExtra("city");
        postalCode = getIntent().getStringExtra("postalCode");
        age = getIntent().getStringExtra("age");
        birthDate = getIntent().getStringExtra("birthDate");

        init();

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(SignUp8Activity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    CropImage.activity()
                            .setGuidelines(CropImageView.Guidelines.ON)
                            .setAspectRatio(1, 1)
                            .start(SignUp8Activity.this);
                } else {
                    requestStoragePermission();
                }
            }
        });


    }

    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {

            new AlertDialog.Builder(this)
                    .setTitle("Permission needed!")
                    .setMessage("Permission is needed to access storage")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            ActivityCompat.requestPermissions(SignUp8Activity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.dismiss();
                        }
                    }).create().show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                startUploadingDialog();
                resultUri = result.getUri();
                saveToCloudStorage(resultUri);
            }
        }
    }

    private void saveToCloudStorage(Uri resultUri) {
        StorageReference profileImgRef = FirebaseStorage.getInstance().getReference().child("profileImages").child(username + birthDate + ".jpg");
        UploadTask uploadTask = profileImgRef.putFile(resultUri);

        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                        if (!task.isSuccessful()) {
                            throw task.getException();
                        }
                        return profileImgRef.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()) {
                            Uri downloadUri = task.getResult();
                            profileImageLink = downloadUri.toString();
                            uploadingDialog.dismiss();
                        }
                    }
                });
            }
        });
    }








    private void init() {
        profileImage = findViewById(R.id.profile_image);
        storageReference = FirebaseStorage.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void goToHomePage(View view) {

        if(profileImageLink.equals("")){
            Toast.makeText(this, "Please upload a photo.", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            startRegisterWaitingDialog();
            registerUser(email, password);
        }

    }

    private void registerUser(String email, String password) {

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    saveUserInfoToDatabase(username,email,phoneNo, altPhoneNo,social,bloodGroup,weight,gender,street, city, postalCode,age, birthDate, profileImageLink);

                }
            }
        });
    }

    private void saveUserInfoToDatabase(String username, String email, String phoneNo, String altPhoneNo, String social, String bloodGroup, String weight, String gender, String street, String city, String postalCode, String age, String birthDate, String profileImageLink) {

        String currentUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("users").child(currentUserId).child("basic_info")
                .setValue(new User(username,email,phoneNo,altPhoneNo,social,bloodGroup,weight,gender,street,city, postalCode, age,birthDate,profileImageLink ))
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            registerWaitingDialog.dismiss();
                            Toast.makeText(SignUp8Activity.this, "registered!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUp8Activity.this, HomeActivity.class));
                        }
                    }
                });
    }


    private void startRegisterWaitingDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SignUp8Activity.this);
        View view = getLayoutInflater().inflate(R.layout.register_waiting_dialog, null);
        builder.setView(view);
        builder.setCancelable(false);
        registerWaitingDialog = builder.create();
        registerWaitingDialog.show();
    }


    private void startUploadingDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SignUp8Activity.this);
        View view = getLayoutInflater().inflate(R.layout.uploading_dailog_layout, null);
        builder.setView(view);
        builder.setCancelable(false);
        uploadingDialog = builder.create();
        uploadingDialog.show();
    }
}