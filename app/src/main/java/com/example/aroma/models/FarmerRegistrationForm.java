package com.example.aroma.models;

import java.util.ArrayList;

public class FarmerRegistrationForm {
    String name, fName, phoneNumber, email, adhaarNo, dateOfBirth, familyCount,address;
    String totalLandArea,totalAnnualIncomeAgr, AnnualIncomeAro,durationMAPsCul,acMaxProfit;
    String reqSlips, reqKgs,recSlips,recKgs;

    boolean gender,maritalStatus, eleAvailable,doUWantAgroAdv,sellEssOils,declariation;
    String edecation,occupation,category, state;

    ArrayList<String> farmMachinery = new ArrayList<>();
    ArrayList<String> fieldCondition = new ArrayList<>();
    ArrayList<String> irrigationFacility = new ArrayList<>();
    ArrayList<String> wantCulAc = new ArrayList<>();
    ArrayList<String> cultAc = new ArrayList<>();
    ArrayList<String> CsirIiimThrough = new ArrayList<>();







    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdhaarNo() {
        return adhaarNo;
    }

    public void setAdhaarNo(String adhaarNo) {
        this.adhaarNo = adhaarNo;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFamilyCount() {
        return familyCount;
    }

    public void setFamilyCount(String familyCount) {
        this.familyCount = familyCount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTotalLandArea() {
        return totalLandArea;
    }

    public void setTotalLandArea(String totalLandArea) {
        this.totalLandArea = totalLandArea;
    }

    public String getTotalAnnualIncomeAgr() {
        return totalAnnualIncomeAgr;
    }

    public void setTotalAnnualIncomeAgr(String totalAnnualIncomeAgr) {
        this.totalAnnualIncomeAgr = totalAnnualIncomeAgr;
    }

    public String getAnnualIncomeAro() {
        return AnnualIncomeAro;
    }

    public void setAnnualIncomeAro(String annualIncomeAro) {
        AnnualIncomeAro = annualIncomeAro;
    }

    public String getDurationMAPsCul() {
        return durationMAPsCul;
    }

    public void setDurationMAPsCul(String durationMAPsCul) {
        this.durationMAPsCul = durationMAPsCul;
    }

    public String getAcMaxProfit() {
        return acMaxProfit;
    }

    public void setAcMaxProfit(String acMaxProfit) {
        this.acMaxProfit = acMaxProfit;
    }

    public String getReqSlips() {
        return reqSlips;
    }

    public void setReqSlips(String reqSlips) {
        this.reqSlips = reqSlips;
    }

    public String getReqKgs() {
        return reqKgs;
    }

    public void setReqKgs(String reqKgs) {
        this.reqKgs = reqKgs;
    }

    public String getRecSlips() {
        return recSlips;
    }

    public void setRecSlips(String recSlips) {
        this.recSlips = recSlips;
    }

    public String getRecKgs() {
        return recKgs;
    }

    public void setRecKgs(String recKgs) {
        this.recKgs = recKgs;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean isMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(boolean maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public boolean isEleAvailable() {
        return eleAvailable;
    }

    public void setEleAvailable(boolean eleAvailable) {
        this.eleAvailable = eleAvailable;
    }

    public boolean isDoUWantAgroAdv() {
        return doUWantAgroAdv;
    }

    public void setDoUWantAgroAdv(boolean doUWantAgroAdv) {
        this.doUWantAgroAdv = doUWantAgroAdv;
    }

    public boolean isSellEssOils() {
        return sellEssOils;
    }

    public void setSellEssOils(boolean sellEssOils) {
        this.sellEssOils = sellEssOils;
    }

    public boolean isDeclariation() {
        return declariation;
    }

    public void setDeclariation(boolean declariation) {
        this.declariation = declariation;
    }

    public String getEdecation() {
        return edecation;
    }

    public void setEdecation(String edecation) {
        this.edecation = edecation;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ArrayList<String> getFarmMachinery() {
        return farmMachinery;
    }

    public void setFarmMachinery(ArrayList<String> farmMachinery) {
        this.farmMachinery = farmMachinery;
    }

    public ArrayList<String> getFieldCondition() {
        return fieldCondition;
    }

    public void setFieldCondition(ArrayList<String> fieldCondition) {
        this.fieldCondition = fieldCondition;
    }

    public ArrayList<String> getIrrigationFacility() {
        return irrigationFacility;
    }

    public void setIrrigationFacility(ArrayList<String> irrigationFacility) {
        this.irrigationFacility = irrigationFacility;
    }

    public ArrayList<String> getWantCulAc() {
        return wantCulAc;
    }

    public void setWantCulAc(ArrayList<String> wantCulAc) {
        this.wantCulAc = wantCulAc;
    }

    public ArrayList<String> getCultAc() {
        return cultAc;
    }

    public void setCultAc(ArrayList<String> cultAc) {


        this.cultAc = cultAc;
    }

    public ArrayList<String> getCsirIiimThrough() {
        return CsirIiimThrough;
    }

    public void setCsirIiimThrough(ArrayList<String> csirIiimThrough) {
        CsirIiimThrough = csirIiimThrough;
    }


}
