package controllers.DAO.MySQLDAO;

import controllers.DAO.api.criteria.Criteria;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pxjok on 13.11.2015.
 */
public abstract class MySQLAbstractCRUD<T> {
    protected List<T> getListByCriteria(Criteria criteria) {
        List<T> list = new ArrayList<>();
        String criteriaExpression = (criteria == null) ? "" : criteria.getExpression();
        String sql = getSelectExpression() + criteriaExpression + ";";
        try (Connection connection = MySQLDaoFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                list.add(parseResultSet(resultSet));
            }

        } catch (SQLException s) {
            s.printStackTrace();
        }

        return list;
    }

    protected String getSelectExpression(){
        return "SELECT " + getColumns() + " FROM " + getTable() + " WHERE 1=1";
    }

    protected abstract String getColumns();
    protected abstract String getTable();

    protected abstract T parseResultSet(ResultSet resultSet) throws SQLException;
}
