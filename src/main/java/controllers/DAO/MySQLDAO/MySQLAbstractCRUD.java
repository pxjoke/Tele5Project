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
    public List<T> getListByCriteria(Criteria criteria) {
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

    public List<T> getAll() {
        return getListByCriteria(null);
    }

    public boolean insert(T bean) {
        if (bean == null) return false;
        String sql = getInsertExpression(bean) + ";";
        try (Connection connection = MySQLDaoFactory.getConnection();
             Statement statement = connection.createStatement()) {
            return statement.executeUpdate(sql) > 0 ? true : false;
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return false;
    }

    public boolean deleteByCriteria(Criteria criteria) {
        String criteriaExpression = (criteria == null) ? "" : criteria.getExpression();
        String sql = getDeleteExpression() + criteriaExpression + ";";
        try (Connection connection = MySQLDaoFactory.getConnection();
             Statement statement = connection.createStatement()) {
            return statement.executeUpdate(sql) > 0 ? true : false;

        } catch (SQLException s) {
            s.printStackTrace();
        }
        return false;
    }

    public boolean updateByCriteria(T bean, Criteria criteria){
        if (bean == null) return false;
        String criteriaExpression = (criteria == null) ? "" : criteria.getExpression();
        String sql = getUpdateExpression(bean) + criteriaExpression + ";";
        try (Connection connection = MySQLDaoFactory.getConnection();
             Statement statement = connection.createStatement()) {
            return statement.executeUpdate(sql) > 0 ? true : false;

        } catch (SQLException s) {
            s.printStackTrace();
        }
        return false;
    }



    protected String getDeleteExpression() {
        return "DELETE FROM " + getTable() + " WHERE 1=1 ";
    }

    protected String getUpdateExpression(T bean){
        return "UPDATE " + getTable() + " SET " + parseBeanForUpdate(bean) + " WHERE 1=1 ";
    }

    protected abstract String parseBeanForUpdate(T bean);

    protected String getInsertExpression(T bean) {
        return "INSERT INTO " + getTable() + " (" +
                getColumns().replace(getTable() + ".id,", "") + ") VALUES" +
                " (" + parseBeanForInsert(bean) + ")";

    }

    protected String getSelectExpression() {

        return "SELECT " + getColumns() + getAdditionalColumns() +
                " FROM " + getTable() + getAdditionalTables() + " WHERE 1=1 " + getAdditionalCondition();
    }

    protected abstract String getColumns();

    protected abstract String getTable();

    protected String getAdditionalTables(){
        return "";
    }

    protected String getAdditionalColumns(){
        return "";
    }

    protected String getAdditionalCondition(){
        return "";
    }


    protected abstract T parseResultSet(ResultSet resultSet) throws SQLException;

    protected abstract String parseBeanForInsert(T bean);

    protected String toQuote(String string){
        return "'" + string + "'";
    }
}
