package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EducationServlet")
public class EducationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public EducationServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String degree = request.getParameter("degree");
        String university = request.getParameter("university");

        HttpSession session = request.getSession();

        session.setAttribute("degree", degree);
        session.setAttribute("university", university);

        String name = (String) session.getAttribute("name");
        String age = (String) session.getAttribute("age");
        String email = (String) session.getAttribute("email");
        String phone = (String) session.getAttribute("phone");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>All Personal Details</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h2>All Personal Details</h2>");

        out.println("<p><b>Name:</b> " + name + "</p>");
        out.println("<p><b>Age:</b> " + age + "</p>");
        out.println("<p><b>Email:</b> " + email + "</p>");
        out.println("<p><b>Phone:</b> " + phone + "</p>");
        out.println("<p><b>Degree:</b> " + degree + "</p>");
        out.println("<p><b>University:</b> " + university + "</p>");

        out.println("</body>");
        out.println("</html>");
    }
}