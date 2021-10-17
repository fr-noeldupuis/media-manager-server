package fr.noeldupuis.mediamanagerserver.media;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MediaDTO {

    private Long id;
    private String name;
    private String type;
}
