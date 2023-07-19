import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JavaHttpClient implements  HttpAdapter {

    @Override
    public HttpResponse<String> httpGet(String url) {

        try {

        java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

            return client.send(request, HttpResponse.BodyHandlers.ofString());

    } catch (Exception e) {

        throw new RuntimeException("Impossível realizar a operação HTTP solicitada!");

    }

    }
}
