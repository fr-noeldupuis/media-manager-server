package fr.noeldupuis.mediamanagerserver.media;

import fr.noeldupuis.mediamanagerserver.media.enums.MediaTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MediasController {

    @Autowired
    MediaEntityService mediaService;

    @GetMapping("/medias")
    @ResponseStatus(HttpStatus.OK)
    public List<MediaDTO> getAllMedias() {
        return mediaService.getAllMediaEntity();
    }

    @PostMapping("/medias")
    @ResponseStatus(HttpStatus.CREATED)
    public MediaDTO postMedia(@RequestBody MediaDTO mediaDTO) {
        return mediaService.saveMediaEntity(mediaDTO);
    }
}
