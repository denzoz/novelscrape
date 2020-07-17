package deniz.project.novelscrape;

/**
 *
 * @author denzoz
 */

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.TextNode;
import java.util.List;


public class NFURLExplorer {

    public NFURLExplorer() {
        NFLatestSelect x = new NFLatestSelect();
        String targetURL = x.getSelectionURL();
        try {
            Document doc = Jsoup.connect(targetURL).get();
            Elements synopsisBox = doc.getElementsByClass("desc-text");
            List<TextNode> synopsisTextNodes = synopsisBox.textNodes();
            for (TextNode node : synopsisTextNodes) {
                System.out.println(node.getWholeText());
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
}
