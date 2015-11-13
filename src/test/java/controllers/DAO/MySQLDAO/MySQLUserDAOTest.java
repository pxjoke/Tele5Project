package controllers.DAO.MySQLDAO;

import controllers.DAO.beans.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by pxjok on 13.11.2015.
 */
public class MySQLUserDAOTest {

    private MySQLUserDAO mySQLUserDAO;

    @Before
    public void setUp() throws Exception {
        mySQLUserDAO = new MySQLUserDAO();
    }

    @Test
    public void testGetById() throws Exception {
        User user = mySQLUserDAO.getById(1);
        User userNull = mySQLUserDAO.getById(0);
        System.out.println(user);
        assertNotNull(user);
        assertNull(userNull);
    }

    @Test
    public void testGetAll() throws Exception {
        List<User> serviceList = mySQLUserDAO.getAll();
        for(User user : serviceList){
            System.out.println(user);
        }
        assertNotNull(serviceList);
        assertFalse(serviceList.isEmpty());
    }
}