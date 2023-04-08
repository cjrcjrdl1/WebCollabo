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
public class MemberResponseDto {

    private String loginId;
    private String name;
    private String password;

    public MemberResponseDto(Member entity) {
        this.loginId = entity.getLoginId();
        this.name = entity.getName();
        this.password = entity.getPassword();
    }

}
