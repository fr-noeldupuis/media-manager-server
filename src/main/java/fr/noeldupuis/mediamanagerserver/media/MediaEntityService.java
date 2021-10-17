package fr.noeldupuis.mediamanagerserver.media;

import fr.noeldupuis.mediamanagerserver.media.enums.MediaTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MediaEntityService {

    @Autowired
    MediaEntityRepository mediaRepository;

    public List<MediaDTO> getAllMediaEntity() {
        return new ArrayList<>();
    }

    public MediaDTO saveMediaEntity(MediaDTO mediaDTO) {
        MediaEntity media = MediaEntity.builder()
                .name(mediaDTO.getName())
                .type(MediaTypeEnum.valueOf(mediaDTO.getType()))
                .build();

        mediaRepository.save(media);

        return this.getMediaDTO(media);
    }

    private MediaDTO getMediaDTO(MediaEntity media) {
        return MediaDTO.builder()
                .id(media.getId())
                .name(media.getName())
                .type(media.getType().name())
                .build();
    }
}
