package deniz.project.novelscrape;

/**
 *
 * @author denzoz
 */

// importing some JSoup stuff
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

// IOException used to show if there is an input/output error
import java.io.IOException;

// Scanner used to get input
import java.util.Scanner;       
        
public class NovelFullLatestSelector {

    private int selection; // if you are going to change access to a variable,
                           // must be at class-level 
    
    public NovelFullLatestSelector() {
        try {
            // JSoup just fetching the website
            Document doc = Jsoup.connect("https://novelfull.com/latest-release-novel").get();
            
            // print title of page: System.out.printf("Title: %s", doc.title());
            // use printf to use %s which means to format string

            Elements novels = doc.getElementsByClass("row");
            int novelCounter = 0;
            for (Element novel : novels) { // for every novel in the group of novels we have do this
                String novelName = novel.getElementsByClass("truyen-title").text();
                String novelAuthor = novel.getElementsByClass("author").text();
                if (!(novelName.trim().length() == 0 || novelAuthor.trim().length() == 0)) {
                    novelCounter++;
                    System.out.println(novelCounter + ") " +novelName + " by " + novelAuthor + "\n");
                    
                } // this ignores any blanks that also have the same 'truyen-title' or 'author' class
            }
            
            System.out.println("Latest novel releases: ");
            // take user's novel selection and validate
            while (true) {
                System.out.println("Enter novel selection: ");
                Scanner inputTaker = new Scanner(System.in);
                selection = inputTaker.nextInt();
                if (selection > 0 && selection < novelCounter + 1) {
                    break;
                } else {
                    System.out.println("Invalid selection, please try again");
                }
            }
            // TODO: String selectionURL =
            

        } catch (IOException e) { //  if there is an input/output error do this
            e.printStackTrace(); // usually you put e
        }
    }
//
//    public int getSelection() {
//        return selection;
//    }
////    public selectionGet(String [args]) {
////        SelectionTake x = new SelectionTake();
////        return x.selection;
////    } TODO: add getter for selection
}
