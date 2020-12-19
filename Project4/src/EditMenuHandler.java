/**
 * Displays edit menu that is used to search for word in text file
 * Adds words to arraylist, treemap and wordgui
 * @author Alexandra Ali
 * @since 12.09. 2020
 * @version 1.0
 * @returns GUI which shows list of words, one as they appear (unsorted), other as alphabetical (sorted)
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditMenuHandler implements ActionListener {
    JFrame jframe;
    String write_word;
    public EditMenuHandler(JFrame jf){
        jframe = jf;
    }

    /**
     * create option to search through file
     * @param event
     */
    public void actionPerformed(ActionEvent event){
        String menuName = event.getActionCommand();
        /**
         * if word is not in file, display no
         * if word is in file, display yes
         */
        if(menuName.equals("Search")){
            write_word = JOptionPane.showInputDialog(null, "Enter word to search");
        }
        if(Project4.sortedList.containsValue(write_word)){
            JOptionPane.showMessageDialog(null, "Yes, word is in list: " + write_word);
        }
        else{
            JOptionPane.showMessageDialog(null, "No, word is not in list: " + write_word);
        }
    }
}

