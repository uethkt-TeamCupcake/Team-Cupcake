package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.object;

/**
 * Created by NgocThai on 10/03/2017.
 */

public class PatientObject {

    private int id;
    private String name;
    private int gender;
    private String identityNumber;
    private String insuranceCode;
    private String address;
    private String userName;
    private String birthDay;
    private String passWord;

    public PatientObject(int id, String name, int gender, String identityNumber,
                         String insuranceCode, String address, String userName, String birthDay, String passWord) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.identityNumber = identityNumber;
        this.insuranceCode = insuranceCode;
        this.address = address;
        this.userName = userName;
        this.birthDay = birthDay;
        this.passWord = passWord;
    }

    public PatientObject(String name, int gender, String identityNumber, String insuranceCode,
                         String address, String userName, String birthDay, String passWord) {

        this.name = name;
        this.gender = gender;
        this.identityNumber = identityNumber;
        this.insuranceCode = insuranceCode;
        this.address = address;
        this.userName = userName;
        this.birthDay = birthDay;
        this.passWord = passWord;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
