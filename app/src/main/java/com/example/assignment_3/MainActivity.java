package com.example.assignment_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView candidateOne;
    TextView candidateTwo;
    TextView candidateThree;
    Candidate canOne = new Candidate();
    Candidate canTwo = new Candidate();
    Candidate canThree = new Candidate();
    List<Candidate> canList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        canOne.setCanName("1");
        canTwo.setCanName("2");
        canThree.setCanName("3");
        canList.add(canOne);
        canList.add(canTwo);
        canList.add(canThree);
        candidateOne = findViewById(R.id.tv_a_main_one);
        candidateTwo = findViewById(R.id.tv_a_main_two);
        candidateThree = findViewById(R.id.tv_a_main_three);
        candidateOne.setText("Candidate "+canList.get(0).getCanName()+": "+canList.get(0).getNumOfVotes());
        candidateTwo.setText("Candidate "+canList.get(1).getCanName()+": "+canList.get(1).getNumOfVotes());
        candidateThree.setText("Candidate "+canList.get(2).getCanName()+": "+canList.get(2).getNumOfVotes());
        btn = findViewById(R.id.b_a_main_one);
        btn.setOnClickListener((v)->{
            Intent intent = new Intent(MainActivity.this, Activity2.class);
            startActivityForResult(intent, 1);
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (1) : {
                if (resultCode == Activity.RESULT_OK) {
                    Vote newvote = (Vote) data.getSerializableExtra("userVote");
//                    Log.d("Main Resume", newvote.getName());
//                    Log.d("Main Resume", newvote.getId());
//                    Log.d("Main Resume", newvote.getCandidateName());
                    if(newvote.getCandidateName().equals("candidate 1")){
                        canList.get(0).setNumOfVotes(canList.get(0).getNumOfVotes()+1);
                    }else if(newvote.getCandidateName().equals("candidate 2")){
                        canList.get(1).setNumOfVotes(canList.get(1).getNumOfVotes()+1);
                    }else if(newvote.getCandidateName().equals("candidate 3")){
                        canList.get(2).setNumOfVotes(canList.get(2).getNumOfVotes()+1);
                    }else{

                    }
                    candidateOne.setText("Candidate "+canList.get(0).getCanName()+": "+canList.get(0).getNumOfVotes());
                    candidateTwo.setText("Candidate "+canList.get(1).getCanName()+": "+canList.get(1).getNumOfVotes());
                    candidateThree.setText("Candidate "+canList.get(2).getCanName()+": "+canList.get(2).getNumOfVotes());
                }
                break;
            }
        }
    }
}