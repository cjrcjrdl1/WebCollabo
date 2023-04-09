package chosun.community;

import chosun.community.domain.member.Member;
import chosun.community.domain.member.MemberRepository;
import chosun.community.domain.posts.Posts;
import chosun.community.domain.posts.PostsRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestInitData {

    private final MemberRepository memberRepository;
    private final PostsRepository postsRepository;

    @PostConstruct
    public void init() {
        Member member = Member.builder()
                .loginId("1")
                .name("1")
                .password("1")
                .build();

        memberRepository.save(member);

        Posts post = Posts.builder()
                .title("리중민 최민영 킴윤호")
                .content("스프링")
                .author("나")
                .id(1L)
                .view(1)
                .member(member)
                .build();
        postsRepository.save(post);
    }


}
