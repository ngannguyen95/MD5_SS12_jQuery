package ra.service.blog;

import ra.model.Blog;
import ra.service.IGenerateService;

public interface IBlogService extends IGenerateService<Blog,Long> {
    Iterable<Blog> findBlogByCatalog_Id(Long id);
}
