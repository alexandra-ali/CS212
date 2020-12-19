/**
 * Create class WordGUI that is grid with 1 row and 2 columns
 * Set appropriate soze and layout
 * Append gui to main class and USWL and SWL classes
 * @author Alexandra Ali
 * @since 11.02. 2020
 * @version 1.0
 * @returns GUI which shows list of words, one as they appear (unsorted), other as alphabetical (sorted)
 */
import javax.swing.*;
import java.awt.*;

public class WordGUI extends JFrame {

    /**
     * create text areas for unsorted and sorted classes
     */
    TextArea unsortedArea;
    TextArea sortedArea;

    public WordGUI(){
        /**
         * set grid layout
         * set title and size
         */
        this.setSize(600,400);
        this.setLayout(new GridLayout(1,2));
        this.setTitle("Project 2");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * initialize text areas
         */
        this.unsortedArea= new TextArea();
        this.sortedArea= new TextArea();
        /**
         * Create and add scroll panes to each text area
         */
        JScrollPane scroll1 = new JScrollPane();
        JScrollPane scroll2 = new JScrollPane();

        scroll1.setViewportView(unsortedArea);
        scroll2.setViewportView(sortedArea);

        this.add(scroll1);
        this.add(scroll2);
        /**
         * make GUI visible to main class when program is executed
         */
        this.setVisible(true);

    }

}
