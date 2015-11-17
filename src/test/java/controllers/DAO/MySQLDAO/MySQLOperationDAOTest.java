package controllers.DAO.MySQLDAO;


import controllers.DAO.beans.Operation;
import controllers.DAO.beans.UserService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by pxjok on 14.11.2015.
 */
public class MySQLOperationDAOTest {
    private MySQLOperationDAO mySQLOperationDAO;
    Operation defaultOperation;
    @Before
    public void setUp() throws Exception {
        mySQLOperationDAO = new MySQLOperationDAO();
        defaultOperation = new Operation();
        defaultOperation.setAccountId(1);
        defaultOperation.setServiceId(1);
        defaultOperation.setAmount(1);
        defaultOperation.setCost(789.016);
        defaultOperation.setTime("2015-11-18 01:40:55");
        defaultOperation.setType("service");



    }

    @Test
    public void testGetById() throws Exception {
        Operation bean = mySQLOperationDAO.getById(1);
        Operation beanNull = mySQLOperationDAO.getById(0);
        assertNotNull(bean);
        System.out.println(bean);
        assertNull(beanNull);

    }

    @Test
    public void testGetAll() throws Exception {
        List<Operation> list = mySQLOperationDAO.getAll();
        for(Operation i: list){
            System.out.println(i);
        }
        assertNotNull(list);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("Update expr: " + mySQLOperationDAO.getUpdateExpression(defaultOperation));
        Operation u = mySQLOperationDAO.getById(1);
        System.out.println("------Before Update--------");
        System.out.println(u);
        System.out.println("------After Update---------");
        boolean stat = mySQLOperationDAO.updateById(1, defaultOperation);
        assertTrue(stat);
        System.out.println(mySQLOperationDAO.getById(1));
        stat = mySQLOperationDAO.updateById(1, null);
        assertFalse(stat);
        System.out.println("---------------------------");
        mySQLOperationDAO.updateById(1, u);
    }

    @Test
    public void testInert() throws Exception {
        boolean status = mySQLOperationDAO.insert(defaultOperation);
        assertTrue(status);
        status = mySQLOperationDAO.insert(null);
        assertFalse(status);
        System.out.println("-------After Insertion----------");
        List<Operation> list = mySQLOperationDAO.getAll();
        for(Operation t : list){
            System.out.println(t);
        }
        status = mySQLOperationDAO.deleteById(Integer.valueOf(list.get(list.size() - 1).getId()));

    }

    @Test
    public void testDeleteById() throws Exception {
        mySQLOperationDAO.insert(defaultOperation);
        System.out.println("-------BEFORE DELETE----------");
        List<Operation> list = mySQLOperationDAO.getAll();
        for(Operation t : list){
            System.out.println(t);
        }
        System.out.println("------------------------------");

        boolean status = mySQLOperationDAO.deleteById(Integer.valueOf(list.get(list.size() - 1).getId()));
        assertTrue(status);
        System.out.println("-------After DELETE----------");
        list = mySQLOperationDAO.getAll();
        for(Operation t : list){
            System.out.println(t);
        }
        System.out.println("-----------------------------");
    }
}