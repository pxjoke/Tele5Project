package controllers.admin;

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
 * Created by pxjok on 18.11.2015.
 */
@WebServlet(name = "service_info", urlPatterns = "/admin/service_info")
public class ServiceInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id") == null){
            response.sendError(400);
            return;
        }
        int id = Integer.valueOf(request.getParameter("id"));

        DAOFactory factory = new MySQLDaoFactory();
        ServiceDAO serviceDAO = factory.getServiceDAO();
        Service service = serviceDAO.getById(id);
        if(service == null){
            response.sendError(400);
            return;
        }
        request.setAttribute("service", service);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/service_info.jsp").forward(request, response);
    }
}
