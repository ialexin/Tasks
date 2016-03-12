package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Илья on 08.03.2016.
 */
public class UserServlet extends HttpServlet{
    private final AccountService accountService;

    public UserServlet(AccountService accService) {
        accountService = accService;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserProfile user = accountService.getUserByLogin(login);
        if(user != null){
            if(password.equals(user.getPass())){
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().println("Authorized: " + user.getLogin());
            }
            else {
                response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
                response.getWriter().println("Password is wrong");
            }
        }
        else{
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().println("Unathorized");
        }

    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

    }
}
