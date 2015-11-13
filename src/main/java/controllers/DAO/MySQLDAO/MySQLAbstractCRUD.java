package controllers.DAO.MySQLDAO;

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
    public List<T> getListByCriteria() {
        List<T> list = new ArrayList<>();
        String sql = getSQLExpressionFromCriteria();
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

    protected abstract String getSQLExpressionFromCriteria();

    protected abstract T parseResultSet(ResultSet resultSet) throws SQLException;
}
