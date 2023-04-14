package chosun.community.web.posts;

import chosun.community.domain.member.Member;
import chosun.community.domain.posts.Posts;
import chosun.community.domain.posts.PostsRepository;
import chosun.community.domain.posts.PostsWriteRepository;
import chosun.community.web.entity.PostsEntity;
import chosun.community.web.posts.dto.writeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Slf4j
@Controller
public class PostsController {

    @Autowired // 스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결!
    private final PostsRepository postsRepository;
    private final PostsWriteRepository postsWriteRepository;

    @GetMapping("/posts")
    public String index(Model model,
                        @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable, Member member) {
        Page<Posts> posts = postsRepository.findAll(pageable); //이후 서비스로 연결 예정

        if (member != null) {
            model.addAttribute("member", member);
        }

        model.addAttribute("posts", posts);
        return "posts/postsList";
    }
    @GetMapping("/write")
    public String writeForm(Model model){
        model.addAttribute("title", "제목");
        model.addAttribute("content", "내용");
        model.addAttribute("name", "이중민");
        return "posts/postsWrite";
    }

    @PostMapping("/write")
    public String write(writeDto data){
        log.info(data.toString());

        //1. Dto를 entity로 바꿔야 함.
        PostsEntity posts= data.toEntity();
        System.out.println(posts.toString());

        //2. Repository에게 entity로 저장하게 함.
        PostsEntity saved = postsWriteRepository.save(posts);
        System.out.println(saved.toString());
        return "posts/postsList";
    }
}
