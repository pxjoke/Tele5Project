package controllers.DAO.api;

import controllers.DAO.beans.Service;

import java.util.List;

/**
 * Created by pxjok on 12.11.2015.
 */
public interface ServiceDAO {
    List<Service> getAll();
    Service getById(int id);
    boolean insert(Service bean);
    boolean deleteById(int id);
    boolean updateById(int id, Service bean);
}
