package controllers.DAO.api.criteria;

/**
 * Created by pxjok on 13.11.2015.
 */
public abstract class ServiceCriteria implements Criteria {
    private String id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
