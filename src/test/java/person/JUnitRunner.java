package person;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import person.AutomatedEngineerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AutomatedEngineerTest.class,
        ManualEngineerTest.class
})
public class JUnitRunner {

}
