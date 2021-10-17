package fr.noeldupuis.mediamanagerserver.media;

import fr.noeldupuis.mediamanagerserver.media.enums.MediaTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class MediaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private MediaTypeEnum type;

}
