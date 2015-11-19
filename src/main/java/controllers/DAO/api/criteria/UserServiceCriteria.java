package controllers.DAO.api.criteria;

/**
 * Created by pxjok on 13.11.2015.
 */
public abstract class UserServiceCriteria implements Criteria{
    private String id;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
