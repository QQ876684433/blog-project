package tk.chph.backend.service;

import tk.chph.backend.entity.Article;

import java.util.List;

public interface SearchService {
    List<Article> getSearchResult(String key);
}
