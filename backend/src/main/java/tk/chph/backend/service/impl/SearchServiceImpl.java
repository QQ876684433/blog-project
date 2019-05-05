package tk.chph.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.chph.backend.entity.Article;
import tk.chph.backend.pojo.SearchResult;
import tk.chph.backend.repository.ArticleRepository;
import tk.chph.backend.service.SearchService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> getSearchResult(String key) {
        List<SearchResult> searchResults = articleRepository.findArticles(key);
        return searchResults.stream().map(result -> {
            Article article = new Article();
            article.setId(result.getId());
            article.setTitle(result.getTitle());
            article.setAbstracts(result.getAbstracts());
            return article;
        }).collect(Collectors.toList());
    }
}
