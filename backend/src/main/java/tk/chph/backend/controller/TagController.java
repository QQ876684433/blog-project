package tk.chph.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.chph.backend.entity.Article;
import tk.chph.backend.entity.Response;
import tk.chph.backend.entity.Tag;
import tk.chph.backend.service.TagService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public Response<Tag> getTagName(long tagId) {
        Tag tag = tagService.getTagName(tagId);
        Response<Tag> response = new Response<>();
        response.setStatus(HttpServletResponse.SC_OK);
        response.setValue(tag);
        return response;
    }

    @RequestMapping(value = "/archives", method = RequestMethod.GET)
    public Response<List<Article>> getArchives(long tagId) {
        List<Article> articles = tagService.getArchives(tagId);
        Response<List<Article>> response = new Response<>();
        response.setStatus(HttpServletResponse.SC_OK);
        response.setValue(articles);
        return response;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Response<List<Tag>> getAllTags() {
        List<Tag> tags = tagService.getAllTags();
        Response<List<Tag>> response = new Response<>();
        response.setStatus(HttpServletResponse.SC_OK);
        response.setValue(tags);
        return response;
    }
}
