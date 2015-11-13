

import controllers.DAO.criteria.MySQLTariffCriteria;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pxjok on 14.11.2015.
 */
public class MySQLTariffCriteriaTest {

    private MySQLTariffCriteria mySQLTariffCriteria;

    @Before
    public void setUp() throws Exception {
        mySQLTariffCriteria = new MySQLTariffCriteria();
    }

    @Test
    public void testGetExpressionWithId() throws Exception {
        mySQLTariffCriteria.setId(String.valueOf(15));
        String expression = mySQLTariffCriteria.getExpression();
        assertTrue(" AND tariffs.id=15".equals(expression));
    }

    @Test
    public void testGetExpressionWithoutParams() throws Exception {
        mySQLTariffCriteria = new MySQLTariffCriteria();
        String expression = mySQLTariffCriteria.getExpression();
        assertTrue(expression.isEmpty());
    }
}