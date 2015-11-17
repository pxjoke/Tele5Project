package controllers.DAO.beans;

/**
 * Created by pxjok on 17.11.2015.
 */
public class Account {
    int id;
    int userId;
    String openDate;
    String closeDate;
    boolean closeStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public boolean isCloseStatus() {
        return closeStatus;
    }

    public void setCloseStatus(boolean closeStatus) {
        this.closeStatus = closeStatus;
    }
}
