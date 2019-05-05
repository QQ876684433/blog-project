package tk.chph.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.chph.backend.entity.Article;
import tk.chph.backend.entity.Response;
import tk.chph.backend.entity.Tag;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public Response<Tag> getTagName(long tagId) {
        // todo
        return null;
    }

    @RequestMapping(value = "/archives", method = RequestMethod.GET)
    public Response<List<Article>> getArchives(long tagId) {
        // todo
        return null;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Response<List<Tag>> getAllTags() {
        // todo
        return null;
    }
}
