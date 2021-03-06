/**
 * Displays file menu that opens directory and files
 * Does main sorting of words
 * adds words to arraylist, treemap and wordgui
 * @author Alexandra Ali
 * @since 12.09. 2020
 * @version 1.0
 * @returns GUI which shows list of words, one as they appear (unsorted), other as alphabetical (sorted)
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.StringTokenizer;

public class FileMenuHandler implements ActionListener {
    /**
     * creates JFrame and creates file chooser
     */
    JFrame jframe;
    static JFileChooser chooser = new JFileChooser();

    public FileMenuHandler (JFrame jf) {
        jframe = jf;
    }
    public void actionPerformed(ActionEvent event) {
        /**
         * creates open and quit functions in file menu
         */
        String menuName = event.getActionCommand();
        if (menuName.equals("Open"))
            this.fileOpen();
        else if (menuName.equals("Quit")){
            System.exit(0);
        }
    }
    public void fileOpen(){
        /**
         * File open function sorts words from chosen file
         */
        int status;
        status= chooser.showOpenDialog(null);
        if(status== JFileChooser.APPROVE_OPTION){
            /**
             * clears each list if selecting consecutive files
             */
            Project4.unsortedList.clear();
            Project4.sortedList.clear();

            try{

                /**
                 * gets selected file and reads from it
                 * use string tokenizer to go through each word and add to arraylist for unsorted words
                 * use string tokenizer to add words into treemap for sorted words
                 * use try/ catch to avoid errors and exceptions
                 */
                File file = FileMenuHandler.chooser.getSelectedFile();

                BufferedReader br= new BufferedReader(new FileReader(file));
                String line = br.readLine();
                StringTokenizer tokenizer;
                /**
                 * file is read using buffered reader
                 * for unsorted arraylist, use add to input word
                 * for sorted treemap, use put and the word object to input word (string)
                 */
                while(line!= null){
                    tokenizer= new StringTokenizer(line);
                    while(tokenizer.hasMoreTokens()){
                        String w = tokenizer.nextToken();
                        Word word= new Word(w);
                        Project4.unsortedList.add(word);
                        Project4.sortedList.put(word, w);
                    }
                    line= br.readLine();
                }

            }catch(IOException ex){

            }
            /**
             * adds array list and tree map from main file to word gui
             */
            Project4.wordgui.fillGUI(Project4.unsortedList,Project4.sortedList);
        }else{
            JOptionPane.showMessageDialog(null, "Open File Dialog Cancelled");

        }

    }
}
