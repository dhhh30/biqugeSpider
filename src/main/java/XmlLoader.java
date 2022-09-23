import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class XmlLoader {
    private Document doc;
    private DocumentBuilder builder;
    private String[] ParamArray;
    private String idTag = "id";
    private String titleTag ="titletag";
    private String LinkListid = "listid";
    private String cssPath = "csspath";
    private String ignoreAmount = "ignoreamount";
    public String titleID;
    public String CSSPath;
    public String TitleTag;
    public String[] parseToTitleParamArray(String Path){
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (Exception e){
            System.out.println("Error configuring XML builder");
        }
        NodeList nodeList = doc.getElementsByTagName("parser");
        Node mainElement = nodeList.item(0);
        nodeList = mainElement.getChildNodes();
        mainElement = nodeList.item(0);
        nodeList = mainElement.getChildNodes();
        int nodeLength = nodeList.getLength();
        Node current;
        for (int i = 0; i<nodeLength;i++){
            current = nodeList.item(i);
            if (current.getNodeType() == Node.ELEMENT_NODE){
                if (current.getNodeName().equals(idTag)){
                    titleID = current.getTextContent();
                }
                else if (current.getNodeName().equals(titleTag)){
                    titleTag = current.getTextContent();
                }
                else if (current.getNodeName().equals(cssPath)){
                    CSSPath = current.getTextContent();
                }
            }
        }
        ParamArray[0] = CSSPath;
        ParamArray[1] = titleID;
        ParamArray[2] = titleTag;
        return ParamArray;
    }
}
