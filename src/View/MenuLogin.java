package View;

import Controller.Login;
import Model.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class MenuLogin {
    public MenuLogin() {
        JFrame frame = new JFrame("Menu Login");
        JPanel panel = new JPanel();
        JPanel panelImage = new JPanel();
        JPanel panelForm = new JPanel();
        JPanel panelButton = new JPanel();
        BufferedImage img;
        try {
            img = ImageIO.read(new URL("https://www.sketchappsources.com/resources/source-image/google-g-logo.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JLabel picLabel = new JLabel(new ImageIcon(img));

        JTextField inputEmail = new JFormattedTextField();
        JLabel labelEmail = new JLabel("E-Mail:");
        inputEmail.setPreferredSize(new Dimension(200, 25));

        JTextField password = new JFormattedTextField();
        JLabel labelPassword = new JLabel("Password:");
        password.setPreferredSize(new Dimension(200, 25));

        JButton login = new JButton("Login");
        login.addActionListener(e -> {
            User loggedInUser = Login.loginUser(inputEmail.getText(), password.getText());
            if (loggedInUser == null) {
                JOptionPane.showMessageDialog(null, "Gagal Login!");
            } else {
                JOptionPane.showMessageDialog(null, "Berhasil Login!");
                new MainMenu();
                frame.dispose();
            }
        });
        JButton back = new JButton("Back");
        back.addActionListener(e -> {
            new MainMenu();
            frame.dispose();
        });
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panelImage.add(picLabel);
        panelForm.add(labelEmail);
        panelForm.add(inputEmail);
        panelForm.add(labelPassword);
        panelForm.add(password);
        panelButton.add(login);
        panelButton.add(back);
        panel.add(panelImage);
        panel.add(panelForm);
        panel.add(panelButton);
        frame.setVisible(true);
        frame.add(panel);
        frame.pack();
    }
}
