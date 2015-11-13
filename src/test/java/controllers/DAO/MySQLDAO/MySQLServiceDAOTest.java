package controllers.DAO.MySQLDAO;

import controllers.DAO.api.DAOFactory;
import controllers.DAO.api.ServiceDAO;
import controllers.DAO.beans.Service;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by pxjok on 13.11.2015.
 */
public class MySQLServiceDAOTest {
    private ServiceDAO serviceDAO;

    @Before
    public void setUp() throws Exception {
        serviceDAO = new MySQLServiceDAO();
    }

    @Test
    public void testGetAll() throws Exception {
        List<Service> serviceList = serviceDAO.getAll();
        for(Service service: serviceList){
            System.out.println(service);
        }
        assertNotNull(serviceList);
        assertFalse(serviceList.isEmpty());
    }

    @Test
    public void testGetColumns() throws Exception {

    }

    @Test
    public void testGetTable() throws Exception {

    }

    @Test
    public void testParseResultSet() throws Exception {

    }
}