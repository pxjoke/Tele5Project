package controllers.DAO.MySQLDAO;

import controllers.DAO.api.ServiceDAO;
import controllers.DAO.api.criteria.ServiceCriteria;
import controllers.DAO.beans.Service;
import controllers.DAO.criteria.MySQLServiceCriteria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pxjok on 12.11.2015.
 */
public class MySQLServiceDAO extends MySQLAbstractCRUD<Service> implements ServiceDAO {


    private static final String table = "services";
    private static final String columns = table + ".id, " + table + ".name, " +
            table + ".cost, " + table + ".description";

    @Override
    protected String parseBeanForUpdate(Service bean) {
        StringBuilder tmp = new StringBuilder();
        tmp.append("name=" + toQuote(bean.getName()) + ", ");
        tmp.append("cost=" + bean.getCost() + ", ");
        tmp.append("description=" + toQuote(bean.getDescriprion()));
        return tmp.toString();
    }

    @Override
    protected String parseBeanForInsert(Service bean) {

        StringBuilder tmp = new StringBuilder();
        tmp.append(toQuote(bean.getName()) + ", ");
        tmp.append(bean.getCost() + ", ");
        tmp.append(toQuote(bean.getDescriprion()));
        return tmp.toString();
    }

    @Override
    public Service getById(int id) {
        MySQLServiceCriteria criteria = new MySQLServiceCriteria();
        criteria.setId(String.valueOf(id));
        List<Service> list = getListByCriteria(criteria);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public boolean deleteById(int id) {
        ServiceCriteria criteria = new MySQLServiceCriteria();
        criteria.setId(String.valueOf(id));
        return deleteByCriteria(criteria);
    }

    @Override
    public boolean updateById(int id, Service bean) {
        ServiceCriteria criteria = new MySQLServiceCriteria();
        criteria.setId(String.valueOf(id));
        return updateByCriteria(bean, criteria);
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
    protected Service parseResultSet(ResultSet resultSet) throws SQLException {
        Service service = new Service();
        service.setId(resultSet.getInt("id"));
        service.setName(resultSet.getString("name"));
        service.setDescriprion(resultSet.getString("description"));
        service.setCost(resultSet.getDouble("cost"));
        return service;
    }
}
