import java.util.Scanner;
public class Main {
    protected void LinkWrite(ContentList contentList){

    }
    public static void Main(String args[]) {
        Scanner StandardInput = new Scanner(System.in);
        System.out.println("Enter index page for xbiquge.so:");
        String titleURL = StandardInput.nextLine();
        TitleParser titleParser = new TitleParser();
        titleParser.setURL(titleURL);
        XmlLoader xmlLoader = new XmlLoader();
        titleParser.setParamArray(xmlLoader.parseToTitleParamArray("xbiquge.xml"));
        AuthorStructure bookInfo = titleParser.parseToAuthorStructure();
        System.out.println("Complete reading title info for this book, now parsing links...");
    }
}
