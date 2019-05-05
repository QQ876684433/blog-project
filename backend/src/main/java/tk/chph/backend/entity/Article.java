package tk.chph.backend.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class Article {
    private long id;
    private String title;
    private Date date;
    private long tagId;
    private String abstracts;
    // private Category category;
    private String content;

    public Article() {
    }
}
