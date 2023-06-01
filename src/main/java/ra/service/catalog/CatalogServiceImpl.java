package ra.service.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.model.Catalog;
import ra.repository.ICatalogRepository;

import java.util.Optional;
@Service
public class CatalogServiceImpl implements ICatalogService{
    @Autowired
    private ICatalogRepository catalogRepository;


    @Override
    public Iterable<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Optional<Catalog> findById(Long id) {
        return catalogRepository.findById(id);
    }

    @Override
    public Catalog save(Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    @Override
    public void delete(Long id) {
catalogRepository.deleteById(id);
    }


}
