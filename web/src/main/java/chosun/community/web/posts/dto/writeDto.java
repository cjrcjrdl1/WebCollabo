package chosun.community.web.posts.dto;

public class writeDto { //DTO(Data Transfer Object) : form data를 받는 객체

    private String title;
    private String content;

    public writeDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
    @Override
    public String toString() {
        return "writeDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
