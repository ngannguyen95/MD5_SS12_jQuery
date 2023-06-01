package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ra.model.Catalog;
import ra.service.catalog.ICatalogService;

import java.nio.file.OpenOption;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/catalogs")
public class CatalogController {
    @Autowired
    private ICatalogService catalogService;

    @GetMapping
    public ResponseEntity<Iterable<Catalog>> getListCatalog() {
        List<Catalog> catalogs = (List<Catalog>) catalogService.findAll();
        if (catalogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(catalogs,HttpStatus.OK);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Catalog> createCatalog(@RequestBody Catalog catalog) {
        Catalog catalog1 = catalogService.save(catalog);
        return new ResponseEntity<>(catalog1,HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Catalog> updateCatalog(@PathVariable("id") Long id, @RequestBody Catalog catalog) {
        Optional<Catalog> catalogOptional = catalogService.findById(id);
        if (catalogOptional.isPresent()) {
            catalog.setId(id);
            catalogService.save(catalog);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Catalog> deleteCatalog(@PathVariable("id") Long id, @RequestBody Catalog catalog) {
       Optional<Catalog> catalogOptional=catalogService.findById(id);
       if (catalogOptional.isPresent()){
           catalogService.delete(id);
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }


}
