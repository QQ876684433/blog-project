package tk.chph.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.chph.backend.entity.Article;
import tk.chph.backend.entity.Response;
import tk.chph.backend.service.ArticleService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/recent", method = RequestMethod.GET)
    public Response<List<Article>> getRecentArticles(int pageNum, int pageSize) {
        List<Article> articles = articleService.getRecentArticles(pageNum, pageSize);
        Response<List<Article>> response = new Response<>();
        response.setStatus(HttpServletResponse.SC_OK);
        response.setValue(articles);
        return response;
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Response<Article> getArticleDetail(long articleId) {
        Article article = articleService.getArticleDetail(articleId);
        Response<Article> response = new Response<>();
        response.setStatus(HttpServletResponse.SC_OK);
        response.setValue(article);
        return response;
    }

    @RequestMapping(value = "/archives", method = RequestMethod.GET)
    public Response<List<Article>> getArchives() {
        List<Article> articles = articleService.getArchives();
        Response<List<Article>> response = new Response<>();
        response.setStatus(HttpServletResponse.SC_OK);
        response.setValue(articles);
        return response;
    }
}
