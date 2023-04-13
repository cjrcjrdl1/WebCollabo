package chosun.community.domain.posts;

import chosun.community.web.entity.PostsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsWriteRepository extends JpaRepository<PostsEntity, Long> {
}
