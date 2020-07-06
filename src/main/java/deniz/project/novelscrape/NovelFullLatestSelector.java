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
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
        
public class NovelFullLatestSelector {

    private int selection; // if you are going to change access to a variable,
                           // must be at class-level 
    private String selectionURL;
    
    public NovelFullLatestSelector() {
        try {
            // JSoup just fetching the website
            Document doc = Jsoup.connect("https://novelfull.com/latest-release-novel").get();
            
            // print title of page: System.out.printf("Title: %s", doc.title());
            // use printf to use %s which means to format string

            Elements novels = doc.getElementsByClass("row");
            int novelCounter = 0;
            ArrayList<String> novelNames = new ArrayList<String>();
            System.out.println("Latest novel releases: \n");
            for (Element novel : novels) { // for every novel in the group of novels we have do this
                String novelName = novel.getElementsByClass("truyen-title").text();
                novelNames.add(novelName); // arraylist of all novel names for later
                String novelAuthor = novel.getElementsByClass("author").text();
                if (!(novelName.trim().length() == 0 || novelAuthor.trim().length() == 0)) {
                    novelCounter++;
                    System.out.println(novelCounter + ") " + novelName + " by " + novelAuthor + "\n");
                } // this ignores any blanks that also have the same 'truyen-title' or 'author' class
            }
            

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
            

            // When using novelNames.get, usually use index number but due to
            // how the site is scraped, index 0 is empy to just use 
            
            String novelName = novelNames.get(selection);
            novelName = novelName.replaceAll(" ✕ ", "-");
            novelName = novelName.replaceAll("[!:'.(),\\s*+]","-").toLowerCase();
            
            Pattern pattern = Pattern.compile("[a-z0-9]$+", Pattern.CASE_INSENSITIVE);
            Matcher matcher;
            boolean matchFound = false;
            while (matchFound == false) {
                matcher = pattern.matcher(novelName);
                matchFound = matcher.find();
                if (matchFound == false) {
                    novelName = novelName.substring(0,novelName.length() - 1);
                }
            }
            // above needs to be able to remove any 'bad' characters at end of
            // string

            // Now going to make the URL linking to the novel's page
            selectionURL = "https://novelfull.com/" + novelName + ".html";
            
            
        } catch (IOException e) { //  if there is an input/output error do this
            e.printStackTrace(); // usually you put e here
        }
    }

    public String getSelectionURL() {
        return selectionURL;
    }
}
