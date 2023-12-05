package hometaskUnitTest;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertTrue;

public class GetDayOfWeekNextYearTest {
    @Test
    public void checkDayOfWeekNextYear() {

        String day = DayOfWeekUtility.getDayOfWeekNextYear(4);
        System.out.println(day);
    }
}
