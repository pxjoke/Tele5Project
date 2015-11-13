package controllers.DAO.criteria;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pxjok on 13.11.2015.
 */
public class MySQLUserCriteriaTest {

    private MySQLUserCriteria mySQLUserCriteria;

    @Before
    public void setUp() throws Exception {
        mySQLUserCriteria = new MySQLUserCriteria();
    }


    @Test
    public void testGetExpressionWithId() throws Exception {
       // MySQLUserCriteria mySQLUserCriteria = new MySQLUserCriteria();
        mySQLUserCriteria.setId(String.valueOf(15));
        String expression = mySQLUserCriteria.getExpression();
        Assert.assertTrue(" AND id=15".equals(expression));
    }

    @Test
    public void testGetExpressionWithoutId() throws Exception {
        mySQLUserCriteria.setId(null);
        String expression = mySQLUserCriteria.getExpression();
        Assert.assertTrue(expression.isEmpty());
    }
}