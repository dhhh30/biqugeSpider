import java.util.Scanner;
public class Main {
    public static void main (String[] args){
        Scanner StandardInput = new Scanner(System.in);
        System.out.println("Enter index page for xbiquge.so:");
        String titleURL = StandardInput.nextLine();
        TitleParser titleParser = new TitleParser();
        try{
        titleParser.getPage(titleURL);}
        catch (Exception e){
            System.out.println("IDK WTF IS WRONG");
        }
        System.out.println("The title is:");
        System.out.println(titleParser.title);
        AuthorStructure bookInfo = titleParser.AuthorStructure;
        System.out.println("Complete reading title info for this book, now parsing links...");
        LinkParser linkParser = new LinkParser();
        try{
        linkParser.getPage(titleURL);}
        catch (Exception e){
            System.out.println("IDK WHAT's WRONT WITH THIS EITHER");
        }
        System.out.println(linkParser.LinkList);
        System.out.println("Complete parsing link to array list, now downloading and parsing content");
        ContentParser contentParser = new ContentParser();
        contentParser.getContentList(linkParser.LinkList);
    }
}
