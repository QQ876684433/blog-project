package tk.chph.backend.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import tk.chph.backend.pojo.ArticleContent;
import tk.chph.backend.repository.ArticleContentRepository;

public class ArticleContentRepositoryImpl implements ArticleContentRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String getArticleContent(long articleId) {
        Query query = Query.query(Criteria.where("article_id").is(articleId));
        ArticleContent article = mongoTemplate.findOne(query, ArticleContent.class);
        return article == null ? null : article.getContent();
    }
}
