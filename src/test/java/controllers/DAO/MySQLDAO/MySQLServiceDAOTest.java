package controllers.DAO.MySQLDAO;

import controllers.DAO.beans.Account;
import controllers.DAO.beans.Service;
import controllers.DAO.beans.Tariff;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by pxjok on 14.11.2015.
 */
public class MySQLServiceDAOTest {
    private MySQLServiceDAO mySQLServiceDAO;
    Service defaultService;
    @Before
    public void setUp() throws Exception {
        mySQLServiceDAO = new MySQLServiceDAO();
        defaultService = new Service();
        defaultService.setCost(315);
        defaultService.setName("First blood!");
        defaultService.setDescriprion("Very good!");

    }

    @Test
    public void testGetById() throws Exception {
        Service service = mySQLServiceDAO.getById(1);
        Service serviceNull = mySQLServiceDAO.getById(0);
        assertNotNull(service);
        System.out.println(service);
        assertNull(serviceNull);

    }

    @Test
    public void testGetAll() throws Exception {
        List<Service> list = mySQLServiceDAO.getAll();
        for(Service i: list){
            System.out.println(i);
        }
        assertNotNull(list);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("Update expr: " + mySQLServiceDAO.getUpdateExpression(defaultService));
        Service u = mySQLServiceDAO.getById(1);
        System.out.println("------Before Update--------");
        System.out.println(u);
        System.out.println("------After Update---------");
        boolean stat = mySQLServiceDAO.updateById(1, defaultService);
        assertTrue(stat);
        System.out.println(mySQLServiceDAO.getById(1));
        stat = mySQLServiceDAO.updateById(1, null);
        assertFalse(stat);
        System.out.println("---------------------------");
        mySQLServiceDAO.updateById(1, u);
    }

    @Test
    public void testInert() throws Exception {
        boolean status = mySQLServiceDAO.insert(defaultService);
        assertTrue(status);
        status = mySQLServiceDAO.insert(null);
        assertFalse(status);
        System.out.println("-------After Insertion----------");
        List<Service> list = mySQLServiceDAO.getAll();
        for(Service t : list){
            System.out.println(t);
        }
        status = mySQLServiceDAO.deleteById(Integer.valueOf(list.get(list.size() - 1).getId()));

    }

    @Test
    public void testDeleteById() throws Exception {
        mySQLServiceDAO.insert(defaultService);
        System.out.println("-------BEFORE DELETE----------");
        List<Service> list = mySQLServiceDAO.getAll();
        for(Service t : list){
            System.out.println(t);
        }
        System.out.println("------------------------------");

        boolean status = mySQLServiceDAO.deleteById(Integer.valueOf(list.get(list.size() - 1).getId()));
        assertTrue(status);
        System.out.println("-------After DELETE----------");
        list = mySQLServiceDAO.getAll();
        for(Service t : list){
            System.out.println(t);
        }
        System.out.println("-----------------------------");
    }
}