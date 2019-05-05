package tk.chph.backend.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface ArticleContentRepository {
    String getArticleContent(long articleId);
}
