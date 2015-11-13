package controllers.DAO.criteria;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pxjok on 13.11.2015.
 */
public class MySQLServiceCriteriaTest {

    private MySQLServiceCriteria mySQLServiceCriteria;

    @Before
    public void setUp() throws Exception {
        mySQLServiceCriteria = new MySQLServiceCriteria();
    }

    @Test
    public void testGetExpressionWithId() throws Exception {
        mySQLServiceCriteria.setId(String.valueOf(15));
        String expression = mySQLServiceCriteria.getExpression();
        assertTrue(" AND id=15".equals(expression));
    }

    @Test
    public void testGetExpressionWithoutParams() throws Exception {
        mySQLServiceCriteria = new MySQLServiceCriteria();
        String expression = mySQLServiceCriteria.getExpression();
        assertTrue(expression.isEmpty());
    }
}