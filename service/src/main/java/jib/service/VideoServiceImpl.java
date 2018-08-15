package jib.service;

import jib.dao.CustomRepository;
import jib.dao.VideoFilter;
import jib.dao.VideoRepository;
import jib.dao.VideoSpecification;
import jib.model.VideoEntity;
import org.springframework.data.jpa.domain.Specification;

public class VideoServiceImpl implements IVideoService {

    private VideoRepository videoRepository;

    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public CustomRepository<VideoEntity, ?> getRepository() {
        return null;
    }

    @Override
    public Specification<VideoEntity> specificate(VideoFilter videoFilter) {
        return VideoSpecification.filter(videoFilter);
    }
}
