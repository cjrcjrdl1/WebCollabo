package chosun.community.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity // DB가 해당 객체를 인식 가능
public class PostsEntity {

    @Id // 대표값을 지정 ex) 주민등록번호 제목도 같고 내용도 같을 때 그것을 구분 지을 수 있는 것
    @GeneratedValue // 1, 2, 3 .... 자동 생성 어노테이션
    private Long Id;

    @Column //DB Table 단위에 연결 되게 해주는 어노테이션
    private String title;

    @Column
    private String content;

}
