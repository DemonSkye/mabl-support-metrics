package com.mabl.supportMetrics;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;


public class RequestHandler {

    public static String intercomRequest(String id){

        String responseBody = "";
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(60))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.intercom.io/conversations/" + id +"?per_page=60"))
                .setHeader("Authorization", "Bearer " + Credentials.getIntercomApi())
                .setHeader("Accept", "application/json")
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            // Headers here, currently discarding
            HttpHeaders headers = response.headers();
            //System.out.println("Headers:");
            headers.map().forEach((k, v) -> System.out.println(k + ":" + v));
            System.out.println("\r\n\r\n");

            // print status code
            //System.out.println(response.statusCode());

            // print response body
            //System.out.println(response.body());
            responseBody = response.body();
        }catch (Exception e) { e.printStackTrace(); }
        return responseBody;
    }



    public static void sheetsRequest(){

    }
}
