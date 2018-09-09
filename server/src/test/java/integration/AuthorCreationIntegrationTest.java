package integration;

import jib.dao.author.AuthorFilter;
import jib.model.entities.AuthorEntity;
import jib.service.author.IAuthorService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static integration.ScenarioSuite.NAME_AUTHOR_CREATED;
import static org.junit.Assert.assertNotNull;


public class AuthorCreationIntegrationTest extends AbstractIntegrationTest {


    @Autowired
    private IAuthorService authorService;

    @Test
    public void step1_testCreate() {
        AuthorEntity authorEntity = authorService.save(AuthorEntity.builder()
                .name(NAME_AUTHOR_CREATED)
                .build());


        assertNotNull(
                authorService.getOneOrNull(AuthorFilter.builder()
                        .nameEquals(NAME_AUTHOR_CREATED)
                        .build())
        );
    }

    @Test
    public void step2_testUpdate() {
        // TODO
    }


}
