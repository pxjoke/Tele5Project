package controllers.DAO.api;

import controllers.DAO.beans.Account;
import controllers.DAO.beans.User;

import java.util.List;

/**
 * Created by pxjok on 11.11.2015.
 */
public interface AccountDAO {
    Account getById(int id);
    List<Account> getAll();
    boolean insert(Account bean);
    boolean deleteById(int id);
    boolean updateById(int id, Account bean);
}
