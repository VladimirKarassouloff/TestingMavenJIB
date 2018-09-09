package jib.service.video;

import jib.dao.CustomRepository;
import jib.dao.video.VideoFilter;
import jib.dao.video.VideoRepository;
import jib.dao.video.VideoSpecification;
import jib.model.entities.VideoEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements IVideoService {

    private VideoRepository videoRepository;

    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public CustomRepository<VideoEntity, ?> getRepository() {
        return videoRepository;
    }

    @Override
    public Specification<VideoEntity> specificate(VideoFilter videoFilter) {
        return VideoSpecification.filter(videoFilter);
    }
}
