package controllers.DAO.MySQLDAO;

import controllers.DAO.api.AccountDAO;
import controllers.DAO.api.criteria.AccountCriteria;
import controllers.DAO.api.criteria.UserCriteria;
import controllers.DAO.beans.Account;
import controllers.DAO.beans.User;
import controllers.DAO.criteria.MySQLAccountCriteria;
import controllers.DAO.criteria.MySQLUserCriteria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by pxjok on 11.11.2015.
 */
public class MySQLAccountDAO extends MySQLAbstractCRUD<Account> implements AccountDAO {
    private final String table = "accounts";
    private final String operationsTable = "operations";

    private final String columns = table + ".id, " + table + ".user, " +
            table + ".open, " + table + ".close, " + table + ".close_status";
    private final String operationsColumns = " SUM(" + operationsTable + ".cost) ";

    @Override
    protected String getAdditionalColumns() {
        return ", " + operationsColumns;
    }

    @Override
    protected String getGroupBy() {
        return " GROUP BY " + table + ".id ";
    }

    @Override
    protected String getAdditionalTables() {
        return " LEFT JOIN " + operationsTable + " ON "+operationsTable + ".account = " + table + ".id " ;
    }



    @Override
    protected String parseBeanForInsert(Account bean) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(bean.getUserId() + ", ");
        tmp.append(toQuote(bean.getOpenDate()) + ", ");
        tmp.append(toQuote(bean.getCloseDate()) + ", ");
        tmp.append(bean.isClosed());
        return tmp.toString();
    }


    @Override
    protected String parseBeanForUpdate(Account bean) {
        StringBuilder tmp = new StringBuilder();
        tmp.append("user=" + bean.getUserId() + ", ");
        tmp.append("open=" + toQuote(bean.getOpenDate()) + ", ");
        tmp.append("close=" + toQuote(bean.getCloseDate()) + ", ");
        tmp.append("close_status=" + bean.isClosed());
        return tmp.toString();
    }

    @Override
    protected Account parseResultSet(ResultSet resultSet) throws SQLException {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        Account bean = new Account();
        bean.setId(resultSet.getInt("id"));
        bean.setUserId(resultSet.getInt("user"));
        bean.setOpenDate(formater.format(resultSet.getDate("open")));
        bean.setCloseDate(formater.format(resultSet.getDate("close")));
        bean.setClosed(resultSet.getBoolean("close_status"));
        bean.setTotalPrice(resultSet.getDouble("SUM(" + operationsTable + ".cost)"));
        return bean;
    }

    @Override
    public Account getCurrent(int userId) {
        AccountCriteria criteria = new MySQLAccountCriteria();
        criteria.setStatus("0");
        criteria.setUserId(String.valueOf(userId));
        List<Account> list = getListByCriteria(criteria);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public boolean updateById(int id, Account bean) {
        AccountCriteria criteria = new MySQLAccountCriteria();
        criteria.setId(String.valueOf(id));
        return updateByCriteria(bean, criteria);
    }

    @Override
    public Account getById(int id) {
        MySQLAccountCriteria criteria = new MySQLAccountCriteria();
        criteria.setId(String.valueOf(id));
        List<Account> list = getListByCriteria(criteria);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public boolean deleteById(int id) {
        AccountCriteria criteria = new MySQLAccountCriteria();
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
}
