package controllers.DAO.criteria;

import controllers.DAO.api.criteria.ServiceCriteria;

/**
 * Created by pxjok on 13.11.2015.
 */
public class MySQLServiceCriteria extends ServiceCriteria{
    @Override
    public String getExpression() {
        StringBuffer expression = new StringBuffer();
        String tmp;
        if((tmp = getId()) != null) expression.append(" AND id=" + tmp);
        return expression.toString();
    }
}
