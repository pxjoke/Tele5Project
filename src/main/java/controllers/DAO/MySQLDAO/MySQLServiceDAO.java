package controllers.DAO.MySQLDAO;

import controllers.DAO.api.ServiceDAO;
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


    private MySQLServiceCriteria mySQLServiceCriteria = null;
    private static final String columns = "services.id, services.name, services.cost, services.description";
    private static final String table = "services";

    @Override
    public List<Service> getAll() {
        List<Service> serviceList;
        serviceList = getListByCriteria(null);
        return serviceList;
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
