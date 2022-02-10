package com.example.springboot4aws.service.posts;

import com.example.springboot4aws.domain.posts.Posts;
import com.example.springboot4aws.domain.posts.PostsRepository;
import com.example.springboot4aws.web.dto.PostsResponseDto;
import com.example.springboot4aws.web.dto.PostsSaveRequestDto;
import com.example.springboot4aws.web.dto.PostsUpdateRequestDto;
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

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id= "+ id ));

        posts.update(requestDto.getTitle(),requestDto.getContent());
        return id;
        //JPA의 영속성 컨텍스트 - 엔티티를 영구 저장하는 환경
        //JPA의 핵심 내용: 엔티티의 영속성 컨텍스트 포함 유무
        //JPA의 엔티티 매니저가 활성화된 상태로 트랜잭션 안에서 테이터베이스에서 데이터를 가져오면 이 데이터는 영속성 컨텍스트가 유지된 상태
        //이 상태에서 해당 데이터 값을 변경하면 트랜잭션이 끝나는 시점에 해당 테이블에 변경분을 반영
        // Entity 객체의 값만 변경하면 별도로 Update 쿼리를 날릴 필요 없음
        //-> 더티 체킹
    }
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }
}
