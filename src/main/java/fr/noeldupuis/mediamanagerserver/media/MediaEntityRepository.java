package fr.noeldupuis.mediamanagerserver.media;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaEntityRepository extends CrudRepository<MediaEntity, Long> {
}
