package chosun.community.web.posts.dto;

import chosun.community.web.entity.PostsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class writeDto { //DTO(Data Transfer Object) : form data를 받는 객체

    private String title;
    private String content;


    public PostsEntity toEntity() {
        return new PostsEntity(null, title, content);
    }
}
