package controllers;

import controllers.DAO.api.DAOFactory;
import controllers.DAO.MySQLDAO.MySQLDaoFactory;
import controllers.DAO.api.ServiceDAO;
import controllers.DAO.api.criteria.ServiceCriteria;
import controllers.DAO.beans.Service;
import controllers.DAO.beans.Tariff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by pxjok on 10.11.2015.
 */
@WebServlet(name = "catalog", urlPatterns = "/catalog")
public class Catalog extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServiceCriteria serviceCriteria = Connections.getFactory().getServiceCriteria();
        serviceCriteria.setType("tariff");
        ServiceDAO serviceDAO = Connections.getFactory().getServiceDAO();
        List<Service> tariffs = serviceDAO.getListByCriteria(serviceCriteria);

        serviceCriteria = Connections.getFactory().getServiceCriteria();
        serviceCriteria.setType("passive");
        List<Service> passive = serviceDAO.getListByCriteria(serviceCriteria);

        serviceCriteria = Connections.getFactory().getServiceCriteria();
        serviceCriteria.setType("package");
        List<Service> packages = serviceDAO.getListByCriteria(serviceCriteria);


        request.setAttribute("tariffs", tariffs);
        request.setAttribute("passive", passive);
        request.setAttribute("packages", packages);
        request.getRequestDispatcher("/WEB-INF/jsp/catalog.jsp").forward(request, response);
    }
}
