package controllers.DAO.MySQLDAO;

import controllers.DAO.ServiceDAO;
import controllers.DAO.beans.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by pxjok on 12.11.2015.
 */
public class MySQLServiceDAO extends MySQLAbstractReader<Service> implements ServiceDAO {

    @Override
    protected String getSQLExpressionFromCriteria() {
        return null;
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
