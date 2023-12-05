package person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import person.AutomatedEngineer;
import person.Engineer;
import person.ManualEngineer;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class CommonEngineerTest {


    private Engineer en;
    private int expSkill;

    public CommonEngineerTest(Engineer en, int expSkill) {
        this.en = en;
        this.expSkill = expSkill;
    }

    @Parameterized.Parameters
    public static List<Object[]> parameters() {
        return Arrays.asList(
                new Object[][]{
                        {new AutomatedEngineer(24, 10), 30,24, 10},
                        {new ManualEngineer(24, 10), 20}
                }
        );
    }

    @Test
    public void checkDefaultAge(){
        assertEquals("The age is not correct!", expSkill, en.getAge());
    }

    @Test
    public void checkDefaultSkill(){
        assertEquals("The age is not correct!", expSkill, en.getSkill());
    }
}
