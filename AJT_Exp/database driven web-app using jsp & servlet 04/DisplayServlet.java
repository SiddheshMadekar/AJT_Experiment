
package com.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        out.println("<html><body>");
        out.println("<h2>Registered Students</h2>");
        out.println("<table border='1' cellpadding='8'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Course</th></tr>");

        try {
            if (user == null || user.isEmpty() || password == null || password.isEmpty()) {
                throw new IllegalStateException("Set the DB_USER and DB_PASSWORD environment variables.");
            }

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                DriverManager.getConnection(url, user, password);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("course") + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("<br><a href='Register.jsp'>Back to Registration</a>");

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }

        out.println("</body></html>");
    }
}
