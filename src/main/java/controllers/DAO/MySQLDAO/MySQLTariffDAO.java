package controllers.DAO.MySQLDAO;

import controllers.DAO.api.TariffDAO;
import controllers.DAO.beans.Tariff;
import controllers.DAO.beans.User;
import controllers.DAO.criteria.MySQLTariffCriteria;
import controllers.DAO.criteria.MySQLUserCriteria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by pxjok on 14.11.2015.
 */
public class MySQLTariffDAO extends MySQLAbstractCRUD<Tariff> implements TariffDAO{
    private static final String table = "tariffs";
    private static final String columns = table + ".id, " + table + ".name, " +
            table + ".user_status, " + table + ".minutes, " + table + ".sms, " +
            table + ".internet, "+ table + ".count";


    @Override
    protected String parseBean(Tariff bean) {
        return null;
    }

    @Override
    public Tariff getById(int id) {
        MySQLTariffCriteria criteria = new MySQLTariffCriteria();
        criteria.setId(String.valueOf(id));
        List<Tariff> tariffList = getListByCriteria(criteria);
        return tariffList.isEmpty() ? null : tariffList.get(0);
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
    protected Tariff parseResultSet(ResultSet resultSet) throws SQLException {
        Tariff tariff = new Tariff();
        tariff.setId(resultSet.getInt("id"));
        tariff.setName(resultSet.getString("name"));
        tariff.setMinutes(resultSet.getDouble("minutes"));
        tariff.setInternet(resultSet.getDouble("internet"));
        tariff.setSms(resultSet.getDouble("sms"));
        tariff.setUserStatus(resultSet.getInt("user_status"));
        tariff.setCount(resultSet.getInt("count"));
        return tariff;
    }
}
