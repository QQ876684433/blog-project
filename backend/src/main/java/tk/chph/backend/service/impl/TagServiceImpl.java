package tk.chph.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.chph.backend.entity.Article;
import tk.chph.backend.entity.Tag;
import tk.chph.backend.pojo.TagArchive;
import tk.chph.backend.repository.ArticleRepository;
import tk.chph.backend.repository.TagRepository;
import tk.chph.backend.service.TagService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {
    private static final String ARTICLE_ID_SEPARATOR = ";";

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Tag getTagName(long tagId) {
        String name = tagRepository.getName(tagId);
        Tag tag = new Tag();
        tag.setId(tagId);
        tag.setName(name);
        return tag;
    }

    @Override
    public List<Article> getArchives(long tagId) {
        String articles = tagRepository.getArticles(tagId);
        List<Integer> articleIdList =
                Arrays.stream(articles.split(ARTICLE_ID_SEPARATOR))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        List<TagArchive> tagArchives = articleRepository.getArticleNames(articleIdList);
        return tagArchives.stream().map(tagArchive -> {
            Article article = new Article();
            article.setId(tagArchive.getId());
            article.setTitle(tagArchive.getTitle());
            return article;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Tag> getAllTags() {
        List<tk.chph.backend.pojo.Tag> tags = tagRepository.getTags();
        return tags.stream().map(tag -> {
            Tag t = new Tag();
            t.setId(tag.getId());
            t.setName(tag.getName());
            t.setArticleNum(tag.getArticleNum());
            return t;
        }).collect(Collectors.toList());
    }
}
