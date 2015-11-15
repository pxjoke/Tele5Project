package controllers.DAO.MySQLDAO;

import controllers.DAO.api.DAOFactory;
import controllers.DAO.api.ServiceDAO;
import controllers.DAO.api.UserDAO;
import controllers.DAO.api.criteria.ServiceCriteria;
import controllers.DAO.api.criteria.UserCriteria;
import controllers.DAO.criteria.MySQLServiceCriteria;
import controllers.DAO.criteria.MySQLUserCriteria;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by pxjok on 11.11.2015.
 */
public class MySQLDaoFactory implements DAOFactory {
    private static String user = "pxjoke";
    private static String password = "12345";
    private static String url = "jdbc:mysql://localhost:3306/tele5";

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

//        try {
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        Connection connection = DriverManager.getConnection(url, user, password);
//        return connection;
    }

    @Override
    public UserDAO getUserDAO() {
        return new MySQLUserDAO();
    }

    @Override
    public ServiceDAO getServiceDAO() {
        return new MySQLServiceDAO();
    }

    @Override
    public ServiceCriteria getServiceCriteria() {
        return new MySQLServiceCriteria();
    }

    @Override
    public UserCriteria getUserCriteria() {
        return new MySQLUserCriteria();
    }
}
