package hu.me.iit.webalk.first;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArticleRepositoryMemoryImplTest {

    @Test
    public void findall_Enty() {
        // GIWEN
        ArticleRepositoryMemoryImpl articleRepositoryMemory = new ArticleRepositoryMemoryImpl();

        // WHEN
        List<ArticleDto> result=articleRepositoryMemory.findall();

        // THEN
        assertEquals(0,result.size());
    }

    @Test
    public void findAll_NotEmpty() {
        // GIWEN
        ArticleRepositoryMemoryImpl articleRepositoryMemory = new ArticleRepositoryMemoryImpl();
        ArticleDto articleDto=new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(2l);
        articleDto.setTitle("title");
        articleRepositoryMemory.save(articleDto);

        // WHEN
        List<ArticleDto> result=articleRepositoryMemory.findall();

        // THEN
        assertEquals(1,result.size());
        assertEquals(articleDto,result.get(0));

    }

    @Test
    public void findArticleById() {
        // GIWEN
        ArticleRepositoryMemoryImpl articleRepositoryMemory = new ArticleRepositoryMemoryImpl();
        Long id=2l;
        ArticleDto articleDto=new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");
        articleRepositoryMemory.save(articleDto);

        // WHEN
        int result= articleRepositoryMemory.findArticleById(id);
        // THEN
        assertEquals(0,result);

    }

    @Test
    public void findArticleById_NotFound() {
        // GIWEN
        ArticleRepositoryMemoryImpl articleRepositoryMemory = new ArticleRepositoryMemoryImpl();
        Long id=2l;
        Long notExistsId = 4L;
        ArticleDto articleDto=new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleRepositoryMemory.save(articleDto);

        // WHEN
        int result = articleRepositoryMemory.findArticleById(notExistsId);
        // THEN
        assertEquals(-1, result);

    }
    @Test
    void deleteById(){
        // GIWEN
        ArticleRepositoryMemoryImpl articleRepositoryMemory = new ArticleRepositoryMemoryImpl();
        Long id=2l;
        ArticleDto articleDto=new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");
        articleRepositoryMemory.save(articleDto);

        // WHEN
        articleRepositoryMemory.deleteById(id);
        // THEN
        assertEquals(0,articleRepositoryMemory.findall().size());
    }
    @Test
    void deleteById_notExists(){
        // GIWEN
        ArticleRepositoryMemoryImpl articleRepositoryMemory = new ArticleRepositoryMemoryImpl();
        Long id = 2L;
        Long notExistsId = 4L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleRepositoryMemory.save(articleDto);

        // WHEN
        articleRepositoryMemory.deleteById(notExistsId);

        // THEN
        assertEquals(1, articleRepositoryMemory.findall().size());
    }
    @Test
    void getById_notExists(){
        // GIVEN
        ArticleRepositoryMemoryImpl articleRepositoryMemory = new ArticleRepositoryMemoryImpl();
        Long id = 2L;
        Long notExistsId = 4L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleRepositoryMemory.save(articleDto);

        // WHEN
        ArticleDto dto = articleRepositoryMemory.getById(notExistsId);

        // THEN
        assertNull(dto);
    }

    @Test
    void getById_Exists() {
        // GIVEN
        ArticleRepositoryMemoryImpl articleRepositoryMemory = new ArticleRepositoryMemoryImpl();
        Long id = 2L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleRepositoryMemory.save(articleDto);

        // WHEN
        ArticleDto dto = articleRepositoryMemory.getById(id);

        // THEN
        assertEquals(articleDto, dto);
    }
    @Test
    void save_update(){
        // GIWEN
        ArticleRepositoryMemoryImpl articleRepositoryMemory = new ArticleRepositoryMemoryImpl();
        Long id=2l;
        ArticleDto articleDto=new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");
        articleRepositoryMemory.save(articleDto);

        // WHEN
        ArticleDto articleDto2=new ArticleDto();
        articleDto2.setAuthor("Author 2");
        articleDto2.setPages(14);
        articleDto2.setId(id);
        articleDto2.setTitle("title 2");
        articleRepositoryMemory.save(articleDto2);
        // THEN
        List<ArticleDto> articleDtoList=articleRepositoryMemory.findall();
        assertEquals(1,articleRepositoryMemory.findall().size());

        assertEquals(articleDto2,articleDtoList.get(0));
    }
}