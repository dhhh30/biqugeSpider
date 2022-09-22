import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
abstract class AbstractParser {
    private static final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build();

    String error;
    int statusCode;
    public Document setPage(String URL) throws IOException {
        Document doc = Jsoup.connect(URL).get();
        return doc;
    }

}
