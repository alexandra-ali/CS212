/**
    * Have program read through a text file. Turn words into nodes in WordNode class
    * Put words into UnsortedWordList and alphabetical SortedWordList
    * Display classes into a GUI grid with 1 row and 2 columns
    * @author Alexandra Ali
    * @since 11.02. 2020
    * @version 1.0
    * @throws java.io.IOException
        *thrown if any I/O error occured
    * @returns GUI which shows list of words, one as they appear (unsorted), other as alphabetical (sorted)
    */
import java.io.*;
import java.util.StringTokenizer;

/**
 * Read text file line by line and put words into unsorted and sorted class
 */

public class Project2 {

    public static void main (String[] args){
        /**
         * Create and initialize new classes for UnsortedWordList and SortedWordList.
         */
        SortedWordList swl= new SortedWordList();
        UnsortedWordList uswl= new UnsortedWordList();

        try {
            /**
             * Use try and catch to determine 'null' inputs
             * Read from input file: Project2Input.txt.
             * Buffered reader reads through all characters in input efficiently
             */
            File file= new File("Project2Input.txt");
            BufferedReader br= new BufferedReader(new FileReader(file));
            String line = br.readLine();

            /**
             * While loop goes through each line of text file and adds each word into USWL and SWL class.
             */
            while( line != null){
                /** Use tokenizer to only consider characters part of a word
                 * Each token separated by 'null' (space)
                 */
                StringTokenizer tokenizer= new StringTokenizer(line);
                while(tokenizer.hasMoreTokens()){
                    String word= tokenizer.nextToken();
                    swl.add(new Word(word)); /** *add word to swl class **/
                    uswl.add(new Word(word)); /** *add word to uswl class **/

                }
                line = br.readLine();
            }
            br.close();/** closes buffered reader */
            /** catch used to trace and throw exceptions in file reader */
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * Create and initialize GUI
         */
        WordGUI gui = new WordGUI();

        /**
         * Creates and initializes nodes for uswl class
         */
        WordNode currNode = uswl.first.next;
        while(currNode != null){
            gui.unsortedArea.append(currNode.data.w + "\n"); /** *each word in class is appended into gui **/
            currNode= currNode.next;
        }

        /**
         * Creates and initializes nodes for swl class
         */
        currNode = swl.first.next;
        while(currNode != null){
            gui.sortedArea.append(currNode.data.w + "\n"); /** *each word in class is appended into gui **/
            currNode= currNode.next;
        }
        return;
    }

}
