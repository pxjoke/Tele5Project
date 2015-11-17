package controllers.DAO.criteria;

import controllers.DAO.api.criteria.AccountCriteria;


/**
 * Created by pxjok on 13.11.2015.
 */
public class MySQLUserServiceCriteria extends AccountCriteria {
    private static final String table = "user_services.";

    @Override
    public String getExpression() {
        StringBuffer expression = new StringBuffer();
        String tmp;
        if((tmp = getId()) != null) expression.append(" AND " + table + "id=" + tmp);
        return expression.toString();
    }
}
