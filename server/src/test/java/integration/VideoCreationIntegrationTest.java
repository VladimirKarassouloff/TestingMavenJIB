package integration;

import jib.service.video.IVideoService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class VideoCreationIntegrationTest extends AbstractIntegrationTest {


    @Autowired
    private IVideoService videoService;

    @Test
    public void step1_dumbTest() {
        assertTrue(videoService.getAll().isEmpty());
    }


}
