package controllers.DAO.MySQLDAO;

import controllers.DAO.api.UserDAO;
import controllers.DAO.api.criteria.Criteria;
import controllers.DAO.beans.User;
import controllers.DAO.criteria.MySQLUserCriteria;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by pxjok on 11.11.2015.
 */
public class MySQLUserDAO extends MySQLAbstractCRUD<User> implements UserDAO {
    private final String table = "users";
    private final String columns = table + ".id, " + table + ".phone, " +
            table + " .name, " +table + ".password, " + table + ".status, " +
            table + ".sms, " + table + ".internet, " + table + ".role, " + table + ".minutes";


    @Override
    public User getById(int id) {
        MySQLUserCriteria criteria = new MySQLUserCriteria();
        criteria.setId(String.valueOf(id));
        List<User> userList = getListByCriteria(criteria);
        return userList.isEmpty() ? null : userList.get(0);
    }

    @Override
    protected String getColumns() {
        return columns;
    }

    @Override
    protected String getTable() {
        return table;
    }

    @Override
    protected User parseResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setPhone(resultSet.getString("phone"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        user.setStatus(resultSet.getInt("status"));
        user.setMinutes(resultSet.getInt("minutes"));
        user.setSms(resultSet.getInt("sms"));
        user.setInternet(resultSet.getInt("internet"));
        user.setRole(resultSet.getString("role"));
        return user;
    }
}
