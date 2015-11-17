package controllers.DAO.api;

import controllers.DAO.beans.Account;
import controllers.DAO.beans.UserService;

import java.util.List;

/**
 * Created by pxjok on 11.11.2015.
 */
public interface UserServicesDAO {
    UserService getById(int id);
    List<UserService> getAll();
    boolean insert(UserService bean);
    boolean deleteById(int id);
    boolean updateById(int id, UserService bean);
}
