package other;


import models.Stock;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class HttpManager {

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    private static final String url = "http://localhost:18380/api/";
    
    public static String getToken(String Login, String Password) throws Exception {

        Map<Object, Object> data = new HashMap<>();
        data.put("login", EncodeBase64(Login));
        data.put("password", EncodeBase64(Password));

        HttpRequest request = HttpRequest.newBuilder()
                .POST(buildJsonFromMap(data))
                .uri(URI.create(url + "UserAuth"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() == 404){
            throw new Exception("Пользователя нет");
        }
        return response.body();
    }
    public static List<Stock> getStocks() throws IOException, InterruptedException {
        List<Stock> result = new ArrayList<>();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://httpbin.org/get"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        // print status code
        System.out.println(response.statusCode());

        // print response body
        System.out.println(response.body());


    }

    private static HttpRequest.BodyPublisher buildJsonFromMap(Map<Object, Object> data) {
        String json = "{";
        for (Map.Entry<Object, Object> entry : data.entrySet()){
            json += "\n\"" + entry.getKey() + "\" : \"" + entry.getValue() + "\",";
        }
        json = json.substring(0, json.length() - 1) + "\n}";
        return HttpRequest.BodyPublishers.ofString(json);
    }

    private static String EncodeBase64(String text){
        return Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
    }
}
