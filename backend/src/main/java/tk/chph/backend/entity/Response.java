package tk.chph.backend.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 响应类
 * @param <T> 返回的实体类值value的类型
 */
@Getter
@Setter
public class Response<T> {
    // 状态码
    private int status;

    // 返回的实体类，如果没有则返回null
    private T value;

    public Response() {
    }
}
