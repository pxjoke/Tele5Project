package controllers.DAO.api;

import controllers.DAO.api.criteria.*;

/**
 * Created by pxjok on 11.11.2015.
 */
public interface DAOFactory {
    UserDAO getUserDAO();
    ServiceDAO getServiceDAO();
    AccountDAO getAccountDao();
    OperationDAO getOperationDao();
    TariffDAO getTariffDao();
    UserServiceDAO getUserServiceDao();
    ServiceCriteria getServiceCriteria();
    UserCriteria getUserCriteria();
    AccountCriteria getAccountCriteria();
    OperationCriteria getOperationCriteria();
    TariffCriteria getTariffCriteria();
    UserServiceCriteria getUserServiceCriteria();

}
