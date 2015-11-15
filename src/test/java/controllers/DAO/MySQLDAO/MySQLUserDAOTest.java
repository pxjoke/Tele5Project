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
    private User defaultUser;

    @Before
    public void setUp() throws Exception {
        mySQLUserDAO = new MySQLUserDAO();
        defaultUser = new User();
        defaultUser.setPhone("+79811834377");
        defaultUser.setName("Агафья Платоновна");
        defaultUser.setPassword("agaf15");
        defaultUser.setStatus(1);
        defaultUser.setSms(104);
        defaultUser.setInternet(15);
        defaultUser.setRole("user");
        defaultUser.setMinutes(615);

    }

    @Test
    public void testInsertExp() throws Exception {
        System.out.println("Insert exp: " + mySQLUserDAO.getInsertExpression(defaultUser));
    }

    @Test
    public void testDeleteExp() throws Exception {
        System.out.println("DELETE exp: " + mySQLUserDAO.getDeleteExpression());
    }

    @Test
    public void testDeleteById() throws Exception {
        mySQLUserDAO.insert(defaultUser);
        System.out.println("-------BEFORE DELETE----------");
        List<User> serviceList = mySQLUserDAO.getAll();
        for(User user : serviceList){
            System.out.println(user);
        }
        System.out.println("------------------------------");

        boolean status = mySQLUserDAO.deleteById(Integer.valueOf(serviceList.get(serviceList.size() - 1).getId()));
        assertTrue(status);
        System.out.println("-------After DELETE----------");
        serviceList = mySQLUserDAO.getAll();
        for(User user : serviceList){
            System.out.println(user);
        }
        System.out.println("-----------------------------");
    }

    @Test
    public void testInert() throws Exception {
        boolean status = mySQLUserDAO.insert(defaultUser);
        assertTrue(status);
        status = mySQLUserDAO.insert(null);
        assertFalse(status);
        System.out.println("-------After Insertion----------");
        List<User> serviceList = mySQLUserDAO.getAll();
        for(User user : serviceList){
            System.out.println(user);
        }
        status = mySQLUserDAO.deleteById(Integer.valueOf(serviceList.get(serviceList.size() - 1).getId()));

    }

    @Test
    public void testUpdateById() throws Exception {
        System.out.println("Update expr: " + mySQLUserDAO.getUpdateExpression(defaultUser));
        User u = mySQLUserDAO.getById(1);
        System.out.println("------Before Update--------");
        System.out.println(u);
        System.out.println("------After Update---------");
        boolean stat = mySQLUserDAO.updateById(1, defaultUser);
        assertTrue(stat);
        System.out.println(mySQLUserDAO.getById(1));
        stat = mySQLUserDAO.updateById(1, null);
        assertFalse(stat);
        System.out.println("---------------------------");
        mySQLUserDAO.updateById(1, u);

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