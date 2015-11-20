package controllers;

import com.sun.deploy.net.HttpRequest;
import controllers.DAO.beans.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by pxjok on 20.11.2015.
 */
@WebFilter(filterName = "security_filter", servletNames = "j_security_check")
public class SecurityFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        User user =Connections.getFactory().getUserDAO().getByPhone(request.getUserPrincipal().getName());
        session.setAttribute("user", user);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }


}
