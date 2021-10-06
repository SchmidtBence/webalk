package hu.me.iit.webalk.first;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleServiceImpl implements ArticleService {
    private final int MAXIMUM_ARTICLE_COUNT = 10;
    private ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<ArticleDto> findall() {
        return articleRepository.findall();
    }

    @Override
    public ArticleDto getById(Long id) {
        return articleRepository.getById(id);
    }

    @Override
    public Long save(ArticleDto articleDto) {

        if(articleRepository.findall().size() >= MAXIMUM_ARTICLE_COUNT) {
            throw new TooManyArticleException();
        }
        return articleRepository.save(articleDto);
    }

    @Override
    public void deleteById(Long id) {
        articleRepository.deleteById(id);
    }
}
