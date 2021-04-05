package com.example.blooddonation.model;

public class BloodRequest {

    private String area;
    private String bloodGroup;
    private String relationshipWithPatient;
    private String bloodReqStatus;
    private String userId;

    public BloodRequest() {
    }

    public BloodRequest(String area, String bloodGroup, String relationshipWithPatient, String bloodReqStatus, String userId) {
        this.area = area;
        this.bloodGroup = bloodGroup;
        this.relationshipWithPatient = relationshipWithPatient;
        this.bloodReqStatus = bloodReqStatus;
        this.userId = userId;
    }

    public String getArea() {
        return area;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getRelationshipWithPatient() {
        return relationshipWithPatient;
    }

    public String getBloodReqStatus() {
        return bloodReqStatus;
    }

    public String getUserId() {
        return userId;
    }
}
