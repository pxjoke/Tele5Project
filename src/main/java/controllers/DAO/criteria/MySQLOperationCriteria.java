package controllers.DAO.criteria;

import controllers.DAO.api.criteria.OperationCriteria;
import controllers.DAO.api.criteria.UserServiceCriteria;


/**
 * Created by pxjok on 13.11.2015.
 */
public class MySQLOperationCriteria extends OperationCriteria {
    private static final String table = "operations.";

    @Override
    public String getExpression() {
        StringBuffer expression = new StringBuffer();
        String tmp;
        if((tmp = getId()) != null) expression.append(" AND " + table + "id=" + tmp);
        if((tmp = getAccountId()) != null) expression.append(" AND " + table + "account=" + tmp);
        return expression.toString();
    }
}
