package controllers.DAO.MySQLDAO;

import controllers.DAO.beans.Tariff;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by pxjok on 14.11.2015.
 */
public class MySQLTariffDAOTest {
    private MySQLTariffDAO mySQLTariffDAO;
    Tariff defaultTariff;
    @Before
    public void setUp() throws Exception {
        mySQLTariffDAO = new MySQLTariffDAO();
        defaultTariff = new Tariff();
        defaultTariff.setName("To Hacker Tariff");
        defaultTariff.setCount(0);
        defaultTariff.setUserStatus(1);
        defaultTariff.setMinutes(3.15);
        defaultTariff.setSms(0.15);
        defaultTariff.setInternet(4.12);
        defaultTariff.setServiceId(2);
    }

    @Test
    public void testGetById() throws Exception {
        Tariff tariff = mySQLTariffDAO.getById(1);
        Tariff tariffNull = mySQLTariffDAO.getById(0);
        assertNotNull(tariff);
        System.out.println(tariff);
        assertNull(tariffNull);

    }

    @Test
    public void testGetAll() throws Exception {
        List<Tariff> list = mySQLTariffDAO.getAll();
        for(Tariff i: list){
            System.out.println(i);
        }
        assertNotNull(list);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("Update expr: " + mySQLTariffDAO.getUpdateExpression(defaultTariff));
        Tariff u = mySQLTariffDAO.getById(1);
        System.out.println("------Before Update--------");
        System.out.println(u);
        System.out.println("------After Update---------");
        boolean stat = mySQLTariffDAO.updateById(1, defaultTariff);
        assertTrue(stat);
        System.out.println(mySQLTariffDAO.getById(1));
        stat = mySQLTariffDAO.updateById(1, null);
        assertFalse(stat);
        System.out.println("---------------------------");
        mySQLTariffDAO.updateById(1, u);
    }

    @Test
    public void testInert() throws Exception {
        boolean status = mySQLTariffDAO.insert(defaultTariff);
        assertTrue(status);
        status = mySQLTariffDAO.insert(null);
        assertFalse(status);
        System.out.println("-------After Insertion----------");
        List<Tariff> serviceList = mySQLTariffDAO.getAll();
        for(Tariff t : serviceList){
            System.out.println(t);
        }
        status = mySQLTariffDAO.deleteById(Integer.valueOf(serviceList.get(serviceList.size() - 1).getId()));

    }

    @Test
    public void testDeleteById() throws Exception {
        mySQLTariffDAO.insert(defaultTariff);
        System.out.println("-------BEFORE DELETE----------");
        List<Tariff> serviceList = mySQLTariffDAO.getAll();
        for(Tariff t : serviceList){
            System.out.println(t);
        }
        System.out.println("------------------------------");

        boolean status = mySQLTariffDAO.deleteById(Integer.valueOf(serviceList.get(serviceList.size() - 1).getId()));
        assertTrue(status);
        System.out.println("-------After DELETE----------");
        serviceList = mySQLTariffDAO.getAll();
        for(Tariff t : serviceList){
            System.out.println(t);
        }
        System.out.println("-----------------------------");
    }
}