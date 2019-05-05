package tk.chph.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.chph.backend.entity.Article;
import tk.chph.backend.entity.Response;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @RequestMapping(value = "/recent", method = RequestMethod.GET)
    public Response<List<Article>> getRecentArticles(int pageNum, int pageSize){
        // todo
        return null;
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Response<Article> getArticleDetail(long articleId){
        // todo
        return null;
    }

    @RequestMapping(value = "/archives", method = RequestMethod.GET)
    public Response<List<Article>> getArchives(){
        // todo
        return null;
    }
}
