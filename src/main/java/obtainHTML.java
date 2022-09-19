import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;

public class obtainHTML {
    private static final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build();
    String html;
    String error;
    int statusCode;
    public void getPage(String URL) throws IOException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("User-Agent", "Mozilla/5.0 " +
                        "(Macintosh; Intel Mac OS X 10_14_6) " +
                        "AppleWebKit/537.36 (KHTML, " +
                        "like Gecko) Chrome/104.0.0.0 Safari/537.36")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            this.html = response.body();
            this.statusCode = response.statusCode();
        } catch (Exception e){
            this.error =  ("Error while requesting html");
        }
    }
}
