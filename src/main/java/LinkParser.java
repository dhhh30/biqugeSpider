import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
public class LinkParser extends AbstractParser {


    String URL;
    Document doc;
    private Element linkDivider = doc.getElementById("list");
    private Elements linksWithTop = linkDivider.getElementsByTag("dd");
    ArrayList<String> LinkList = new ArrayList<String>();

    @Override
    public String getPage(String URL) throws IOException, InterruptedException {
        doc = Jsoup.parse(super.getPage(URL));
        return ("Success");
    }

    //Main logic
    private void writeToLinkList(){
        int i = 0;
        for (Element IndividualLink : linksWithTop){

            if (i <= 12){
                i++;
            } else if (i > 12) {
                LinkList.add(URL+IndividualLink.attr("href"));
                i++;
            }
        }
    }

    public void parseToLinkList() {
        writeToLinkList();
    }
}
