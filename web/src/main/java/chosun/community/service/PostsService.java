package chosun.community.service;

import chosun.community.domain.member.MemberRepository;
import chosun.community.domain.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PostsService {

    private final PostsRepository postsRepository;
    private final MemberRepository memberRepository;


}
