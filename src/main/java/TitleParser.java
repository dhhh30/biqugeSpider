import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TitleParser extends AbstractParser{
    String URL;
    Document doc;
    @Override
    public String getPage(String URL) throws IOException, InterruptedException {
        doc = Jsoup.parse(super.getPage(URL));

        return ("Success");
    }

    Element titleList = doc.getElementById("info");
    Elements title = titleList.getElementsByTag("h1");
    Elements author = doc.select("#info > p:nth-child(2) > a:nth-child(1)");
    String authorName;
    String titleText;
    AuthorStructure AuthorStructure;

    public void authorStructure(){
        AuthorStructure authorStructure = new AuthorStructure();
        authorStructure.authorName = authorName;
        authorStructure.title = titleText;
        this.AuthorStructure = authorStructure;
    }
    public void parseToAuthorStructure(){
         try {

         } catch (Exception e) {

         }
        for (Element authorText : author){
            authorName = authorText.text();
        }
        for (Element title : title){
            titleText = title.text();
        }
        authorStructure();
    }
}
