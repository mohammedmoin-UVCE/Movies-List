package com.prio;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api extends JFrame {
    String title;
    String id;
    Api(String title,String id) throws IOException, InterruptedException {
        this.id=id;
        this.title=title;
        var url="http://www.omdbapi.com/?s="+title+"&apikey=b95b45ac";
        var request= HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        var client = HttpClient.newBuilder().build();
        var response=client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());

        new Display(response.body(),id).setVisible(true);
    }
    public static void main(String[] args)throws IOException,InterruptedException {
        new Api("","").setVisible(true);
    }
}
