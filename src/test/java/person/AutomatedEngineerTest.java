package person;

import org.junit.Assert;
import org.junit.Test;
import person.AutomatedEngineer;

public class AutomatedEngineerTest {
    AutomatedEngineer automatedEngineer = new AutomatedEngineer(25, 10);

    @Test
    public void testGetAutomatedEngineerSkill() {

        Assert.assertEquals("The skill isn't correct", 10, automatedEngineer.getSkill());
    }

    @Test
    public void testGetAutomatedEngineerExperience() {

        Assert.assertEquals("The experience isn't correct", 5, automatedEngineer.getExperience());
    }

    @Test
    public void testGetAutomatedEngineerAge() {

        Assert.assertEquals("The age isn't correct", 25, automatedEngineer.getAge());
    }

    @Test
    public void testSetAutomatedEngineerSkill() {

        automatedEngineer.setSkill(12);
        Assert.assertEquals("The new skill isn't correct", 12, automatedEngineer.getSkill());
    }

    @Test
    public void testSetAutomatedEngineerExperience() {

        automatedEngineer.setExperience(7);
        Assert.assertEquals("The new experience isn't correct", 7, automatedEngineer.getExperience());
    }

    @Test
    public void testSetAutomatedEngineerAge() {

        automatedEngineer.setAge(22);
        Assert.assertEquals("The new age isn't correct", 22, automatedEngineer.getAge());
    }


}
