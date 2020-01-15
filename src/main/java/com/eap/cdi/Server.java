package com.eap.cdi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/server")
public class Server extends HttpServlet{

    private static final long serialVersionUID = 1301302342020075563L;
    @Inject
    InjectService injectService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        PrintWriter pw = resp.getWriter();
        pw.println("Server return from: " + req.getServerName() + ":" + req.getServerPort());
        pw.println(" ### " + injectService.injectMethod());
    }

}
