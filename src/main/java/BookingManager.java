import java.sql.SQLException;
import java.util.List;

public class BookingManager {

    private HotelDAO dao;//DB Data Access Object

    public BookingManager(HotelDAO dao) {
        this.dao = dao;
    }

    public boolean checkRoomAvailability(String roomName) throws SQLException {
        List<String> roomsAvailable = dao.fetchAvailableRooms();
        return roomsAvailable.contains(roomName);
    }//Method calls fetch method that accesses SQL DB
}
