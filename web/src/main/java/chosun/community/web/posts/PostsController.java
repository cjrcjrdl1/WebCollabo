package chosun.community.web.posts;

import chosun.community.domain.member.Member;
import chosun.community.domain.posts.Posts;
import chosun.community.domain.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/posts")
@Controller
public class PostsController {

    private final PostsRepository postsRepository;

    @GetMapping()
    public String index(Model model,
                        @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable, Member member) {
        Page<Posts> posts = postsRepository.findAll(pageable); //이후 서비스로 연결 예정

        if (member != null) {
            model.addAttribute("member", member);
        }

        model.addAttribute("posts", posts);
        return "posts/postsList";
    }
}
