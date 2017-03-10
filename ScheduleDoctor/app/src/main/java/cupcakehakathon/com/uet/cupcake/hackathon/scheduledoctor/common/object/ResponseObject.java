package cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.common.object;

import java.io.Serializable;

/**
 * Created by Luong Tran on 3/10/2017.
 */

public class ResponseObject implements Serializable {

    private int id;
    private String appointmentTime;
    private String apppointmentTimeEnd;
    private String responseDate;
    private String description;
    private int idDoctor;
    private int idRoom;
    private int idRequest;

    public ResponseObject() {
    }

    public ResponseObject(int id, String appointmentTime, String description, int idDoctor, int idRoom, int idRequest) {
        this.id = id;
        this.appointmentTime = appointmentTime;
        this.description = description;
        this.idDoctor = idDoctor;
        this.idRoom = idRoom;
        this.idRequest = idRequest;
    }

    public ResponseObject(String appointmentTime, String description, int idDoctor, int idRoom, int idRequest) {
        this.appointmentTime = appointmentTime;
        this.description = description;
        this.idDoctor = idDoctor;
        this.idRoom = idRoom;
        this.idRequest = idRequest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public String getApppointmentTimeEnd() {
        return apppointmentTimeEnd;
    }

    public void setApppointmentTimeEnd(String apppointmentTimeEnd) {
        this.apppointmentTimeEnd = apppointmentTimeEnd;
    }

    public String getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(String responseDate) {
        this.responseDate = responseDate;
    }
}
