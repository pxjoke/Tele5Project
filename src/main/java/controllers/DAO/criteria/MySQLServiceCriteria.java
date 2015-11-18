package controllers.DAO.criteria;

import controllers.DAO.api.Utils;
import controllers.DAO.api.criteria.ServiceCriteria;

/**
 * Created by pxjok on 13.11.2015.
 */
public class MySQLServiceCriteria extends ServiceCriteria{
    private static final String table = "services.";
    @Override
    public String getExpression() {
        StringBuffer expression = new StringBuffer();
        String tmp;
        if((tmp = getId()) != null) expression.append(" AND " + table + "id=" + tmp);
        if((tmp = getName()) != null) expression.append(" AND " + table + "name=" + Utils.toQuote(tmp));
        return expression.toString();
    }
}
