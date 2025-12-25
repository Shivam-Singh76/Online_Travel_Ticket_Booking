package com.travel.servlet;

import com.travel.db.DBConnection;
import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class BookingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        int userId = (int) session.getAttribute("userId");

        String source = req.getParameter("source");
        String destination = req.getParameter("destination");
        String date = req.getParameter("date");
        int seats = Integer.parseInt(req.getParameter("seats"));

        double price = seats * 500;

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO bookings(user_id, source, destination, date_of_journey, seats, price) VALUES (?,?,?,?,?,?)"
            );

            ps.setInt(1, userId);
            ps.setString(2, source);
            ps.setString(3, destination);
            ps.setString(4, date);
            ps.setInt(5, seats);
            ps.setDouble(6, price);

            ps.executeUpdate();

            req.setAttribute("amount", price);
            RequestDispatcher rd = req.getRequestDispatcher("success.jsp");
            rd.forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
