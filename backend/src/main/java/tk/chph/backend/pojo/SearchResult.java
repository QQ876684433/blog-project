package tk.chph.backend.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchResult {
    private long id;
    private String title;
    private String abstracts;

    public SearchResult() {
    }
}
