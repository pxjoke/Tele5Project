package controllers.DAO.api;

import controllers.DAO.api.criteria.ServiceCriteria;
import controllers.DAO.api.criteria.UserCriteria;

/**
 * Created by pxjok on 11.11.2015.
 */
public interface DAOFactory {
    UserDAO getUserDAO();
    ServiceDAO getServiceDAO();
    ServiceCriteria getServiceCriteria();
    UserCriteria getUserCriteria();
}
