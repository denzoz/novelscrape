package deniz.project.novelscrape;

/**
 *
 * @author denzoz
 */
public class NFURLExplorer {

    /**
     * @param args the command line arguments
     */
    public void NFURLExplorer() {
        NFLatestSelect x = new NFLatestSelect();
        String target = x.getSelectionURL();
        System.out.println(target);
        
    }
}
