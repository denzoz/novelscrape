package deniz.project.novelscrape;

/**
 *
 * @author denzoz
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class NovelFullURLExplorer {

    /**
     * @param args the command line arguments
     */
    public NovelFullURLExplorer() {
        NovelFullLatestSelector first = new NovelFullLatestSelector();
        String target = first.getSelectionURL();
        Document doc = Jsoup.connect(target).get();
        // String synopsis = doc.select(".desc-text");
    }
}
