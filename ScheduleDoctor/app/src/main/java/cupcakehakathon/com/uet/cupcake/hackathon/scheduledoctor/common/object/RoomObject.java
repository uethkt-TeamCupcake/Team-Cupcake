package cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.common.object;

import java.io.Serializable;

/**
 * Created by Luong Tran on 3/10/2017.
 */

public class RoomObject
    implements Serializable {

    private int id;
    private String name;
    private String description;
    private int limitOneDay;
    private String timeStart;
    private String timeEnd;
    private int currentLimit;
    private String timeAvailable;
    private int timeSize;

    public RoomObject() {
    }

    public RoomObject(int id,
                      String name,
                      String description,
                      int limitOneDay,
                      String timeStart,
                      String timeEnd,
                      int currentLimit,
                      String timeAvailable,
                      int timeSize) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.limitOneDay = limitOneDay;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.currentLimit = currentLimit;
        this.timeAvailable = timeAvailable;
        this.timeSize = timeSize;
    }

    public RoomObject(String name,
                      String description,
                      int limitOneDay,
                      String timeStart,
                      String timeEnd,
                      int currentLimit,
                      String timeAvailable,
                      int timeSize) {

        this.name = name;
        this.description = description;
        this.limitOneDay = limitOneDay;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.currentLimit = currentLimit;
        this.timeAvailable = timeAvailable;
        this.timeSize = timeSize;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLimitOneDay() {
        return limitOneDay;
    }

    public void setLimitOneDay(int limitOneDay) {
        this.limitOneDay = limitOneDay;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getCurrentLimit() {
        return currentLimit;
    }

    public void setCurrentLimit(int currentLimit) {
        this.currentLimit = currentLimit;
    }

    public String getTimeAvailable() {
        return timeAvailable;
    }

    public void setTimeAvailable(String timeAvailable) {
        this.timeAvailable = timeAvailable;
    }

    public int getTimeSize() {
        return timeSize;
    }

    public void setTimeSize(int timeSize) {
        this.timeSize = timeSize;
    }
}
