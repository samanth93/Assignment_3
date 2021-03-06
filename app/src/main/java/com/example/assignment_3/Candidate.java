package com.example.assignment_3;

import java.io.Serializable;

public class Candidate implements Serializable {
    public String getCanName() {
        return canName;
    }

    public void setCanName(String canName) {
        this.canName = canName;
    }

    private String canName;

    public int getNumOfVotes() {
        return numOfVotes;
    }

    public void setNumOfVotes(int numOfVotes) {
        this.numOfVotes = numOfVotes;
    }

    private int numOfVotes;
}
