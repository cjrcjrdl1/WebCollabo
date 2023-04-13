package chosun.community.domain.posts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PostsWrite {
    @Id
    @Column
    private Long id;
    @Column
    private String title;
    @Column
    private String content;


}
