package hometaskUnitTest;

import org.junit.Assert;
import org.junit.Test;

public class GetDayOfWeekTest {

    @Test
    public void checkMonday() {

        String day = DayOfWeekUtility.getDayOfWeek(1);
        Assert.assertEquals("That's Monday: ", "Monday", day);
    }

    @Test
    public void checkSunday() {

        String day = DayOfWeekUtility.getDayOfWeek(7);
        Assert.assertEquals("That's Monday: ", "Sunday", day);
    }

    @Test
    public void checkInvalidDayOfWeekLessThanOne() {

        String day = DayOfWeekUtility.getDayOfWeek(0);
        Assert.assertEquals("Invalid day number. Please provide a number between 1 and 7.", day);
    }

    @Test
    public void checkInvalidDayOfWeekMoreThanSeven() {

        String day = DayOfWeekUtility.getDayOfWeek(8);
        Assert.assertEquals("Invalid day number. Please provide a number between 1 and 7.", day);
    }
}
