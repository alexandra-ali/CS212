/**
 * Create word class that sorts each word and marks as invalid
 * @author Alexandra Ali
 * @since 12.09. 2020
 * @version 1.0
 * @returns compared words
 */

public class Word implements Comparable<Word> {
    public String w;


    public Word(String w){
        this.w=w;
        /**
         * Use a try catch here to throw exceptions
         */
        try{
            /**
             * go through each letter in file
             */
            for(int j= 0 ; j< w.length(); j++){
                if(!Character.isLetter(w.charAt(j))){
                    /**
                     * @throws IllegalWordException
                     */
                    throw new IllegalWordException("invalid word");
                }
            }
        }catch (IllegalWordException ex){

        }

    }

    /**
     * Compares each word for sorted list
     * @return sorted word
     */
    @Override
    public int compareTo(Word o) {
        return this.w.compareToIgnoreCase(o.w);
    }
}
