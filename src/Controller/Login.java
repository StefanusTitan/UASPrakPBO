package Controller;

import Model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {
    static DatabaseHandler conn = new DatabaseHandler();

    public static User loginUser(String email, String password) {
        conn.connect();
        String query = "SELECT * FROM user WHERE email='" + email + "'&&password='" + password + "'";
        User user = new User();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                user.setEmail(resultSet.getString("email"));
                user.setId(resultSet.getInt("id"));
                user.setIdCategory(resultSet.getInt("idCategory"));
                user.setPassword(resultSet.getString("password"));
                user.setPhoto(resultSet.getString("photo"));
                user.setNama(resultSet.getString("nama"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.disconnect();
        return user;
    }
}
