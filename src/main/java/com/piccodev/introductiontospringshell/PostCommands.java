package com.piccodev.introductiontospringshell;

import com.piccodev.introductiontospringshell.client.JsonPlaceholderService;
import com.piccodev.introductiontospringshell.model.PostResponse;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.ArrayTableModel;
import org.springframework.shell.table.BorderStyle;
import org.springframework.shell.table.TableBuilder;

import java.util.ArrayList;
import java.util.List;

@ShellComponent
public class PostCommands {

    private List<PostResponse> postResponses = new ArrayList<>();
    private final JsonPlaceholderService jsonPlaceholderService;

    public PostCommands(JsonPlaceholderService jsonPlaceholderService) {
        this.jsonPlaceholderService = jsonPlaceholderService;
    }

    @ShellMethod(key = "load-posts")
    public void loadPosts() {
        //https://jsonplaceholder.typicode.com/posts
        postResponses = jsonPlaceholderService.loadPosts();


    }

    @ShellMethod(key = "list-posts")
    public void listPosts() {

        //Estamos criando uma tabela para exibir os dados na CLI.
        ArrayTableModel model = new ArrayTableModel(
                postResponses.stream()
                        .map(postResponse -> new String[]
                                {postResponse.id().toString(),
                                        postResponse.userId().toString(),
                                        postResponse.title()}).toArray(String[][]::new));

        TableBuilder tableBuilder = new TableBuilder(model);
        tableBuilder.addInnerBorder(BorderStyle.fancy_light);

        System.out.println(tableBuilder.build().render(80));
    }
}
