package chosun.community;

import chosun.community.domain.member.Member;
import chosun.community.domain.member.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestInitData {

    private final MemberRepository memberRepository;

    @PostConstruct
    public void init() {
        Member member = Member.builder()
                .loginId("1")
                .name("1")
                .password("1")
                .build();

        memberRepository.save(member);

    }
}
