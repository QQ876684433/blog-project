package tk.chph.backend.repository;

import org.apache.ibatis.annotations.Mapper;
import tk.chph.backend.pojo.Tag;

import java.util.List;

@Mapper
public interface TagRepository {
    String getName(long tagId);

    String getArticles(long tagId);

    List<Tag> getTags();
}
