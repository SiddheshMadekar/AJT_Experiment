
package com.ss;

import java.io.IOException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().println(
            "<h2>Email Servlet is Running Successfully!</h2>"
        );
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");

        // Gmail SMTP configuration
        String from = "your email";
        String password = "XXXX XXXX XXXX";

        String host = "smtp.gmail.com";

        Properties properties = new Properties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Gmail authentication
        Session session = Session.getInstance(
            properties,
            new Authenticator() {
                protected PasswordAuthentication
                getPasswordAuthentication() {

                    return new PasswordAuthentication(
                        from, password
                    );
                }
            }
        );

        try {

            Message email = new MimeMessage(session);

            email.setFrom(new InternetAddress(from));

            email.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(to)
            );

            email.setSubject(subject);

            email.setText(message);

            // Send email
            Transport.send(email);

            response.getWriter().println(
                "<h2>Email Sent Successfully!</h2>"
            );

        } catch (MessagingException e) {

            e.printStackTrace();

            response.getWriter().println(
                "<h2>Email Sending Failed!</h2>"
            );

            response.getWriter().println(
                "<p>" + e.getMessage() + "</p>"
            );
        }
    }
}
