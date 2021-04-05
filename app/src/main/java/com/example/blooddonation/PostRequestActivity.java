package com.example.blooddonation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.blooddonation.model.BloodRequest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostRequestActivity extends AppCompatActivity {

    private TextInputLayout areaCityTIL, bloodGroupTIL, relationshipTIL;
    private String area, bloodGroup, relationship,requestStatus,currentUserId;
    private TextView scheduleTV;
    private CheckBox urgentCheckbox;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_request);

        init();
    }

    public boolean validateArea(){
        area = areaCityTIL.getEditText().getText().toString();
        if(area.isEmpty()){
            Toast.makeText(this, "Write the blood needed area name.", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }
    }

    public boolean validateBloodGroup(){
        bloodGroup = bloodGroupTIL.getEditText().getText().toString();
        if(bloodGroup.isEmpty()){
            Toast.makeText(this, "Which group of blood is needed?", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }
    }

    public boolean validateRelationship(){
        relationship = relationshipTIL.getEditText().getText().toString();
        if(relationship.isEmpty()){
            Toast.makeText(this, "Write the blood needed area name.", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }

    }

    private void init() {
        areaCityTIL = findViewById(R.id.area_city_text_input_layout);
        bloodGroupTIL = findViewById(R.id.blood_group_text_input_layout);
        relationshipTIL = findViewById(R.id.relationship_text_input_layout);
        scheduleTV = findViewById(R.id.tv_schedule);
        scheduleTV.setPaintFlags(scheduleTV.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        urgentCheckbox = findViewById(R.id.urgent_checkbox);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void publichRequest(View view) {
        if(!validateArea() || !validateBloodGroup() || !validateRelationship()){
            return;
        }
        else
        {
            currentUserId = firebaseAuth.getCurrentUser().getUid();
            area = areaCityTIL.getEditText().getText().toString();
            bloodGroup = bloodGroupTIL.getEditText().getText().toString();
            relationship = relationshipTIL.getEditText().getText().toString();

            if(urgentCheckbox.isChecked()){
                requestStatus = "Emergency";
            }
            else
            {
                requestStatus = "Scheduled";
            }

            publishRequest(area,bloodGroup,relationship,requestStatus,currentUserId);
        }
    }

    private void publishRequest(String area, String bloodGroup, String relationship, String requestStatus, String currentUserId) {

        DatabaseReference bloodReqRef = databaseReference.child("blood_requests");
        DatabaseReference userBloodReqRef = databaseReference.child("users").child(currentUserId).child("my_blood_requests");
        bloodReqRef.push().setValue(new BloodRequest(area,bloodGroup,relationship,requestStatus,currentUserId))
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            userBloodReqRef.push().setValue(new BloodRequest(area,bloodGroup,relationship,requestStatus,currentUserId))
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                startActivity(new Intent(PostRequestActivity.this, MyRequestActivity.class));
                                            }
                                        }
                                    });
                        }
                    }
                });
    }
}