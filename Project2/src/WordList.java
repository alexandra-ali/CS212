/**
 * Create abstract WordLst class that takes each WordNode
 * Add each node to list
 * @author Alexandra Ali
 * @since 11.02. 2020
 * @version 1.0
 * @returns Word list of all words from text file
 */
public abstract class WordList {
    /**
     * Create protected WordNodes first and last variables in list
     * Create protected integer variable
     */
    protected WordNode first;
    protected WordNode last;
    protected int length;

    /**
     * Create WordList constructor that initializes protected variables
     */
    public WordList(){
        /**
         * Make first and last variables empty 'null' nodes
         * Make length 0
         */
        this.first = new WordNode(null);
        this.last = first;
        this.length = 0;
    }

    /**
     * Create append method to add each node to WordList
     * @param w
     */
    public void append(Word w){
       WordNode newNode = new WordNode(w);
        /**
         * Make last variable to new wordnode to extend length to delimit list
         * Increment length of list
         */
       this.last.next = newNode;
       this.last = newNode;

       length++;
    }
}
