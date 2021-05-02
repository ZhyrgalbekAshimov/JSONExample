import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        HttpURLConnectionExample obj = new HttpURLConnectionExample();

        // Sending HTTP GET request
        // and getting JSON from URL
        String jsonFromUrl = obj.sendGet();


        // JSON to class
        Gson gson = new Gson();

        Type listType = new TypeToken<List<MyClass>>(){}.getType();
        List<MyClass> listOfObjects = gson.fromJson(jsonFromUrl, listType);

        // Printing

        System.out.println("\nNumber of objects: " + listOfObjects.size() + "\n");

        for (MyClass list: listOfObjects) {
            System.out.println(list + "\n============================================");

        }

    }
}

class HttpURLConnectionExample {

    String sendGet() throws Exception {

        String url = "https://jsonplaceholder.typicode.com/posts";

        HttpURLConnection httpClient = (HttpURLConnection) new URL(url).openConnection();

        // optional default is GET
        httpClient.setRequestMethod("GET");

        //add request header
        httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = httpClient.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(httpClient.getInputStream()))) {

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            return response + "";
        }

    }
}