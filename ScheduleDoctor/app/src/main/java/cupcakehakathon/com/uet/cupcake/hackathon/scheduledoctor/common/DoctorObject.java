package cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.common;

/**
 * Created by Luong Tran on 3/10/2017.
 */

public class DoctorObject {

    private String id;

    private String name;

    private int age;

    private String idPhong;

    private String idHospital;

    private String userName;

    private String passWord;

    private String idFaculty;

    public DoctorObject(String id,
                        String name,
                        int age,
                        String idPhong,
                        String idHospital,
                        String userName,
                        String passWord,
                        String idFaculty) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.idPhong = idPhong;
        this.idHospital = idHospital;
        this.userName = userName;
        this.passWord = passWord;
        this.idFaculty = idFaculty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(String idPhong) {
        this.idPhong = idPhong;
    }

    public String getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(String idHospital) {
        this.idHospital = idHospital;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(String idFaculty) {
        this.idFaculty = idFaculty;
    }
}
