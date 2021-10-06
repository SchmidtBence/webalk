package hu.me.iit.webalk.first;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("article")
public class MainController {

    //private final List<ArticleDto> articles=new ArrayList<>();
    private final ArticleService articleService;

    public MainController(ArticleService articleService) {
        this.articleService =articleService;
    }

    @GetMapping(path="", produces= MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> allArticles() {
        return articleService.findall();
    }

    @PostMapping("")
    public void newArticle(@RequestBody @Valid ArticleDto articleDto) {
        articleService.save(articleDto);
        }

    @PutMapping(path="/")
    public void replaceArticle(@RequestBody @Valid ArticleDto articleDto) {
        articleService.save(articleDto);
    }

    @DeleteMapping("/{id}")
    public void DeleteArticle(@PathVariable("id") Long id) {
        articleService.deleteById(id);
    }
}