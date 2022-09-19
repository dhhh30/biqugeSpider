import java.util.Scanner;
public class Main {
    public static void Main() {
        Scanner StandardInput = new Scanner(System.in);
        System.out.println("Enter index page for xbiquge.so:");
        String titleURL = StandardInput.nextLine();
        TitleParser titleParser = new TitleParser();
        titleParser.URL = titleURL;
        titleParser.parseToAuthorStructure();
        AuthorStructure bookInfo = titleParser.AuthorStructure;
        System.out.println("Complete reading title info for this book, now parsing links...");

    }
}
