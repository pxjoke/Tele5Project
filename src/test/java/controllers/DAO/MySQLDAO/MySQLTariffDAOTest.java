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

    @Before
    public void setUp() throws Exception {
        mySQLTariffDAO = new MySQLTariffDAO();
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
}