package servlets;

import accounts.AccountService;
import accounts.UserProfile;
import com.google.gson.Gson;
import org.eclipse.jetty.server.session.JDBCSessionManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Илья on 08.03.2016.
 */
public class SessionServlet extends HttpServlet {
    private final AccountService accountService;

    public SessionServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    //get logged user
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String sessionID = request.getSession().getId();
        UserProfile profile = accountService.getUserBySessionId(sessionID);
        if (profile == null) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            Gson gson = new Gson();
            String json = gson.toJson(profile);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println(json);
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");

        if(login == null || pass == null){
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        UserProfile profile = accountService.getUserByLogin(login);
        if(profile == null || !profile.getPass().equals(pass)){
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        accountService.addSession(request.getSession().getId(), profile);
        Gson gson = new Gson();
        String json = gson.toJson(profile);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(json);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String sessionId = request.getSession().getId();
        UserProfile profile = accountService.getUserBySessionId(sessionId);
        if(profile == null){
            response.setContentType("text/html;charsert=utf-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }else{
            accountService.deleteSession(sessionId);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("GoodBye!");
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }
}
