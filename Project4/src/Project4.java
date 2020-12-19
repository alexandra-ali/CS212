/**
 * Have program open file menu, select and read through a text file.
 * Sort words into unsorted, and sorted words
 * Put words into UnsortedList arraylist and alphabetical SortedWordList, which is a tree map
 * Allow user to search for word if it is in text file.
 * Display classes into a GUI grid with 1 row and 2 columns
 * @author Alexandra Ali
 * @since 12.09. 2020
 * @version 1.0
 * @returns GUI which shows list of words, one as they appear (unsorted), other as alphabetical (sorted)
 */
import java.util.ArrayList;
import java.util.TreeMap;

public class Project4 {


    public static ArrayList<Word> unsortedList = new ArrayList<Word>();
    public static TreeMap <Word, String> sortedList = new TreeMap<Word, String>();
    public static WordGUI wordgui = new WordGUI();

    public static void main(String[] args){


    }
}
