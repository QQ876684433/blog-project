package tk.chph.backend.repository;

import org.springframework.stereotype.Repository;
import tk.chph.backend.pojo.Archive;
import tk.chph.backend.pojo.Article;
import tk.chph.backend.pojo.SearchResult;

import java.util.List;

@Repository
public interface ArticleRepository {
    List<Article> getArticles();

    List<Archive> getDateAndTitle();

    List<SearchResult> findArticles(String key);
}
