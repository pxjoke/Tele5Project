package controllers.DAO.MySQLDAO;


import controllers.DAO.api.UserServiceDAO;
import controllers.DAO.api.criteria.UserServiceCriteria;
import controllers.DAO.beans.UserService;
import controllers.DAO.criteria.MySQLUserServiceCriteria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by pxjok on 11.11.2015.
 */
public class MySQLUserServiceDAO extends MySQLAbstractCRUD<UserService> implements UserServiceDAO {
    private final String table = "user_services";
    private final String serviceTable = "services";
    private final String columns = table + ".id, " + table + ".user, " + table + ".service";
    private final String serviceColumns = serviceTable + ".name, " + serviceTable + ".cost";


    @Override
    protected String parseBeanForInsert(UserService bean) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(bean.getUserId() + ", ");
        tmp.append(bean.getServiceId());
        return tmp.toString();
    }


    @Override
    protected String parseBeanForUpdate(UserService bean) {
        StringBuilder tmp = new StringBuilder();
        tmp.append("user=" + bean.getUserId() + ", ");
        tmp.append("service=" + bean.getServiceId());
        return tmp.toString();
    }

    @Override
    protected UserService parseResultSet(ResultSet resultSet) throws SQLException {
        UserService bean = new UserService();
        bean.setId(resultSet.getInt("id"));
        bean.setUserId(resultSet.getInt("user"));
        bean.setServiceId(resultSet.getInt("service"));
        bean.setServiceName(resultSet.getString("name"));
        bean.setServiceCost(resultSet.getDouble("cost"));
        return bean;
    }

    @Override
    public boolean deleteByIdAndUserId(int id, int userId) {
        UserServiceCriteria userServiceCriteria = new MySQLUserServiceCriteria();
        userServiceCriteria.setId(String.valueOf(id));
        userServiceCriteria.setUserId(String.valueOf(userId));
        return deleteByCriteria(userServiceCriteria);
    }

    @Override
    public boolean updateById(int id, UserService bean) {
        UserServiceCriteria criteria = new MySQLUserServiceCriteria();
        criteria.setId(String.valueOf(id));
        return updateByCriteria(bean, criteria);
    }

    @Override
    public List<UserService> getAllByUserId(int id) {
        UserServiceCriteria criteria = new MySQLUserServiceCriteria();
        criteria.setUserId(String.valueOf(id));
        return getListByCriteria(criteria);
    }

    @Override
    public UserService getById(int id) {
        MySQLUserServiceCriteria criteria = new MySQLUserServiceCriteria();
        criteria.setId(String.valueOf(id));
        List<UserService> list = getListByCriteria(criteria);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public boolean deleteById(int id) {
        UserServiceCriteria criteria = new MySQLUserServiceCriteria();
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
    protected String getAdditionalTables() {
        return ", " + serviceTable;
    }

    @Override
    protected String getAdditionalColumns() {
        return ", " + serviceColumns;
    }

    @Override
    protected String getAdditionalCondition() {
        return " AND " + table +".service=" + serviceTable + ".id";
    }
}
