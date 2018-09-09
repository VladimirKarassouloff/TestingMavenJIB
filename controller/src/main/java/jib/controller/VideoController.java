package jib.controller;

import jib.constant.Endpoint;
import jib.dto.VideoDTO;
import jib.mapper.VideoMapper;
import jib.service.video.IVideoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Endpoint.VIDEO)
public class VideoController {


    private IVideoService videoService;
    private VideoMapper videoMapper;

    public VideoController(IVideoService videoService, VideoMapper videoMapper) {
        this.videoService = videoService;
        this.videoMapper = videoMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<VideoDTO> get() {
        return videoMapper.toDtoList(videoService.getAll());
    }

}
