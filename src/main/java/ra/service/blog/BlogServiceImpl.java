package ra.service.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.Blog;
import ra.repository.IBlogRepository;

import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Iterable<Blog> findBlogByCatalog_Id(Long id) {
        return blogRepository.findBlogByCatalog_Id(id);
    }

    @Override
    public Iterable<Blog> searchBlogByTitle(String title) {

        return blogRepository.searchBlogByTitle(title);
    }


}
