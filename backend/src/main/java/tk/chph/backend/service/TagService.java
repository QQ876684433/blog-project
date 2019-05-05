package tk.chph.backend.service;

import tk.chph.backend.entity.Article;
import tk.chph.backend.entity.Tag;

import java.util.List;

public interface TagService {
    Tag getTagName(long tagId);

    List<Article> getArchives(long tagId);

    List<Tag> getAllTags();
}
