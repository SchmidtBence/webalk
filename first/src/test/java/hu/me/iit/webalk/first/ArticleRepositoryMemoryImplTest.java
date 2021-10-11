package hu.me.iit.webalk.first;

import java.util.List;

import static org.junit.Assert.*;

public class ArticleRepositoryMemoryImplTest {

    @org.junit.Test
    public void findall_Enty() {
        // GIWEN
        ArticleRepositoryMemoryImpl articleRepositoryMemory = new ArticleRepositoryMemoryImpl();

        // WHEN
        List<ArticleDto> result=articleRepositoryMemory.findall();

        // THEN
        assertEquals(0,result.size());
    }

    @org.junit.Test
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

    @org.junit.Test
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

    @org.junit.Test
    public void findArticleById_NotFound() {
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
        assertEquals(0,articleRepositoryMemory.findall().size());

    }
    void deleteById(){
        // GIWEN
        ArticleRepositoryMemoryImpl articleRepositoryMemory = new ArticleRepositoryMemoryImpl();
        Long id=2l;
        Long notExists=4l;
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
    void deleteById_notExists(){
        // GIWEN
        ArticleRepositoryMemoryImpl articleRepositoryMemory = new ArticleRepositoryMemoryImpl();
        Long id=2l;
        Long notExists=4l;
        ArticleDto articleDto=new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");
        articleRepositoryMemory.save(articleDto);

        // WHEN
        articleRepositoryMemory.deleteById(id);
        // THEN
        assertEquals(1,articleRepositoryMemory.findall().size());
    }
    void getById_notExists(){
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
        ArticleDto dto=articleRepositoryMemory.getById(id);
        // THEN
        assertEquals(articleDto,dto);
    }
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

        assertEquals(articleDto2,articleRepositoryMemory.getById(id));
    }
}