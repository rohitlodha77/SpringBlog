package com.example.blog.Blog.controller;

import com.example.blog.Blog.dto.PostRequest;
import com.example.blog.Blog.model.Post;
import com.example.blog.Blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody PostRequest postRequest) {
        postService.save(postRequest);
        System.out.print(postRequest);
        return new  ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody PostRequest postRequest) {
        postService.update(postRequest);
        System.out.print(postRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> get(@PathVariable Long id) {
        return new ResponseEntity( postService.getPost(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        postService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAll() {
        return new ResponseEntity(postService.getAllPost(), HttpStatus.OK);
    }
}