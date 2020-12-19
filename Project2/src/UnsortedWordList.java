/**
 * Create UnsortedWordList class to display all words in order
 * @author Alexandra Ali
 * @since 11.02. 2020
 * @version 1.0
 * @returns words from WordList class into this class in order from text file
 */
public class UnsortedWordList extends WordList {
    /**
     * Create constructor that connects to 'super' which is WordList class
     */
    public UnsortedWordList(){
        super();
    }

    /**
     * Create one argument constructor that adds/appends word 'w' from WordList class to USWL class
     * @param w
     */
    public void add(Word w){
        super.append(w);
    }
}
