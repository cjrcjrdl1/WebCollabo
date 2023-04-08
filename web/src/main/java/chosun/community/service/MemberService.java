package chosun.community.service;

import chosun.community.domain.member.Member;
import chosun.community.domain.member.MemberRepository;
import chosun.community.web.member.dto.MemberRequestDto;
import chosun.community.web.member.dto.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void save(MemberRequestDto requestDto) {
        memberRepository.save(requestDto.toEntity());
    }

    public MemberResponseDto findById(Long id) {
        Member entity = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 맴버가 없습니다. id=" + id));
        return new MemberResponseDto(entity);
    }

    public MemberResponseDto findByName(String name) {
        Member entity = memberRepository.findByName(name);
        return new MemberResponseDto(entity);
    }
}
