import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Engine {

    private static String apiKey = ""; // Adicione sua chave de API aqui
    private static String adress = "http://www.omdbapi.com/?t=";
    private static String parameters = "&apikey=";

    public FilmEntity searchEngine(String filmQuery) throws IOException, InterruptedException {

        String filmQueryEncoded = URLEncoder.encode(filmQuery, "UTF-8");

        String fullQuery = adress + filmQueryEncoded + parameters + apiKey;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fullQuery))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new Gson();

        FilmEntity databaseFilm = gson.fromJson(json, FilmEntity.class);

        return databaseFilm;

}

}
