package controllers.DAO.beans;

/**
 * Created by pxjok on 17.11.2015.
 */
public class UserService {
    private int id;
    private int userId;
    private int serviceId;
    private String serviceName;
    private double serviceCost;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

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

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "id=" + id +
                ", userId=" + userId +
                ", serviceId=" + serviceId +
                ", serviceName='" + serviceName + '\'' +
                ", serviceCost=" + serviceCost +
                '}';
    }
}
