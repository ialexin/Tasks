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
public class SignUpServlet extends HttpServlet{
    private final AccountService accountService;

    public SignUpServlet(AccountService accountService){
          this.accountService = accountService;
    }

    /*public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        if(login == null || pass == null){
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }*/

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if(login == null || password == null){
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Bad Request. Try again");
            return;
        }

        if(accountService.getUserByLogin(login) != null){
            response.getWriter().println("User with this login has already registred");
        }

        UserProfile userProf = new UserProfile(login, password);
        accountService.addNewUser(userProf);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("Congratulations! Welcome to web-site, " + accountService.getUserByLogin(login).toString());
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
