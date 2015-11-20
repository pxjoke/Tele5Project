package controllers.admin;

import controllers.DAO.MySQLDAO.MySQLDaoFactory;
import controllers.DAO.api.DAOFactory;
import controllers.DAO.api.ServiceDAO;
import controllers.DAO.api.TariffDAO;
import controllers.DAO.beans.Service;
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
@WebServlet(name = "tariff_edit", urlPatterns = "/admin/tariff_edit")
public class TariffEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String minutes = request.getParameter("minutes");
        String sms = request.getParameter("sms");
        String internet = request.getParameter("internet");
        String user_status = request.getParameter("user_status");
        String cost = request.getParameter("cost");
        String description = request.getParameter("description");
        String serviceId = request.getParameter("serviceId");
        String tariffId = request.getParameter("tariffId");



        Tariff tariff = new Tariff();
        tariff.setName(name);
        tariff.setMinutes(Double.valueOf(minutes));
        tariff.setSms(Double.valueOf(sms));
        tariff.setInternet(Double.valueOf(internet));
        tariff.setUserStatus(Integer.valueOf(user_status));
        tariff.setServiceId(Integer.valueOf(serviceId));

        Service service = new Service();
        service.setType("tariff");
        service.setDescription(description);
        service.setName(name);
        service.setCost(Double.valueOf(cost));


        DAOFactory factory = new MySQLDaoFactory();
        ServiceDAO  serviceDAO = factory.getServiceDAO();
        serviceDAO.updateById(Integer.valueOf(serviceId), service);

        TariffDAO tariffDAO = factory.getTariffDao();
        tariffDAO.updateById(Integer.valueOf(tariffId), tariff);
        response.sendRedirect("/tariff_list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") == null) {
            response.sendError(400);
            return;
        }

        int id = Integer.valueOf(request.getParameter("id"));

        DAOFactory factory = new MySQLDaoFactory();
        TariffDAO tariffDAO = factory.getTariffDao();
        Tariff tariff = tariffDAO.getById(id);

        if (tariff == null) {
            response.sendError(400);
            return;
        }
        ServiceDAO serviceDAO = factory.getServiceDAO();
        Service service = serviceDAO.getById(tariff.getServiceId());

        request.setAttribute("service", service);
        request.setAttribute("tariff", tariff);
        request.getRequestDispatcher("/WEB-INF/jsp/tariff_edit.jsp").forward(request, response);
    }
}
