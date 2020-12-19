/**
    * Create WordNode class that puts each word from text file as a 'super' class
    * @author Alexandra Ali
    * @since 11.02. 2020
    * @version 1.0
    * @returns
    */
public class WordNode {
    /**
     * Create and initialize instance 'data' and 'next' protected variables
     */
    protected Word data;
    protected WordNode next;

    /**
     * One argument constructor that takes in data
     * @param data
     */
    public WordNode(Word data){
        this.data= data;

    }

}
