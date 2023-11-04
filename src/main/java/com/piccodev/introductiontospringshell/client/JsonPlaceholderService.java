package com.piccodev.introductiontospringshell.client;

import com.piccodev.introductiontospringshell.model.PostResponse;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface JsonPlaceholderService {

    @GetExchange("/posts")
    List<PostResponse> loadPosts();

    @GetExchange("/posts/{id}")
    PostResponse findById(Integer id);
}
