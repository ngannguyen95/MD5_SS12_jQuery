package ra.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.model.Blog;

import java.util.List;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog,Long> {
    @Query("select b from Blog as b where b.catalog.id =:cata_id")
    Iterable<Blog> findBlogByCatalog_Id(@Param("cata_id") Long cata_id);
}
