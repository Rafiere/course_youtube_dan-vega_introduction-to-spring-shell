package com.piccodev.introductiontospringshell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;


//Essa anotação essa classe contém shell methods, assim, são métodos que podem ser chamados através do Shell.
@ShellComponent
public class HelloCommands {

    //O @ShellOption serve para customizarmos um parâmetro que será utilizado nesse comando.

    //O @ShellMethod define que esse método poderá ser executado através do Shell.
    @ShellMethod(key = "hello-world")
    public String hello(@ShellOption(defaultValue = "World!") String arg){

        return "Hello, " + arg;
    }
}
