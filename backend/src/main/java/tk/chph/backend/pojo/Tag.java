package tk.chph.backend.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tag {
    private long id;
    private String name;
    private int articleNum;

    public Tag() {
    }
}
