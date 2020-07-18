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
import java.util.List;
import org.jsoup.nodes.Node;


public class NFURLExplorer {

    public NFURLExplorer() {
        NFLatestSelect x = new NFLatestSelect();
        String targetURL = x.getSelectionURL();
        try {
            Document doc = Jsoup.connect(targetURL).get();
            Element synopsisBox = doc.getElementsByClass("desc-text").get(0);
            // System.out.println(synopsisBox.text()); works but removes whitespaces
            //List<TextNode> synopsisTextNodes = synopsisBox.textNodes();
//            for (TextNode node : synopsisTextNodes) {
//                System.out.println(node.getWholeText());
////            }
//            for (int i = 0; i < synopsisTextNodes.size(); i++) {
//                String stuff = synopsisTextNodes.get(i).getWholeText();
//                System.out.println("From " + targetURL);
//                System.out.println(stuff);
//            }
            for (Node child : synopsisBox.childNodes()) {
                if (child instanceof TextNode) {
                    System.out.println(((TextNode) child).text());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
}
