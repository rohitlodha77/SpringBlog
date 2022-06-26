package com.example.blog.Blog.repository;

import com.example.blog.Blog.model.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<BlogUser, Long> {

    Optional<BlogUser> findByUsername(String username);
}