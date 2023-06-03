package ra.service.blog;

import ra.model.Blog;
import ra.service.IGenerateService;

import java.util.Optional;

public interface IBlogService extends IGenerateService<Blog,Long> {
    Iterable<Blog> findBlogByCatalog_Id(Long id);
    Iterable<Blog> searchBlogByTitle(String title);
}
