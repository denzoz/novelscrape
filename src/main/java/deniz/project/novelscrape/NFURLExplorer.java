package deniz.project.novelscrape;

/**
 *
 * @author denzoz
 */

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;

public class NFURLExplorer {

    /**
     * @param args the command line arguments
     */
    public NFURLExplorer() {
        NFLatestSelect x = new NFLatestSelect();
        String target = x.getSelectionURL();
        try {
            Document doc = Jsoup.connect(target).get();
            Elements synopsis = doc.getElementsByClass("desc-text");
            // TODO: List<Node> childNodes = synopsis.childNodes();
            System.out.println(synopsis.text());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
}
