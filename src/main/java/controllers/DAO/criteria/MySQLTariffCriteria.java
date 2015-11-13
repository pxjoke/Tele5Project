package controllers.DAO.criteria;

import controllers.DAO.api.criteria.TariffCriteria;

/**
 * Created by pxjok on 14.11.2015.
 */
public class MySQLTariffCriteria extends TariffCriteria{
    private static final String table = "tariffs.";

    @Override
    public String getExpression() {
        StringBuffer expression = new StringBuffer();
        String tmp;
        if((tmp = getId()) != null) expression.append(" AND " + table + "id=" + tmp);
        return expression.toString();
    }
}
