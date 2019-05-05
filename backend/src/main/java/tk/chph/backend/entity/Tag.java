package tk.chph.backend.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Tag {
    private long id;
    private String name;
    private int articleNum;
    private List<Article> articles;

    public Tag() {
    }
}
