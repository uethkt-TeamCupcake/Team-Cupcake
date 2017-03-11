package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.object;

/**
 * Created by NgocThai on 10/03/2017.
 */

public class PatientObject {

    private int id;
    private String name;

    private String gender;
    private String identityNumber;
    private String insuranceCode;
    private String address;

    private String email;
    private String userName;
    private String birthDay;
    private String passWord;

    public PatientObject(String email, String userName, String birthDay, String passWord) {
        this.email = email;
        this.userName = userName;
        this.birthDay = birthDay;
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PatientObject(int id, String name, String userName, String gender, String birthDay, String identityNumber, String insuranceCode, String passWord, String address) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.gender = gender;
        this.birthDay = birthDay;
        this.identityNumber = identityNumber;
        this.insuranceCode = insuranceCode;
        this.passWord = passWord;
        this.address = address;
    }

    public PatientObject(String name, String userName, String gender, String birthDay, String identityNumber, String insuranceCode, String passWord, String address) {

        this.name = name;
        this.userName = userName;
        this.gender = gender;
        this.birthDay = birthDay;
        this.identityNumber = identityNumber;
        this.insuranceCode = insuranceCode;
        this.passWord = passWord;
        this.address = address;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
