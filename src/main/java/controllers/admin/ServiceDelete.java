package controllers.admin;

import controllers.DAO.MySQLDAO.MySQLDaoFactory;
import controllers.DAO.api.DAOFactory;
import controllers.DAO.api.ServiceDAO;
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

/**
 * Created by pxjok on 15.11.2015.
 */
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin"}))
@WebServlet(name = "service_delete", urlPatterns = "/admin/service_delete")
public class ServiceDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("id") == null) {
            response.sendError(400);
            return;
        }
        int id = Integer.valueOf(request.getParameter("id"));

        DAOFactory factory = new MySQLDaoFactory();
        ServiceDAO serviceDAO = factory.getServiceDAO();

        serviceDAO.deleteById(id);

        response.sendRedirect("/service_list");
    }
}
