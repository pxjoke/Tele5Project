package controllers;

import controllers.DAO.MySQLDAO.MySQLDaoFactory;
import controllers.DAO.api.DAOFactory;

/**
 * Created by pxjok on 19.11.2015.
 */
public class Connections {
    private static DAOFactory factory = null;

    public static DAOFactory getFactory() {
        if (factory == null) {
            factory = new MySQLDaoFactory();
        }
        return factory;
    }
}
