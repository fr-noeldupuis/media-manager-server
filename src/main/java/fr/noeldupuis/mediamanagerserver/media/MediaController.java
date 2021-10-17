package fr.noeldupuis.mediamanagerserver.media;

import fr.noeldupuis.mediamanagerserver.media.enums.MediaTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MediaController {

    @Autowired
    MediaRepository mediaRepository;

    @GetMapping("/medias")
    public List<MediaDTO> getAllMedias() {
        return new ArrayList<>();
    }

    @PostMapping("/medias")
    public ResponseEntity<MediaDTO> postMedia(@RequestBody MediaDTO mediaDTO) {
        MediaEntity media = new MediaEntity();
        media.setName(mediaDTO.getName());
        media.setType(MediaTypeEnum.valueOf(mediaDTO.getType()));
        mediaRepository.save(media);

        MediaDTO returnedMediaDTO = MediaDTO.builder()
                .id(media.getId())
                .name(media.getName())
                .type(media.getType().name())
                .build();
        return new ResponseEntity<>(returnedMediaDTO, HttpStatus.CREATED);
    }
}
