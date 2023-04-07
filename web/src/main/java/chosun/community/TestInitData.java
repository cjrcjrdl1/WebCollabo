package chosun.community;

import chosun.community.domain.member.Member;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestInitData {

    @PostConstruct
    public void init() {
        Member member = Member.builder()
                .loginId("1")
                .name("1")
                .password("1")
                .build();

    }
}
