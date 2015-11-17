package controllers.DAO.MySQLDAO;



import controllers.DAO.api.OperationDAO;
import controllers.DAO.api.UserServiceDAO;
import controllers.DAO.api.criteria.OperationCriteria;
import controllers.DAO.api.criteria.UserServiceCriteria;
import controllers.DAO.beans.Operation;
import controllers.DAO.beans.UserService;
import controllers.DAO.criteria.MySQLOperationCriteria;
import controllers.DAO.criteria.MySQLUserServiceCriteria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by pxjok on 11.11.2015.
 */
public class MySQLOperationDAO extends MySQLAbstractCRUD<Operation> implements OperationDAO {
    private final String table = "operations";
    private final String columns = table + ".id, " + table + ".account, " +
            table + ".type, " + table + ".cost, " + table + ".amount, "
            + table + ".time, " + table + ".service";


    @Override
    protected String parseBeanForInsert(Operation bean) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(bean.getAccountId() + ", ");
        tmp.append(toQuote(bean.getType()) + ", ");
        tmp.append(bean.getCost() + ", ");
        tmp.append(bean.getAmount() + ", ");
        tmp.append(toQuote(bean.getTime()) + ", ");
        tmp.append(bean.getServiceId());
        return tmp.toString();
    }


    @Override
    protected String parseBeanForUpdate(Operation bean) {
        StringBuilder tmp = new StringBuilder();
        tmp.append("account=" + bean.getAccountId() + ", ");
        tmp.append("type=" + toQuote(bean.getType()) + ", ");
        tmp.append("cost=" + bean.getCost() + ", ");
        tmp.append("amount=" + bean.getAmount() + ", ");
        tmp.append("time=" + toQuote(bean.getTime()) + ", ");
        tmp.append("service=" + bean.getServiceId());
        return tmp.toString();
    }

    @Override
    public boolean updateById(int id, Operation bean) {
        OperationCriteria criteria = new MySQLOperationCriteria();
        criteria.setId(String.valueOf(id));
        return updateByCriteria(bean, criteria);
    }

    @Override
    public Operation getById(int id) {
        MySQLOperationCriteria criteria = new MySQLOperationCriteria();
        criteria.setId(String.valueOf(id));
        List<Operation> list = getListByCriteria(criteria);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public boolean deleteById(int id) {
        OperationCriteria criteria = new MySQLOperationCriteria();
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
    protected Operation parseResultSet(ResultSet resultSet) throws SQLException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Operation bean = new Operation();
        bean.setId(resultSet.getInt("id"));
        bean.setAccountId(resultSet.getInt("account"));
        bean.setType(resultSet.getString("type"));
        bean.setCost(resultSet.getDouble("cost"));
        bean.setAmount(resultSet.getInt("amount"));
        bean.setTime(formatter.format(resultSet.getDate("time")));
        bean.setServiceId(resultSet.getInt("service"));
        return bean;
    }
}
