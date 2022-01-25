package com.example.springboot4aws.service.posts;

import com.example.springboot4aws.domain.posts.PostsRepository;
import com.example.springboot4aws.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor// 생성자 해결
//final이 선언된 모든 필드를 인자값으로 하는 생성자들 대신 생성해 줌
//해당 클래스의 의존성 관계가 변경될 때마다 생성자 코드를 계속해서 수정하는 번거로움 해결
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
