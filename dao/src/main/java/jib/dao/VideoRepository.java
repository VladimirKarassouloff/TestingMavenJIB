package jib.dao;

import jib.model.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VideoRepository extends CustomRepository<VideoEntity, UUID> {
}
