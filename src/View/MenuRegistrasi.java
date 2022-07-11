package View;

import Controller.GetCategories;
import Controller.Registrasi;
import Model.User;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MenuRegistrasi {
    public MenuRegistrasi() {
        User userBaru = new User();
        JFrame frame = new JFrame("Menu Registrasi");
        JPanel panelContainer = new JPanel();
        JPanel panel = new JPanel();
        JPanel buttonPanel = new JPanel();

        JTextField email = new JFormattedTextField();
        JLabel labelEmail = new JLabel("E-Mail:");
        email.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                userBaru.setEmail(email.getText());
            }
        });

        JTextField nama = new JFormattedTextField();
        JLabel labelNama = new JLabel("Nama:");
        nama.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                userBaru.setNama(nama.getText());
            }
        });

        JPasswordField password = new JPasswordField();
        JLabel labelPass = new JLabel("Password:");
        password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                userBaru.setPassword(String.valueOf(password.getPassword()));
            }
        });

        JFileChooser photo = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        JLabel labelFoto = new JLabel("Photo");
        photo.addActionListener(e -> userBaru.setPhoto(photo.getSelectedFile().toString()));

        Object[] categories = GetCategories.getCategories().toArray();
        JComboBox<String> kategori = new JComboBox(categories);
        JLabel labelKategori = new JLabel("Category:");

        JButton reg = new JButton("Registrasi");
        reg.addActionListener(e -> {
            userBaru.setIdCategory(kategori.getSelectedIndex() + 1);
            if (Registrasi.registrasiUser(userBaru)) {
                JOptionPane.showMessageDialog(null, "Berhasil Registrasi User!");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal Registrasi User!");
            }
        });
        JButton back = new JButton("Back");
        back.addActionListener(e -> {
            new MainMenu();
            frame.dispose();
        });

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup().addComponent(labelEmail).addComponent(labelNama).addComponent(labelPass).addComponent(labelFoto).addComponent(labelKategori));
        hGroup.addGroup(layout.createParallelGroup().addComponent(email).addComponent(nama).addComponent(password).addComponent(photo).addComponent(kategori));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelEmail).addComponent(email));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelNama).addComponent(nama));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelPass).addComponent(password));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelFoto).addComponent(photo));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelKategori).addComponent(kategori));
        layout.setVerticalGroup(vGroup);

        buttonPanel.add(reg);
        buttonPanel.add(back);
        panelContainer.add(panel);
        panelContainer.add(buttonPanel);
        frame.add(panelContainer);
        frame.setVisible(true);
        frame.pack();
    }
}
