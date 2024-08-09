package test;

import main.IntegerAsker;
import org.junit.Assert;
import org.junit.Test;

import static main.IntegerAsker.getBoundIntegerFromUser;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class UserInputTest {

    @Test
    public void getsIntegerWhenWithinBoundsOfOneToTen() throws Exception {
        IntegerAsker asker = mock(IntegerAsker.class);
        when(asker.ask(anyString())).thenReturn(3);

        Assert.assertEquals(getBoundIntegerFromUser(asker), 3);
    }

    @Test
    public void asksForNewIntegerWhenOutsideBoundsOfOneToTen() throws Exception {
        IntegerAsker asker = mock(IntegerAsker.class);
        when(asker.ask("Give a number between 1 and 10")).thenReturn(99);
        when(asker.ask("Wrong number, try again.")).thenReturn(3);

        getBoundIntegerFromUser(asker);

        verify(asker).ask("Wrong number, try again.");
    }
}
