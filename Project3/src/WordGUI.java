/**
 * Create WordGUI class that displays unsorted, sorted and invalid words.
 * @author Alexandra Ali
 * @since 11.20. 2020
 * @version 1.0
 * @returns GUI which shows list of words, one as they appear (unsorted), other as alphabetical (sorted)
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WordGUI extends JFrame{
    /**
     * Create Jframe and 3 text areas
     */
    static JFrame jframe;
    TextArea unsortedArea;
    TextArea sortedArea;
    TextArea invalidArea;

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
        setLayout(new GridLayout(1,3));

        /**
         * set text areas
         * set different background color for each text area
         * add scroll panes
         */
        this.unsortedArea= new TextArea();
        this.sortedArea= new TextArea();
        this.invalidArea= new TextArea();

        this.unsortedArea.setBackground(Color.decode("#60A6A9"));
        this.sortedArea.setBackground(Color.decode("#A96AA6"));
        this.invalidArea.setBackground(Color.decode("#706AA9"));

        JScrollPane scroll1 = new JScrollPane();
        JScrollPane scroll2 = new JScrollPane();
        JScrollPane scroll3 = new JScrollPane();


        scroll1.setViewportView(unsortedArea);
        scroll2.setViewportView(sortedArea);
        scroll3.setViewportView(invalidArea);

        this.add(scroll1);
        this.add(scroll2);
        this.add(scroll3);
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

        setJMenuBar(menuBar);
        menuBar.add(fileMenu);

    }

    public void fillGUI(ArrayList<Word> unsortedList, ArrayList<Word> sortedList, ArrayList<Word> invalidList){
        /**
         * after using filemenuhandler function, add appropriate arraylists for respective textarea
         */
        this.unsortedArea.setText("");
        for(int i = 0; i< unsortedList.size(); i++){
            this.unsortedArea.append(unsortedList.get(i).w + "\n");
        }

        this.sortedArea.setText("");
        for(int i = 0; i< sortedList.size(); i++){
            this.sortedArea.append(sortedList.get(i).w + "\n");
        }

        this.invalidArea.setText("");
        for(int i = 0; i< invalidList.size(); i++){
            this.invalidArea.append(invalidList.get(i).w + "\n");
        }


    }



}
