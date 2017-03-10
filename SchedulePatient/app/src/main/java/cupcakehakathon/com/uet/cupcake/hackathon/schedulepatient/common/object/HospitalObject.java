package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.object;

/**
 * Created by NgocThai on 11/03/2017.
 */

public class HospitalObject {

    private int id;
    private String name;
    private String kind;
    private int limit;
    private String address;
    private String desc;
    private String latitude;
    private String longitude;
    private String phone;
    private String image;
    private double rate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public HospitalObject(int id,
                          String name,
                          String kind,
                          int limit,
                          String address,
                          String desc,
                          String latitude,
                          String longitude,
                          String phone,
                          String image,
                          double rate) {
        this.id = id;
        this.name = name;
        this.kind = kind;
        this.limit = limit;
        this.address = address;
        this.desc = desc;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phone = phone;
        this.image = image;
        this.rate = rate;
    }

    public HospitalObject(String name,
                          String kind,
                          int limit,
                          String address,
                          String desc,
                          String latitude,
                          String longitude,
                          String phone,
                          String image,
                          double rate) {
        this.name = name;
        this.kind = kind;
        this.limit = limit;
        this.address = address;
        this.desc = desc;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phone = phone;
        this.image = image;
        this.rate = rate;
    }
}
