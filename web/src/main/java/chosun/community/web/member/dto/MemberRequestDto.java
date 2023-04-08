package chosun.community.web.member.dto;

import chosun.community.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberRequestDto {

    private String loginId;
    private String name;
    private String password;

    public Member toEntity() {
        return Member.builder()
                .loginId(loginId)
                .name(name)
                .password(password)
                .build();
    }

}
