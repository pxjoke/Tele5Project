package controllers.DAO.beans;

/**
 * Created by pxjok on 11.11.2015.
 */
public class User {
    private int id;
    private String role;
    private int tariffId;
    private String phone;
    private String name;
    private String password;
    private int status;
    private int internal;
    private int external;
    private int roaming;
    private int sms;
    private int internet;

    public User(){}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getTariffId() {
        return tariffId;
    }

    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getInternal() {
        return internal;
    }

    public void setInternal(int internal) {
        this.internal = internal;
    }

    public int getExternal() {
        return external;
    }

    public void setExternal(int external) {
        this.external = external;
    }

    public int getRoaming() {
        return roaming;
    }

    public void setRoaming(int roaming) {
        this.roaming = roaming;
    }

    public int getSms() {
        return sms;
    }

    public void setSms(int sms) {
        this.sms = sms;
    }

    public int getInternet() {
        return internet;
    }

    public void setInternet(int internet) {
        this.internet = internet;
    }
}
