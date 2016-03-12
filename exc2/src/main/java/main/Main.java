package main;

import accounts.AccountService;
import accounts.UserProfile;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import servlets.SessionServlet;
import servlets.SignUpServlet;
import servlets.UserServlet;

/**
 * Created by Илья on 08.03.2016.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        AccountService accountService = new AccountService();

        accountService.addNewUser(new UserProfile("admin"));
        accountService.addNewUser(new UserProfile("test"));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        //context.addServlet(new ServletHolder(new UserServlet(accountService)), "/api/v1/users");
        context.addServlet(new ServletHolder(new SessionServlet(accountService)), "/api/v1/sessions");
        context.addServlet(new ServletHolder(new SignUpServlet(accountService)),"/signup");
        context.addServlet(new ServletHolder(new UserServlet(accountService)),"/signin");


        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});

        Server server = new Server(8080);
        server.setHandler(handlers);

        server.start();
        System.out.println("Server started");
        server.join();
    }
}