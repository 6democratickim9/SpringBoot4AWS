package com.example.springboot4aws.web;

import com.example.springboot4aws.service.posts.PostsService;
import com.example.springboot4aws.web.dto.PostsResponseDto;
import com.example.springboot4aws.web.dto.PostsSaveRequestDto;
import com.example.springboot4aws.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;
    @PostMapping("/api/v1/posts")
    public long save (@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestsDto){
        return postsService.update(id, requestsDto);
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }
}
