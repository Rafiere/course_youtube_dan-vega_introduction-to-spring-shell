package com.piccodev.introductiontospringshell.client;

import com.piccodev.introductiontospringshell.model.Post;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface JsonPlaceholderService {

    @GetExchange("/posts")
    List<Post> loadPosts();

    @GetExchange("/posts/{id}")
    Post findById(Integer id);
}
