import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class TitleParser extends AbstractParser{
    String URL;
    //0: cssPath 1:titleListId 2:titleTag
    String[] Param;
    Document doc;
    Element titleList = doc.getElementById(Param[1]);
    Elements title = titleList.getElementsByTag(Param[2]);
    Elements author = doc.select(Param[0]);
    String authorName;
    String titleText;
    AuthorStructure AuthorStructure;
    public void authorStructure(){
        AuthorStructure authorStructure = new AuthorStructure();
        authorStructure.authorName = authorName;
        authorStructure.title = titleText;
        this.AuthorStructure = authorStructure;
    }
    public AuthorStructure  parseToAuthorStructure(){
         try {
             doc = this.setPage(URL);
         } catch (Exception e) {

         }
        for (Element authorText : author){
            authorName = authorText.text();
        }
        for (Element title : title){
            titleText = title.text();
        }
        authorStructure();
        return AuthorStructure;
    }
    public void setURL(String URL){
        this.URL = URL;
    }
    public void setParamArray(String[] Param){
        //Array for parsing parameters
        this.Param = Param;

    }
}
