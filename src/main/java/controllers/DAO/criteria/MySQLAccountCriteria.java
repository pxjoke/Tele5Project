package controllers.DAO.criteria;

import controllers.DAO.api.criteria.AccountCriteria;


/**
 * Created by pxjok on 13.11.2015.
 */
public class MySQLAccountCriteria extends AccountCriteria {
    private static final String table = "accounts.";

    @Override
    public String getExpression() {
        StringBuffer expression = new StringBuffer();
        String tmp;
        if((tmp = getId()) != null) expression.append(" AND " + table + "id=" + tmp);
        if((tmp = getStatus()) != null) expression.append(" AND " + table + "close_status=" + tmp);
        if((tmp = getUserId()) != null) expression.append(" AND " + table + "user=" + tmp);
        return expression.toString();
    }
}
