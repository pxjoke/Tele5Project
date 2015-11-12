package controllers.DAO.MySQLDAO;

import controllers.DAO.UserDAO;
import controllers.DAO.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by pxjok on 11.11.2015.
 */
public class MySQLUserDAO implements UserDAO {
    private final String columns = "id, phone, name, password, status, internal," +
            "external, roaming, sms, internet, role";

    public User getById(int id) {
        String sql = new String("SELECT " + columns + " FROM users WHERE id=" + id);
        try (Connection connection = MySQLDaoFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                return parseResult(resultSet);
            }

            return null;

        } catch (SQLException s) {
            s.printStackTrace();
        }

        return null;
    }

    public List<User> getAll() {
        return null;
    }



    private User parseResult(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setPhone(resultSet.getString("phone"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        user.setStatus(resultSet.getInt("status"));
        user.setInternal(resultSet.getInt("internal"));
        user.setExternal(resultSet.getInt("external"));
        user.setRoaming(resultSet.getInt("roaming"));
        user.setSms(resultSet.getInt("sms"));
        user.setInternet(resultSet.getInt("internet"));
        user.setRole(resultSet.getString("role"));
        return user;
    }
}
