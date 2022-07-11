package View;

import javax.swing.*;
import java.awt.*;

public class MainMenu {
    public MainMenu() {
        JFrame frame = new JFrame("Main Menu");
        JPanel panel = new JPanel();
        JButton login = new JButton("Login Pengguna");
        login.setMaximumSize(new Dimension(200, 30));
        JButton reg = new JButton("Registrasi Pengguna Baru");
        reg.setMaximumSize(new Dimension(200, 30));
        JButton lihat = new JButton("Lihat Data Pengguna Berdasarkan Kategori Dipilih");
        lihat.setMaximumSize(new Dimension(200, 30));
        JButton exit = new JButton("Exit");
        exit.setMaximumSize(new Dimension(200, 30));
        exit.addActionListener(e -> System.exit(0));
        login.addActionListener(e -> {
            frame.dispose();
            new MenuLogin();
        });
        reg.addActionListener(e -> {
            frame.dispose();
            new MenuRegistrasi();
        });
        lihat.addActionListener(e -> {
            frame.dispose();
            new MenuLihatPengguna();
        });
        panel.add(login);
        panel.add(reg);
        panel.add(lihat);
        panel.add(exit);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(panel);
        frame.pack();
    }
}
