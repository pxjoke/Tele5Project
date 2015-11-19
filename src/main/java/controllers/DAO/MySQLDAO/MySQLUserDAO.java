package controllers.DAO.MySQLDAO;

import controllers.DAO.api.UserDAO;
import controllers.DAO.api.criteria.Criteria;
import controllers.DAO.api.criteria.UserCriteria;
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
            table + ".name, " + table + ".password, " + table + ".status, " +
            table + ".sms, " + table + ".internet, " + table + ".role, " +
            table + ".minutes, " + table + ".tariff ";


    @Override
    protected String parseBeanForInsert(User bean) {
        StringBuffer tmp = new StringBuffer();
        tmp.append("'"+bean.getPhone()+"'" + ", ");
        tmp.append("'"+bean.getName()+"'" + ", ");
        tmp.append("'"+bean.getPassword()+"'" + ", ");
        tmp.append(bean.getStatus() + ", ");
        tmp.append(bean.getSms() + ", ");
        tmp.append(bean.getInternet() + ", ");
        tmp.append("'"+bean.getRole()+"'" + ", ");
        tmp.append(bean.getMinutes() + ", ");
        tmp.append(bean.getTariffId());
        return tmp.toString();
    }


    @Override
    protected String parseBeanForUpdate(User bean) {
        StringBuffer tmp = new StringBuffer();
        tmp.append("phone='"+bean.getPhone()+"'" + ", ");
        tmp.append("name='"+bean.getName()+"'" + ", ");
        tmp.append("password='"+bean.getPassword()+"'" + ", ");
        tmp.append("status=" + bean.getStatus() + ", ");
        tmp.append("sms=" + bean.getSms() + ", ");
        tmp.append("internet=" + bean.getInternet() + ", ");
        tmp.append("role='"+bean.getRole()+"'" + ", ");
        tmp.append("minutes=" + bean.getMinutes() + ", ");
        tmp.append("tariff=" + bean.getTariffId());
        return tmp.toString();
    }

    @Override
    public User getByPhone(String phone) {
        UserCriteria userCriteria = new MySQLUserCriteria();
        userCriteria.setPhone(phone);
        List<User> userList = getListByCriteria(userCriteria);
        return userList.isEmpty() ? null : userList.get(0);
    }

    @Override
    public boolean updateById(int id, User bean) {
        UserCriteria criteria = new MySQLUserCriteria();
        criteria.setId(String.valueOf(id));
        return updateByCriteria(bean, criteria);
    }

    @Override
    public User getById(int id) {
        MySQLUserCriteria criteria = new MySQLUserCriteria();
        criteria.setId(String.valueOf(id));
        List<User> userList = getListByCriteria(criteria);
        return userList.isEmpty() ? null : userList.get(0);
    }

    @Override
    public boolean deleteById(int id) {
        UserCriteria criteria = new MySQLUserCriteria();
        criteria.setId(String.valueOf(id));
        return deleteByCriteria(criteria);
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
        user.setTariffId(resultSet.getInt("tariff"));
        return user;
    }
}
