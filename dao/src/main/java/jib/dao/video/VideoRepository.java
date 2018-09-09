package jib.dao.video;

import jib.dao.CustomRepository;
import jib.model.entities.VideoEntity;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VideoRepository extends CustomRepository<VideoEntity, UUID> {
}
