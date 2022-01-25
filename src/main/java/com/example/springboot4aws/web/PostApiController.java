package com.example.springboot4aws.web;

import com.example.springboot4aws.service.posts.PostsService;
import com.example.springboot4aws.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostsService postsService;
    @PostMapping("/api/v1/posts")
    public long save (@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }
}
