package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class LihatUser {
    static DatabaseHandler conn = new DatabaseHandler();

    public static List<List<String>> getUsers(int idCategory) {
        List<List<String>> data = new ArrayList<>();
        List<String> user = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM user WHERE idCategory=" + idCategory;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                user.clear();
                user.add(resultSet.getString("nama"));
                user.add(resultSet.getString("email"));
                user.add(resultSet.getString("password"));
                user.add(String.valueOf(resultSet.getInt("idCategory")));
                user.add(resultSet.getString("photo"));
                data.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
}
