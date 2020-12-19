/**
 * Create WordGUI class that displays unsorted, sorted and invalid words.
 * @author Alexandra Ali
 * @since 12.09. 2020
 * @version 1.0
 * @returns GUI which shows list of words, one as they appear (unsorted), other as alphabetical (sorted)
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class WordGUI extends JFrame {
    static JFrame jframe;
    TextArea unsortedArea;
    TextArea sortedArea;

    public WordGUI(){
        /**
         * Create and Title JFrame
         * set size, location, and gridlayout
         * call filemenu function
         */
        jframe = new JFrame ("Project 3");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,400);
        setLocation  (400,200);
        createFileMenu();
        setLayout(new GridLayout(1,2));

        /**
         * set text areas for sorted and unsorted
         * set different background color for each text area
         * add scroll panes
         */
        this.unsortedArea= new TextArea();
        this.sortedArea= new TextArea();


        this.unsortedArea.setBackground(Color.decode("#60A6A9"));
        this.sortedArea.setBackground(Color.decode("#A96AA6"));

        JScrollPane scroll1 = new JScrollPane();
        JScrollPane scroll2 = new JScrollPane();



        scroll1.setViewportView(unsortedArea);
        scroll2.setViewportView(sortedArea);


        this.add(scroll1);
        this.add(scroll2);

        /**
         * set visibility to true
         */
        setVisible(true);
    }

    private void createFileMenu( ) {
        /**
         * file menu function creates the filemenu
         * add open and quit methods
         */
        JMenuItem item;

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        /**
         * adds filemenuhandler
         */
        FileMenuHandler fmh  = new FileMenuHandler(this);

        item = new JMenuItem("Open");
        item.addActionListener( fmh );
        fileMenu.add( item );

        fileMenu.addSeparator();

        item = new JMenuItem("Quit");
        item.addActionListener( fmh );
        fileMenu.add( item );

        /**
         * create editmenu
         * add editmenuhandler
         * add search method
         */
        JMenu editMenu = new JMenu("Edit");
        EditMenuHandler emh  = new EditMenuHandler(this);
        item = new JMenuItem("Search");
        item.addActionListener(emh);
        editMenu.add(item);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        /**
         * add menu to gui
         */

        setJMenuBar(menuBar);

    }

    public void fillGUI(ArrayList<Word> unsortedList, TreeMap<Word, String> sortedList){
        /**
         * after using filemenu function, add array list for unsorted words into unsorted text area
         */
        this.unsortedArea.setText("");
        for(int i = 0; i< unsortedList.size(); i++){
            this.unsortedArea.append(unsortedList.get(i).w + "\n");
        }
        /**
         * add sortedlist tree map into sorted text area
         * use the key of each entry in tree map to extract the data (value) of each key
         */
        this.sortedArea.setText("");

        Set set = sortedList.entrySet();
        Iterator i = set.iterator();
        Map.Entry <Word, String> me;
        while(i.hasNext()){
            me = (Map.Entry <Word, String>)i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
            this.sortedArea.append(me.getKey().w + "\n");


        }


    }

}
