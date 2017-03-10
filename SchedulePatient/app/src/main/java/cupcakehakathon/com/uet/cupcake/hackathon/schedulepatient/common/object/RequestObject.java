package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.object;

/**
 * Created by NgocThai on 11/03/2017.
 */

public class RequestObject {

    private int id;
    private int idPatient;
    private String symptom;
    private String requestTime;
    private int idFaculty;
    private int checked;
    private String dayTarget;

    public RequestObject(int id, int idPatient, String symptom, String requestTime, int idFaculty, int checked, String dayTarget) {
        this.id = id;
        this.idPatient = idPatient;
        this.symptom = symptom;
        this.requestTime = requestTime;
        this.idFaculty = idFaculty;
        this.checked = checked;
        this.dayTarget = dayTarget;
    }

    public RequestObject(int idPatient, String symptom, String requestTime, int idFaculty, int checked, String dayTarget) {

        this.idPatient = idPatient;
        this.symptom = symptom;
        this.requestTime = requestTime;
        this.idFaculty = idFaculty;
        this.checked = checked;
        this.dayTarget = dayTarget;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
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

    public int getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(int idFaculty) {
        this.idFaculty = idFaculty;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public String getDayTarget() {
        return dayTarget;
    }

    public void setDayTarget(String dayTarget) {
        this.dayTarget = dayTarget;
    }

}
