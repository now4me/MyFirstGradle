package my.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void clenaup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시클저장_불러오기(){
        String title = "테스트 게시물";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                                .title(title)
                                .content(content)
                                .author("dslee")
                                .build());

        List<Posts> postslist = postsRepository.findAll();

        Posts posts = postslist.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

}
