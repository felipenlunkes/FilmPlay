import java.net.http.HttpResponse;

public interface HttpAdapter {

    HttpResponse<String> httpGet(String url);

}
