package tk.chph.backend.repository;

import org.springframework.stereotype.Repository;
import tk.chph.backend.pojo.Tag;

import java.util.List;

@Repository
public interface TagRepository {
    String getName(long tagId);

    String getArticles(long tagId);

    List<Tag> getTags();
}
