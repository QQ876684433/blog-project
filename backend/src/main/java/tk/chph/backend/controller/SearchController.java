package tk.chph.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.chph.backend.entity.Article;
import tk.chph.backend.entity.Response;
import tk.chph.backend.service.SearchService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Response<List<Article>> getSearchResult(String key) {
        List<Article> articles = searchService.getSearchResult(key);
        Response<List<Article>> response = new Response<>();
        response.setStatus(HttpServletResponse.SC_OK);
        response.setValue(articles);
        return response;
    }
}
