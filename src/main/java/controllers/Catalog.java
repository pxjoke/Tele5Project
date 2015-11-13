package controllers;

import controllers.DAO.api.DAOFactory;
import controllers.DAO.MySQLDAO.MySQLDaoFactory;
import controllers.DAO.api.ServiceDAO;
import controllers.DAO.beans.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by pxjok on 10.11.2015.
 */
@WebServlet(name = "catalog", urlPatterns = "/catalog")
public class Catalog extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory factory = new MySQLDaoFactory();
        ServiceDAO serviceDAO = factory.getServiceDAO();
        List<Service> services = serviceDAO.getAll();
        request.setAttribute("services", services);
        request.getRequestDispatcher("/WEB-INF/jsp/catalog.jsp").forward(request, response);
    }
}
