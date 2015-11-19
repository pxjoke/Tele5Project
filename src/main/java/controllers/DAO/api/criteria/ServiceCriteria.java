package controllers.DAO.api.criteria;

import java.util.List;

/**
 * Created by pxjok on 13.11.2015.
 */
public abstract class ServiceCriteria implements Criteria {
    private String id;
    private String name;
    private String typePassive;
    private String typeTariff;
    private String typePackgage;

    public String getTypePassive() {
        return typePassive;
    }

    public void setTypePassive(String typePassive) {
        this.typePassive = typePassive;
    }

    public String getTypeTariff() {
        return typeTariff;
    }

    public void setTypeTariff(String typeTariff) {
        this.typeTariff = typeTariff;
    }

    public String getTypePackgage() {
        return typePackgage;
    }

    public void setTypePackgage(String typePackgage) {
        this.typePackgage = typePackgage;
    }

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
