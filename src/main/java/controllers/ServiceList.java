package controllers;

import controllers.DAO.MySQLDAO.MySQLDaoFactory;
import controllers.DAO.api.DAOFactory;
import controllers.DAO.api.ServiceDAO;
import controllers.DAO.api.TariffDAO;
import controllers.DAO.beans.Service;
import controllers.DAO.beans.Tariff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by pxjok on 18.11.2015.
 */
@WebServlet(name = "service_list", urlPatterns = "/service_list")
public class ServiceList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory factory = new MySQLDaoFactory();
        ServiceDAO serviceDAO = factory.getServiceDAO();
        List<Service> list = serviceDAO.getAll();
        request.setAttribute("services", list);
        request.getRequestDispatcher("/WEB-INF/jsp/service_list.jsp").forward(request, response);
    }
}
