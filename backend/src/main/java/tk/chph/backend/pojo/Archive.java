package tk.chph.backend.pojo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class Archive {
    private long id;
    private Date date;
    private String title;

    public Archive() {
    }
}
