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

/**
 * Created by pxjok on 15.11.2015.
 */
@WebServlet(name = "service_edit", urlPatterns = "/service_edit")
public class ServiceEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String minutes = request.getParameter("minutes");
        String sms = request.getParameter("sms");
        String internet = request.getParameter("internet");
        String cost = request.getParameter("cost");
        String description = request.getParameter("description");
        String serviceId = request.getParameter("serviceId");


        Service service = new Service();
        service.setType("tariff");
        service.setDescription(description);
        service.setName(name);
        service.setCost(Double.valueOf(cost));
        service.setMinutes(Integer.valueOf(minutes));
        service.setInternet(Integer.valueOf(internet));
        service.setSms(Integer.valueOf(sms));


        DAOFactory factory = new MySQLDaoFactory();
        ServiceDAO  serviceDAO = factory.getServiceDAO();
        serviceDAO.updateById(Integer.valueOf(serviceId), service);

        response.sendRedirect("/service_list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") == null) {
            response.sendError(400);
            return;
        }

        int id = Integer.valueOf(request.getParameter("id"));

        DAOFactory factory = new MySQLDaoFactory();
        ServiceDAO serviceDAO = factory.getServiceDAO();
        Service service = serviceDAO.getById(id);

        if (service == null) {
            response.sendError(400);
            return;
        }


        request.setAttribute("service", service);
        request.getRequestDispatcher("/WEB-INF/jsp/service_edit.jsp").forward(request, response);
    }
}