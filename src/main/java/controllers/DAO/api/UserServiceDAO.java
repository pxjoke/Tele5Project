package controllers.DAO.api;

import controllers.DAO.beans.Account;
import controllers.DAO.beans.UserService;

import java.util.List;

/**
 * Created by pxjok on 11.11.2015.
 */
public interface UserServiceDAO extends DataAccessObject<UserService>{
    List<UserService> getAllByUserId(int id);
    boolean deleteByIdAndUserId(int id, int userId);
}
