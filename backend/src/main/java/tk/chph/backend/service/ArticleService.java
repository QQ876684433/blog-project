package tk.chph.backend.service;

import tk.chph.backend.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getRecentArticles(int pageNum, int pageSize);

    Article getArticleDetail(long articleId);

    List<Article> getArchives();
}
