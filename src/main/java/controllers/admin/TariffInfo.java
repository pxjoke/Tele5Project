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
import java.util.List;

/**
 * Created by pxjok on 18.11.2015.
 */
@WebServlet(name = "tariff_info", urlPatterns = "/admin/tariff_info")
public class TariffInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id") == null){
            response.sendError(400);
            return;
        }
        int id = Integer.valueOf(request.getParameter("id"));

        Tariff tariff =  Connections.getFactory().getTariffDao().getById(id);

        if(tariff == null){
            response.sendError(400);
            return;
        }

        Service service = Connections.getFactory().getServiceDAO().getById(tariff.getServiceId());
        request.setAttribute("tariff", tariff);
        request.setAttribute("service", service);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/tariff_info.jsp").forward(request, response);
    }
}
