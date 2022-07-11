package View;

import Controller.GetCategories;
import Controller.LihatUser;

import javax.swing.*;
import java.util.List;

public class MenuLihatPengguna {
    public MenuLihatPengguna() {
        JFrame frame = new JFrame("Lihat User Data");
        JPanel panelContainer = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel panel = new JPanel();
        Object[] categories = GetCategories.getCategories().toArray();
        JComboBox<String> category = new JComboBox(categories);
        category.addActionListener(e -> {
            List<List<String>> dataTabel = LihatUser.getUsers(category.getSelectedIndex() + 1);
            String[][] data = new String[dataTabel.size()][dataTabel.get(0).size()];
            for (int i = 0; i < dataTabel.size(); i++) {
                for (int j = 0; j < dataTabel.get(i).size(); j++) {
                    data[i][j] = dataTabel.get(i).get(j);
                }
            }
            String[] columnNames = {"Nama", "E-Mail", "Password", "ID Category", "Photo"};

            JTable tabel = new JTable(data, columnNames);
            panel.add(new JScrollPane(tabel));
            tabel.setBounds(30, 40, 200, 300);
            tabel.setVisible(true);
            frame.pack();
        });
        JButton back = new JButton("Back");
        back.addActionListener(e -> {
            new MainMenu();
            frame.dispose();
        });
        buttonPanel.add(back);
        panel.add(category);
        panelContainer.add(buttonPanel);
        panelContainer.add(panel);
        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
        frame.add(panelContainer);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.pack();

    }
}
