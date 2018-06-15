package org.disktop.notebook;

import org.disktop.entity.File;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by flysLi on 2017/8/26.
 */
@Component
public interface FileRepository extends MongoRepository<File, Long> {

    List<File> findByName(String name);
}
