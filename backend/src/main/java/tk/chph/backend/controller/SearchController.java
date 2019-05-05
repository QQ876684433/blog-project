package tk.chph.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.chph.backend.entity.Article;
import tk.chph.backend.entity.Response;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Response<List<Article>> getSearchResult(String key) {
        // todo
        return null;
    }
}
