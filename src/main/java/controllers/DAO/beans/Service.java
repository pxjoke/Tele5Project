package controllers.DAO.beans;

/**
 * Created by pxjok on 12.11.2015.
 */
public class Service {
    private int id;
    private String name;
    private double cost;
    private String descriprion;

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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescriprion() {
        return descriprion;
    }

    public void setDescriprion(String descriprion) {
        this.descriprion = descriprion;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", descriprion='" + descriprion + '\'' +
                '}';
    }
}
