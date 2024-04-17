package MockitoTest;

import main.BookingManager;
import main.HotelDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoTest {
    private HotelDao hotelDaoMock;
    private BookingManager bm;

    @Before
    public void setup(){
        hotelDaoMock = mock(HotelDao.class);
        bm = new BookingManager(hotelDaoMock);
    }

    @Test
    public void testAvailableRoomsTrue() throws SQLException {
        List<String> availableRooms = Arrays.asList("A");
        when(hotelDaoMock.fetchAvailableRooms()).thenReturn(availableRooms);

        Assert.assertTrue(bm.checkRoomAvailability("A"));
    }

    @Test
    public void testAvailableRoomsFalse() throws SQLException {
        List<String> availableRooms = Arrays.asList("A");
        when(hotelDaoMock.fetchAvailableRooms()).thenReturn(availableRooms);

        Assert.assertTrue(bm.checkRoomAvailability("B"));
    }
}