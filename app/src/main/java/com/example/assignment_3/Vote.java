package com.example.assignment_3;

import java.io.Serializable;

public class Vote implements Serializable {
    private String id;

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    private String candidateName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
