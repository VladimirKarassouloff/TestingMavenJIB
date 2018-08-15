package jib.mapper;

import jib.dto.VideoDTO;
import jib.model.VideoEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VideoMapper extends AbstractMapper<VideoEntity, VideoDTO> {

    public VideoMapper() {
        super(VideoEntity.class, VideoDTO.class);
    }

    public void extraMappingToEntity(VideoDTO videoDTO, VideoEntity videoEntity) {

    }

    public void extraMappingToDTO(VideoEntity videoEntity, VideoDTO videoDTO) {

    }
}
