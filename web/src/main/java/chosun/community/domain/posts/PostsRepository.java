package chosun.community.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id desc ")
    List<Posts> findAllDesc();

    @Modifying
    @Query("UPDATE Posts p set p.view = p.view+1 where p.id = :id")
    int updateView(@Param("id") Long id);
}
