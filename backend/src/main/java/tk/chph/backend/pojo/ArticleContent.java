package tk.chph.backend.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * mongodb集合：文章内容
 */
@Getter
@Setter
@Document(collection = "article_content")
public class ArticleContent {
    @Id
    private String id;
    @Field("article_id")
    private String articleId;
    private String content;
}
