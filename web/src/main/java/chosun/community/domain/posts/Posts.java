package chosun.community.domain.posts;

import chosun.community.domain.member.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Posts {

    @Id
    @GeneratedValue
    @Column(name = "POSTS_ID")
    private Long id;

    @NotNull
    @Column(length = 500)
    private String title;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    private String author;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int view;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
