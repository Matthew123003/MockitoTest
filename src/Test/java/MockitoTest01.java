import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoTest01 {
    private HotelDAO hotelDaoMock;
    private BookingManager bm;

    @Before
    public void setup(){
        hotelDaoMock = mock(HotelDAO.class);
        bm = new BookingManager(hotelDaoMock);
    }

    @Test
    public void testAvailableRoomsTrue() throws SQLException {
        List<String> availableRooms = Arrays.asList("A");
        when(hotelDaoMock.fetchAvailableRooms()).thenReturn(availableRooms);

        Assert.assertTrue(bm.checkRoomAvailability("A"));
    }//Mockito creates a mock DAO and mocks checking the DB

    @Test
    public void testAvailableRoomsFalse() throws SQLException {
        List<String> availableRooms = Arrays.asList("A");
        when(hotelDaoMock.fetchAvailableRooms()).thenReturn(availableRooms);

        Assert.assertFalse(bm.checkRoomAvailability("B"));
    }//Mockito creates a mock DAO and mocks creating DB. I wonder if I can use Mockito
    //To mock or test user input as well
}
