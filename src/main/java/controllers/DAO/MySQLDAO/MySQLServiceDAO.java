package controllers.DAO.MySQLDAO;

import controllers.DAO.api.ServiceDAO;
import controllers.DAO.beans.Service;
import controllers.DAO.criteria.MySQLServiceCriteria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by pxjok on 12.11.2015.
 */
public class MySQLServiceDAO extends MySQLAbstractCRUD<Service> implements ServiceDAO {


    private MySQLServiceCriteria mySQLServiceCriteria = null;
    private static final String columns = "service.id, service.name, service.cost, service.description";
    private static final String table = "service";

    public Service getById(int id){
        mySQLServiceCriteria = new MySQLServiceCriteria();
        mySQLServiceCriteria.setId(String.valueOf(id));
        List<Service> list = getListByCriteria();
        mySQLServiceCriteria = null;
        if (list.isEmpty()) return null;
        else return list.get(0);
    }

    @Override
    public List<Service> getAll() {
        return getListByCriteria();
    }

    @Override
    protected String getSQLExpressionFromCriteria() {
        StringBuffer sql = new StringBuffer("SELECT " + columns + " FROM " + table + " WHERE 1=1");
        String tmp;
        if (mySQLServiceCriteria != null){
            if ((tmp = mySQLServiceCriteria.getId()) != null) sql.append(" AND id=" + tmp);
        }
        return sql.toString();
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
