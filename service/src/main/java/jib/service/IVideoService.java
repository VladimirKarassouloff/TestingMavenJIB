package jib.service;

import jib.dao.CustomRepository;
import jib.dao.VideoFilter;
import jib.dao.VideoRepository;
import jib.model.VideoEntity;
import org.springframework.data.jpa.domain.Specification;

public interface IVideoService extends IService<VideoEntity, VideoFilter> {

}
