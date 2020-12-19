/**
 * Displays file menu that opens directory and files
 * Does main sorting of words
 * adds words to arraylist and wordgui
 * @author Alexandra Ali
 * @since 11.20. 2020
 * @version 1.0
 * @returns GUI which shows list of words, one as they appear (unsorted), other as alphabetical (sorted)
 */
import javax.swing.*;

import java.awt.event.*;
import java.io.*;
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
            Project3.unsortedList.clear();
            Project3.sortedList.clear();
            Project3.invalidList.clear();
            try{

                /**
                 * gets selected file and reads from it
                 * use string tokenizer to go through each word and add to arraylist
                 * use try/ catch to avoid errors and exceptions
                 */
                File file = FileMenuHandler.chooser.getSelectedFile();

                BufferedReader br= new BufferedReader(new FileReader(file));
                String line = br.readLine();
                StringTokenizer tokenizer;

                while(line!= null){
                    tokenizer= new StringTokenizer(line);
                    while(tokenizer.hasMoreTokens()){
                        Word word= new Word(tokenizer.nextToken());
                        Project3.unsortedList.add(word);
                        Project3.sortedList.add(word);
                    }
                    line= br.readLine();
                }

            }catch(IOException ex){

            }
            /**
             * collections sort, sorts words
             */
            Collections.sort(Project3.sortedList);
            /**
             * adds array lists from main file to word gui
             */
            Project3.wordgui.fillGUI(Project3.unsortedList,Project3.sortedList,Project3.invalidList);
        }else{
            JOptionPane.showMessageDialog(null, "Open File Dialog Cancelled");

        }

    }
}
