package com.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PersonalServlet")
public class PersonalServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public PersonalServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String age = request.getParameter("age");

        HttpSession session = request.getSession();

        session.setAttribute("name", name);
        session.setAttribute("age", age);

        response.sendRedirect("contact.html");
    }
}