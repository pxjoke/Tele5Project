package controllers.DAO.api;

import controllers.DAO.beans.User;

import java.util.List;

/**
 * Created by pxjok on 11.11.2015.
 */
public interface UserDAO extends DataAccessObject<User>{
    User getByPhone(String phone);

}
