package my.springboot.web;

import lombok.RequiredArgsConstructor;
import my.springboot.service.PostService;
import my.springboot.web.dto.PostResponseDto;
import my.springboot.web.dto.PostSaveRequestDto;
import my.springboot.web.dto.PostUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @PostMapping("/api/v1/posts")
    public long save(@RequestBody PostSaveRequestDto requestDto){
        return postService.save(requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostResponseDto findById(@PathVariable Long id){
        return postService.findById(id);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return postService.update(id, requestDto);
    }

}
