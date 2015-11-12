package controllers.DAO;

import controllers.DAO.beans.User;

import java.util.List;

/**
 * Created by pxjok on 11.11.2015.
 */
public interface UserDAO {
    User getById(int id);
    List<User> getAll();
}
