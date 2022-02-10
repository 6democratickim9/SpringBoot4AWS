package com.example.springboot4aws.web.dto;


import com.example.springboot4aws.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {// Entity 의 필드 중 일부만 사용
    //생성자로 Entity 를 받아 필드에 값을 넣는다. 굳이 모든 필드를 가진 생성자가 필요하진 않으므로 DTO는 Entity만 받아 처리
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto (Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
