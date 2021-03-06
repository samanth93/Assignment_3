package com.example.assignment_3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Activity2 extends AppCompatActivity{
    Spinner sp;
    EditText name;
    EditText id;
    ToggleButton toggleButton;
    Button voteBtn;
    List<Vote> voteList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Main ID",""+voteList.size()+"");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        sp = findViewById(R.id.sp_a_two_one);
        name = findViewById(R.id.pt_a_two_one);
        id = findViewById(R.id.pt_a_two_two);
        voteBtn = findViewById(R.id.b_a_two_one);
        toggleButton = findViewById(R.id.tb_a_two_one);
        toggleButton.setOnClickListener((v)->{
            toggleButton.setError(null);
        });
        voteBtn.setOnClickListener((v)->{
            boolean valid = true;
//            for(int i=0;i<voteList.size();i++){
//                Log.d("Main ID",""+voteList.get(i).getId()+"");
////                if (voteList.get(i).getId().equals(id.getText().toString())) {
////
////                }
//            }
            name.setError("at least 3 characters");
            if (name.getText().toString().length() == 0) {
                name.setError("Cannot be empty");
                valid = false;
            } else {
                name.setError(null);
            }
            if (id.getText().toString().length() == 0) {
                id.setError("Cannot be empty");
                valid = false;
            } else {
                id.setError(null);
            }
            if (toggleButton.getText().toString().equals("ACCEPT")) {
                toggleButton.setError("Please Accept");
                valid = false;
            } else {
                toggleButton.setError(null);
            }
            if (sp.getSelectedItem().toString().equals("choose candidate")) {
                ((TextView)sp.getSelectedView()).setError("Please select one");
                valid = false;
            } else {
                ((TextView)sp.getSelectedView()).setError(null);
            }
            if(valid){
                Vote userVote = new Vote();
                userVote.setName(name.getText().toString());
                userVote.setId(id.getText().toString());
                userVote.setCandidateName(sp.getSelectedItem().toString());
//                Log.d("Main Resume",""+voteList.add(userVote)+"");
                Intent resultIntent = new Intent();
                resultIntent.putExtra("userVote", userVote);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }else{
                Log.d("Main Resume", "Validation");
            }
        });
    }
}