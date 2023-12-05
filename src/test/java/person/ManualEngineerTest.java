package person;

import org.junit.*;
import org.junit.runners.MethodSorters;
import person.ManualEngineer;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManualEngineerTest {

    ManualEngineer manualEngineer = new ManualEngineer(20, 3);

    @Test
    public void atestGetAutomatedEngineerSkill() {

        Assert.assertEquals("The skill isn't correct", 6, manualEngineer.getSkill());
    }

    @Test
    public void btestGetAutomatedEngineerExperience() {

        Assert.assertEquals("The experience isn't correct", 3, manualEngineer.getExperience());
    }

    @Test
    public void ctestGetAutomatedEngineerAge() {

        Assert.assertEquals("The age isn't correct", 20, manualEngineer.getAge());
    }

    @Test
    public void dtestSetAutomatedEngineerSkill() {

        manualEngineer.setSkill(12);
        Assert.assertEquals("The new skill isn't correct", 12, manualEngineer.getSkill());
    }

    @Test
    public void etestSetAutomatedEngineerExperience() {

        manualEngineer.setExperience(7);
        Assert.assertEquals("The new experience isn't correct", 7, manualEngineer.getExperience());
    }

    @Test
    public void ftestSetAutomatedEngineerAge() {

        manualEngineer.setAge(22);
        Assert.assertEquals("The new age isn't correct", 22, manualEngineer.getAge());
    }

    @After
    public void beforeCheck() {
        System.out.println("I'm before");
    }
}
