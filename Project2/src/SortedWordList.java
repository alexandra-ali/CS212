/**
 * Create SortedWordList class that sorts words from WordList class into alphabetical order
 * @author Alexandra Ali
 * @since 11.02. 2020
 * @version 1.0
 * @returns words from text file sorted in alphabetical order
 */
public class SortedWordList extends WordList{
    /**
     * Create constructor that connects to 'super' which is WordList class
     */
    public SortedWordList(){
        super();
    }

    /**
     * Create one argument method that adds word to sorted word list after being sorted
     * @param w
     */
    public void add(Word w){
        /**
         * create and initialize new nodes for current node and following (next) node
         */
        WordNode newNode= new WordNode(w);
        WordNode currNode = this.first;
        WordNode currNextNode= this.first.next;

        /**
         * Go through entire length of wordlist to sort out words
         */
        for(int i = 0; i<length; i++){
            /**
             * Use compareTo method to compare each character in string to put in alphabetical order
             */
            if(newNode.data.w.compareToIgnoreCase(currNextNode.data.w) < 0){
                break;
            }
            /**
             * Changes the current node to the next following node
             */
            currNode = currNode.next;
            currNextNode = currNode.next;
        }
        /**
         * A swap is preformed that switches the position of the sorted word in list
         * length of swl is incremented
         */
        currNode.next = newNode;
        newNode.next= currNextNode;
        this.length++;


    }
}
