package tk.chph.backend.pojo;

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

    public Article() {
    }
}
