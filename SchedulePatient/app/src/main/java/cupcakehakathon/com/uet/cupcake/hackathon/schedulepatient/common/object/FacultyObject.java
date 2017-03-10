package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.object;

/**
 * Created by NgocThai on 11/03/2017.
 */

public class FacultyObject {

    private int id;
    private String name;
    private int idHospital;
    private String description;
    private int kind;

    public FacultyObject(int id, String name, int idHospital, String description, int kind) {
        this.id = id;
        this.name = name;
        this.idHospital = idHospital;
        this.description = description;
        this.kind = kind;
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

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

}
