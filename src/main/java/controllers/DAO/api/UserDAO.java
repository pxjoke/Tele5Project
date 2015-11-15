package controllers.DAO.api;

import controllers.DAO.beans.User;

import java.util.List;

/**
 * Created by pxjok on 11.11.2015.
 */
public interface UserDAO {
    User getById(int id);
    List<User> getAll();
    boolean insert(User bean);
    boolean deleteById(int id);
}
