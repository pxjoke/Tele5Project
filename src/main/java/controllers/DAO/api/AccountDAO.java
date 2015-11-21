package controllers.DAO.api;

import controllers.DAO.beans.Account;
import controllers.DAO.beans.User;

import java.util.List;

/**
 * Created by pxjok on 11.11.2015.
 */
public interface AccountDAO extends DataAccessObject<Account>{
    Account getCurrent(int userId);
}
