package com.piccodev.introductiontospringshell;

import com.piccodev.introductiontospringshell.client.JsonPlaceholderService;
import com.piccodev.introductiontospringshell.model.Post;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.ArrayList;
import java.util.List;

@ShellComponent
public class PostCommands {

    private List<Post> posts = new ArrayList<>();
    private final JsonPlaceholderService jsonPlaceholderService;

    public PostCommands(JsonPlaceholderService jsonPlaceholderService) {
        this.jsonPlaceholderService = jsonPlaceholderService;
    }

    @ShellMethod(key = "load-posts")
    public void loadPosts(){
        //https://jsonplaceholder.typicode.com/posts
        posts = jsonPlaceholderService.loadPosts();
    }

    @ShellMethod(key = "list-posts")
    public List<Post> listPosts(){
        return posts;
    }
}
