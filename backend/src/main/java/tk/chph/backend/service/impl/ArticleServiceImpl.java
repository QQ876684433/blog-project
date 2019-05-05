package tk.chph.backend.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.chph.backend.entity.Article;
import tk.chph.backend.repository.ArticleContentRepository;
import tk.chph.backend.repository.ArticleRepository;
import tk.chph.backend.service.ArticleService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleContentRepository articleContentRepository;

    @Override
    public List<Article> getRecentArticles(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<tk.chph.backend.pojo.Article> articleList = articleRepository.getArticles();
        List<Article> articles = new ArrayList<>(articleList.size());
        articleList.forEach(article -> {
            Article a = new Article();
            a.setId(article.getId());
            a.setTitle(article.getTitle());
            a.setDate(article.getDate());
            a.setTagId(article.getTagId());
            a.setAbstracts(article.getAbstracts());
            articles.add(a);
        });
        return articles;
    }

    @Override
    public Article getArticleDetail(long articleId) {
        Article article = new Article();
        String content = articleContentRepository.getArticleContent(articleId);
        article.setId(articleId);
        article.setContent(content);
        return article;
    }

    @Override
    public List<Article> getArchives() {
        List<tk.chph.backend.pojo.Archive> archives = articleRepository.getDateAndTitle();
        List<Article> articles = new ArrayList<>();
        archives.forEach(archive -> {
            Article article = new Article();
            article.setId(archive.getId());
            article.setDate(archive.getDate());
            article.setTitle(archive.getTitle());
        });
        return articles;
    }
}
