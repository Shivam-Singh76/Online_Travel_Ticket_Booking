package com.travel.gui;

import javax.swing.*;
import java.awt.*;

public class BookingGUI extends JFrame {

    public BookingGUI() {
        setTitle("Online Travel Ticket Booking");
        setSize(400, 350);
        setLayout(new GridLayout(6, 2));

        JTextField src = new JTextField();
        JTextField dest = new JTextField();
        JTextField date = new JTextField();
        JTextField seats = new JTextField();

        JButton btn = new JButton("Book Ticket");

        add(new JLabel("Source:"));
        add(src);
        add(new JLabel("Destination:"));
        add(dest);
        add(new JLabel("Date (YYYY-MM-DD):"));
        add(date);
        add(new JLabel("Seats:"));
        add(seats);
        add(btn);

        btn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Use Web App to Complete Booking",
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new BookingGUI();
    }
}
