package com.example.DataInterview.requests;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class DataHttpRequest {

    public HttpResponse<String> sendFootballDataRequest(String uri,String headerName, String headerValue) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header(headerName, headerValue)
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
