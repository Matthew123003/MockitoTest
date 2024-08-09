import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {

    public List<String> fetchAvailableRooms() throws SQLException {
        List<String> availableRooms = new ArrayList<>();
        Connection conn = DriverManager.getConnection("DB_URL");
        Statement stmt = conn.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("SELECT * FROM rooms WHERE AVAILABLE like '1'");
        while(rs.next()){
            availableRooms.add(rs.getString("Room name"));
        }
        return availableRooms;
    }//Creates SQL DB connection, creates statement, the Result set executes the query and extracts
    //info to the result set
}
