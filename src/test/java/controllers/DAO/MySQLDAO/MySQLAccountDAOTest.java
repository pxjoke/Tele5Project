package controllers.DAO.MySQLDAO;

import controllers.DAO.beans.Account;
import controllers.DAO.beans.Tariff;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by pxjok on 14.11.2015.
 */
public class MySQLAccountDAOTest {
    private MySQLAccountDAO mySQLAccountDAO;
    Account defaultAccount;
    @Before
    public void setUp() throws Exception {
        mySQLAccountDAO = new MySQLAccountDAO();
        defaultAccount = new Account();
        defaultAccount.setUserId(2);
        defaultAccount.setOpenDate("2015-11-05");
        defaultAccount.setCloseDate("2015-11-06");
        defaultAccount.setClosed(true);

    }

    @Test
    public void testGetById() throws Exception {
        Account account = mySQLAccountDAO.getById(1);
        Account accountNull = mySQLAccountDAO.getById(0);
        assertNotNull(account);
        System.out.println(account);
        assertNull(accountNull);

    }

    @Test
    public void testGetAll() throws Exception {
        List<Account> list = mySQLAccountDAO.getAll();
        for(Account i: list){
            System.out.println(i);
        }
        assertNotNull(list);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("Update expr: " + mySQLAccountDAO.getUpdateExpression(defaultAccount));
        Account u = mySQLAccountDAO.getById(1);
        System.out.println("------Before Update--------");
        System.out.println(u);
        System.out.println("------After Update---------");
        boolean stat = mySQLAccountDAO.updateById(1, defaultAccount);
        assertTrue(stat);
        System.out.println(mySQLAccountDAO.getById(1));
        stat = mySQLAccountDAO.updateById(1, null);
        assertFalse(stat);
        System.out.println("---------------------------");
        mySQLAccountDAO.updateById(1, u);
    }

    @Test
    public void testInert() throws Exception {
        boolean status = mySQLAccountDAO.insert(defaultAccount);
        assertTrue(status);
        status = mySQLAccountDAO.insert(null);
        assertFalse(status);
        System.out.println("-------After Insertion----------");
        List<Account> list = mySQLAccountDAO.getAll();
        for(Account t : list){
            System.out.println(t);
        }
        status = mySQLAccountDAO.deleteById(Integer.valueOf(list.get(list.size() - 1).getId()));

    }

    @Test
    public void testDeleteById() throws Exception {
        mySQLAccountDAO.insert(defaultAccount);
        System.out.println("-------BEFORE DELETE----------");
        List<Account> list = mySQLAccountDAO.getAll();
        for(Account t : list){
            System.out.println(t);
        }
        System.out.println("------------------------------");

        boolean status = mySQLAccountDAO.deleteById(Integer.valueOf(list.get(list.size() - 1).getId()));
        assertTrue(status);
        System.out.println("-------After DELETE----------");
        list = mySQLAccountDAO.getAll();
        for(Account t : list){
            System.out.println(t);
        }
        System.out.println("-----------------------------");
    }
}