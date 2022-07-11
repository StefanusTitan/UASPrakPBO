package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GetCategories {
    static DatabaseHandler conn = new DatabaseHandler();

    public static ArrayList<String> getCategories() {
        ArrayList<String> categories = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM category";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                categories.add(resultSet.getInt("id") + " " + resultSet.getString("nama"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.disconnect();
        return categories;
    }
}
