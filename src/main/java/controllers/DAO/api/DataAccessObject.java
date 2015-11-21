package controllers.DAO.api;

import controllers.DAO.api.criteria.Criteria;

import java.util.List;

/**
 * Created by pxjok on 18.11.2015.
 */
public interface DataAccessObject<T> {
    List<T> getAll();
    T getById(int id);
    boolean insert(T bean);
    boolean deleteById(int id);
    boolean updateById(int id, T bean);
    List<T> getListByCriteria(Criteria criteria);
}
