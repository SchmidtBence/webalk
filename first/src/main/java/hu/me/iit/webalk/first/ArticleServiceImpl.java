package hu.me.iit.webalk.first;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {
    private final int MAXIMUM_ARTICLE_COUNT;
    private ArticleRepository articleRepository;

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
            throw new TooManyArticleException;
        }
        return articleRepository.save(articleDto);
    }

    @Override
    public void deleteById(Long id) {

    }
}
