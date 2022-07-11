package Controller;

import Model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registrasi {
    static DatabaseHandler conn = new DatabaseHandler();

    public static boolean registrasiUser(User user) {
        conn.connect();
        String query = "INSERT INTO user (nama, email, password, idCategory, photo) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, user.getNama());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getIdCategory());
            stmt.setString(5, user.getPhoto());
            stmt.executeUpdate();
            conn.disconnect();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            conn.disconnect();
            return false;
        }
    }
}
