package controllers.DAO.MySQLDAO;

import controllers.DAO.api.DAOFactory;
import controllers.DAO.api.ServiceDAO;
import controllers.DAO.api.UserDAO;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by pxjok on 11.11.2015.
 */
public class MySQLDaoFactory implements DAOFactory {

    public static Connection getConnection() throws SQLException {
        InitialContext initContext = null;
        try {
            initContext = new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        DataSource ds = null;
        try {
            ds = (DataSource) initContext.lookup("java:comp/env/jdbc/tele5");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        Connection conn = ds.getConnection();
        return conn;
    }
    @Override
    public UserDAO getUserDAO() {
        return new MySQLUserDAO();
    }

    @Override
    public ServiceDAO getServiceDAO() {
        return new MySQLServiceDAO();
    }
}
