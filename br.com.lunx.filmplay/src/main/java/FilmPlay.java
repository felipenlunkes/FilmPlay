import com.google.gson.Gson;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FilmPlay {

    private static String apiKey = ""; // Adicione sua chave de API aqui
    private static String adress = "http://www.omdbapi.com/?t=";
    private static String parameters = "&apikey=";
    private static boolean newFilm = true;

    public static void main(String[] args) throws IOException, InterruptedException {

        FilmsEntity film = new FilmsEntity();

        System.out.print("\nSeja bem-vindo ao FilmPlay! Aqui você pode obter mais informações sobre filmes!");

        while (newFilm) {

            System.out.print("\nPara começar, insira o nome de um filme (ENTER para sair): ");

            Input input = new Input();

            String filmQuery = input.getString();

            if (filmQuery.isEmpty()){

                break;

            }

            String fullQuery = adress + filmQuery + parameters + apiKey;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(fullQuery))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            Gson gson = new Gson();

            FilmsEntity databaseFilm = gson.fromJson(json, FilmsEntity.class);

            System.out.println("\nInformações sobre seu filme:");

            System.out.println(databaseFilm);

        }

        System.out.println("\nAté mais!");

    }
}
