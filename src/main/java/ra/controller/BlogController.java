package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.model.Blog;
import ra.service.blog.IBlogService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping
    public ResponseEntity<Iterable<Blog>> findAllBlog(){
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(blogs,HttpStatus.OK);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog){
        Blog b = blogService.save(blog);
        return new ResponseEntity<>(b,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable("id") Long id,@RequestBody Blog blog){
        Optional<Blog> blogOptional= blogService.findById(id);
        if (blogOptional.isPresent()){
            blog.setId(id);
            blogService.save(blog);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable("id") Long id){
        Optional<Blog> blogOptional = blogService.findById(id);
        if (blogOptional.isPresent()){
            blogService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/findBlogByCataId/{id}")
    public ResponseEntity<Iterable<Blog>> findBlogByCataId(@PathVariable("id") Long id){
        List<Blog> blogs= (List<Blog>) blogService.findBlogByCatalog_Id(id);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(blogs,HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable("id") Long id){
        Optional<Blog> blog= blogService.findById(id);
        if (blog.isPresent()){
            return new ResponseEntity<>(blog.get(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
