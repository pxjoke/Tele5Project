package controllers.DAO.api.criteria;

/**
 * Created by pxjok on 13.11.2015.
 */
public abstract class UserCriteria implements Criteria{
    private String id;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
