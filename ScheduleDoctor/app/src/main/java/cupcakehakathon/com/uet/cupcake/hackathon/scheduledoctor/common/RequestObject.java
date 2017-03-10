package cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.common;

import java.io.Serializable;

/**
 * Created by Luong Tran on 3/10/2017.
 */

public class RequestObject
    implements Serializable {
    private int id;
    private String symptom;
    private String requestTime;
    private String name;
    private String birthday;
    private String gender;
    private String identityNumber;
    private String insuranceCode;
    private String address;
    private String dayTarget;

    public RequestObject(int id,
                         String symptom,
                         String requestTime,
                         String name,
                         String birthday,
                         String gender,
                         String identityNumber,
                         String insuranceCode,
                         String address,
                         String dayTarget) {
        this.id = id;
        this.symptom = symptom;
        this.requestTime = requestTime;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.identityNumber = identityNumber;
        this.insuranceCode = insuranceCode;
        this.address = address;
        this.dayTarget = dayTarget;
    }

    public RequestObject(String symptom,
                         String requestTime,
                         String name,
                         String birthday,
                         String gender,
                         String identityNumber,
                         String insuranceCode,
                         String address,
                         String dayTarget) {

        this.symptom = symptom;
        this.requestTime = requestTime;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.identityNumber = identityNumber;
        this.insuranceCode = insuranceCode;
        this.address = address;
        this.dayTarget = dayTarget;
    }

    public RequestObject() {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getInsuranceCode() {
        return insuranceCode;
    }

    public void setInsuranceCode(String insuranceCode) {
        this.insuranceCode = insuranceCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDayTarget() {
        return dayTarget;
    }

    public void setDayTarget(String dayTarget) {
        this.dayTarget = dayTarget;
    }
}
