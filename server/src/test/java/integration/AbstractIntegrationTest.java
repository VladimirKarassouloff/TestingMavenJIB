package integration;


import jib.server.Server;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = Server.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ContextConfiguration(
        initializers = AbstractIntegrationTest.Initializer.class
)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestPropertySource("classpath:application-test.properties")
public abstract class AbstractIntegrationTest {

    public static MySQLContainer mySQLContainer = new MySQLContainer<>("mysql:5.7.22")
            .withDatabaseName("test")
            .withUsername("admin")
            .withPassword("admin")
            .withEnv("MYSQL_LOG_QUERIES_ENABLED", "1")
            .withLogConsumer(new Slf4jLogConsumer(LoggerFactory.getLogger(AbstractIntegrationTest.class)));//

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            mySQLContainer.start();
        }
    }

}
