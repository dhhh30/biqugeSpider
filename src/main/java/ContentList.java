import java.util.ArrayList;
import java.util.List;

public class ContentList implements Iterable<ContentStructure>{
    private final List<ContentStructure> cList = new ArrayList<ContentStructure>();
    @Override
    public java.util.Iterator<ContentStructure> iterator() {
        return cList.iterator();
    }
}