package controllers.DAO;

/**
 * Created by pxjok on 11.11.2015.
 */
public interface DAOFactory {
    UserDAO getUserDAO();
    ServiceDAO getServiceDAO();
}