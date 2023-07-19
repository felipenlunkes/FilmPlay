import com.google.gson.Gson;

import java.io.IOException;
import java.net.URLEncoder;
import java.net.http.HttpResponse;

public class Engine {

    private static String apiKey = ""; // Adicione sua chave de API aqui
    private static String adress = "http://www.omdbapi.com/?t=";
    private static String parameters = "&apikey=";

    private HttpAdapter http; // Adaptador HTTP

    public Engine(HttpAdapter http) {
        this.http = http;
    }

    public FilmEntity searchEngine(String filmQuery) throws IOException, InterruptedException {

        String filmQueryEncoded = URLEncoder.encode(filmQuery, "UTF-8");

        String fullQuery = adress + filmQueryEncoded + parameters + apiKey;

        HttpResponse<String> response = http.httpGet(fullQuery);

        String json = response.body();

        Gson gson = new Gson();

        return gson.fromJson(json, FilmEntity.class);

}

}
