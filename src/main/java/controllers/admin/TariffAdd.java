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
 * Created by pxjok on 09.11.2015.
 */
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin"}))
@WebServlet(name = "tariff_add", urlPatterns = "/admin/tariff_add")
public class TariffAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String minutes = request.getParameter("minutes");
        String sms = request.getParameter("sms");
        String internet = request.getParameter("internet");
        String user_status = request.getParameter("user_status");
        String cost = request.getParameter("cost");
        String description = request.getParameter("description");
        Tariff tariff = new Tariff();
        tariff.setName(name);
        tariff.setMinutes(Double.valueOf(minutes));
        tariff.setSms(Double.valueOf(sms));
        tariff.setInternet(Double.valueOf(internet));
        tariff.setUserStatus(Integer.valueOf(user_status));

        Service service = new Service();
        service.setType("tariff");
        service.setDescription(description);
        service.setName(name);
        service.setCost(Double.valueOf(cost));


        DAOFactory factory = new MySQLDaoFactory();
        ServiceDAO  serviceDAO = factory.getServiceDAO();
        serviceDAO.insert(service);
        service = serviceDAO.getByName(name);

        tariff.setServiceId(service.getId());
        TariffDAO tariffDAO = factory.getTariffDao();
        tariffDAO.insert(tariff);
        response.sendRedirect("/tariff_list");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/tariff_add.jsp").forward(request, response);
    }
}
