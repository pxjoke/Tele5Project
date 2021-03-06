package controllers.admin;

import controllers.Connections;
import controllers.DAO.MySQLDAO.MySQLDaoFactory;
import controllers.DAO.MySQLDAO.MySQLTariffDAO;
import controllers.DAO.api.DAOFactory;
import controllers.DAO.api.TariffDAO;
import controllers.DAO.beans.Tariff;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by pxjok on 18.11.2015.
 */
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin", "manager"}))
@WebServlet(name = "tariff_list", urlPatterns = "/admin/tariff_list")
public class TariffList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Tariff> list = Connections.getFactory().getTariffDao().getAll();
        request.setAttribute("tariffs", list);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/tariff_list.jsp").forward(request, response);
    }
}
