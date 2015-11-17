package controllers.DAO.api;

import controllers.DAO.beans.Service;
import controllers.DAO.beans.Tariff;
import controllers.DAO.beans.User;

import java.util.List;

/**
 * Created by pxjok on 14.11.2015.
 */
public interface TariffDAO {
    List<Tariff> getAll();
    Tariff getById(int id);
    boolean insert(Tariff bean);
    boolean deleteById(int id);
    boolean updateById(int id, Tariff bean);
}
