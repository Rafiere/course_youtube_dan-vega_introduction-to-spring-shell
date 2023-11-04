package com.piccodev.introductiontospringshell;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.piccodev.introductiontospringshell.model.DadJokeResponse;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@ShellComponent
public class DadJokeCommands {

    @ShellMethod(key = "random", value = "Fetch a random dad joke")
    public DadJokeResponse getRandomDadJoke() throws IOException, InterruptedException {

        //GET https://iconhazdadjoke.com

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest
                .newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create("https://icanhazdadjoke.com"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(response.body(), DadJokeResponse.class);
    }
}
