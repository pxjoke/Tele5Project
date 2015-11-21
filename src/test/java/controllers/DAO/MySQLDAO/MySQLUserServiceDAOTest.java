package controllers.DAO.MySQLDAO;


import controllers.DAO.beans.UserService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by pxjok on 14.11.2015.
 */
public class MySQLUserServiceDAOTest {
    private MySQLUserServiceDAO mySQLUserServiceDAO;
    UserService defaultUserService;

    @Before
    public void setUp() throws Exception {
        mySQLUserServiceDAO = new MySQLUserServiceDAO();
        defaultUserService = new UserService();
        defaultUserService.setUserId(1);
        defaultUserService.setServiceId(2);


    }

    @Test
    public void testGetById() throws Exception {
        UserService bean = mySQLUserServiceDAO.getById(2);
        UserService beanNull = mySQLUserServiceDAO.getById(0);
        assertNotNull(bean);
        System.out.println(bean);
        assertNull(beanNull);

    }

    @Test
    public void testGetAll() throws Exception {
        List<UserService> list = mySQLUserServiceDAO.getAll();
        for (UserService i : list) {
            System.out.println(i);
        }
        assertNotNull(list);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("Update expr: " + mySQLUserServiceDAO.getUpdateExpression(defaultUserService));
        UserService u = mySQLUserServiceDAO.getById(2);
        System.out.println("------Before Update--------");
        System.out.println(u);
        System.out.println("------After Update---------");
        boolean stat = mySQLUserServiceDAO.updateById(2, defaultUserService);
        assertTrue(stat);
        System.out.println(mySQLUserServiceDAO.getById(2));
        stat = mySQLUserServiceDAO.updateById(1, null);
        assertFalse(stat);
        System.out.println("---------------------------");
        mySQLUserServiceDAO.updateById(2, u);
    }

    @Test
    public void testInert() throws Exception {
        boolean status = mySQLUserServiceDAO.insert(defaultUserService);
        assertTrue(status);
        status = mySQLUserServiceDAO.insert(null);
        assertFalse(status);
        System.out.println("-------After Insertion----------");
        List<UserService> list = mySQLUserServiceDAO.getAll();
        for (UserService t : list) {
            System.out.println(t);
        }
        status = mySQLUserServiceDAO.deleteById(Integer.valueOf(list.get(list.size() - 1).getId()));

    }

    @Test
    public void testDeleteById() throws Exception {
        System.out.println("DELETE expr: " + mySQLUserServiceDAO.getDeleteExpression());
        mySQLUserServiceDAO.insert(defaultUserService);
        System.out.println("-------BEFORE DELETE----------");
        List<UserService> list = mySQLUserServiceDAO.getAll();
        for (UserService t : list) {
            System.out.println(t);
        }
        System.out.println("------------------------------");

        boolean status = mySQLUserServiceDAO.deleteById(Integer.valueOf(list.get(list.size() - 1).getId()));
        assertTrue(status);
        System.out.println("-------After DELETE----------");
        list = mySQLUserServiceDAO.getAll();
        for (UserService t : list) {
            System.out.println(t);
        }
        System.out.println("-----------------------------");
    }

    @Test
    public void testGetAllByUserId() throws Exception {

        List<UserService> list = mySQLUserServiceDAO.getAllByUserId(1);
        for (UserService t : list) {
            System.out.println(t);
        }

    }
}