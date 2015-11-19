package controllers.DAO.criteria;

import controllers.DAO.api.criteria.UserCriteria;

/**
 * Created by pxjok on 13.11.2015.
 */
public class MySQLUserCriteria extends UserCriteria{
    private static final String table = "users.";

    @Override
    public String getExpression() {
        StringBuffer expression = new StringBuffer();
        String tmp;
        if((tmp = getId()) != null) expression.append(" AND " + table + "id=" + tmp);
        if((tmp = getPhone()) != null) expression.append(" AND " + table + "phone=" + tmp);
        return expression.toString();
    }
}
