package integration;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AuthorCreationIntegrationTest.class,
        VideoCreationIntegrationTest.class
})
public class ScenarioSuite {

    public static final String NAME_AUTHOR_CREATED = "TOTO";




}

