/**
 * Create word class that sorts each word and marks as invalid
 * @author Alexandra Ali
 * @since 11.20. 2020
 * @version 1.0
 * @returns compared words
 */

public class Word implements Comparable<Word>{

    String w;


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
            /**
             * adds word to invalid list
             */
            Project3.invalidList.add(this);
        }

    }

    /**
     * Compares each word for sorted list
     * @param o
     * @return sorted word
     */
    @Override
    public int compareTo(Word o) {
        return this.w.compareToIgnoreCase(o.w);
    }
}
