package controllers.admin;

import controllers.Connections;
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

        if(name.isEmpty() || minutes.isEmpty() || sms.isEmpty() || internet.isEmpty() || user_status.isEmpty()||
                cost.isEmpty() || serviceId.isEmpty() || tariffId.isEmpty()){
            response.sendRedirect("/validation_error.jsp");
            return;
        }

        Tariff tariff = new Tariff();
        tariff.setName(name);
        try {
            tariff.setMinutes(Double.valueOf(minutes));
            tariff.setSms(Double.valueOf(sms));
            tariff.setInternet(Double.valueOf(internet));
            tariff.setUserStatus(Integer.valueOf(user_status));
            tariff.setServiceId(Integer.valueOf(serviceId));
        } catch (NumberFormatException e) {
            response.sendRedirect("/validation_error.jsp");
            return;
        }

        Service service = new Service();
        service.setType("tariff");
        service.setDescription(description);
        service.setName(name);

        try {
            service.setCost(Double.valueOf(cost));
        } catch (NumberFormatException e) {
            response.sendRedirect("/validation_error.jsp");
            return;
        }


        Connections.getFactory().getServiceDAO().updateById(Integer.valueOf(serviceId), service);
        Connections.getFactory().getTariffDao().updateById(Integer.valueOf(tariffId), tariff);
        response.sendRedirect("/admin/tariff_list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id;
        if((id = controllers.helpers.Utils.idParamCheck(request, response)) < 0) return;


        Tariff tariff = Connections.getFactory().getTariffDao().getById(id);

        if (tariff == null) {
            response.sendRedirect("/no_such_element.jsp");
            return;
        }

        Service service = Connections.getFactory().getServiceDAO().getById(tariff.getServiceId());

        request.setAttribute("service", service);
        request.setAttribute("tariff", tariff);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/tariff_edit.jsp").forward(request, response);
    }
}
