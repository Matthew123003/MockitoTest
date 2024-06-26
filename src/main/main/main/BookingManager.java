package main;

import java.sql.SQLException;
import java.util.List;

public class BookingManager {
    private main.HotelDao dao;//DB Data Access Object

    public BookingManager(main.HotelDao dao) {
        this.dao = dao;
    }

    public boolean checkRoomAvailability(String roomName) throws SQLException {
        List<String> roomsAvailable = dao.fetchAvailableRooms();
        return roomsAvailable.contains(roomName);
    }//Method calls fetch method that accesses SQL DB
}
