/**
 * Have program read through a text file. Put all words in file into single array.
 * Then create 2 more arrays which contain valid (only letters) and invalid words (with characters), respectively.
 * Display arrays into a GUI grid with 1 row and 3 columns
 * @author Alexandra Ali
 * @since 10.09. 2020
 * @version 1.0
 * @returns GUI which shows list of words, valid words and invalid words
 */
package com.company;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Read input text file and sort text into 3 arrays, all words, valid words and invalid words
 */
public class Project1 {

    public static void main(String[] args){
        /**
         * Initialize each array (3) and define bound to 500
         * Create and initialize counter to keep track of number of strings added into each array
         */
        String[] fullList= new String[500]; /** array for all words in file */
        String[] validList= new String[500]; /** array for words with only letters */
        String[] invalidList= new String[500]; /** array for words not valid */
        int fullListCount = 0, validListCount = 0,invalidListCount = 0; /** counters for each array set to 0 */
        /** Read .txt file and put into array */
        try{ /** use try and catch to determine 'null' inputs */
            /** Use absolute path for txt file location */
            File file = new File("C:\\Users\\alexa\\IdeaProjects\\Project1\\src\\com\\company\\Project1Input.txt");
            BufferedReader read = new BufferedReader(new FileReader(file)); /** Buffered reader reads through all characters in input efficiently */
            String word = read.readLine(); /** reads each line as string and character */
            while(word !=null){
                /** Use tokenizer to only consider characters part of a word
                 * Each token separated by 'null' (space)
                 */
                StringTokenizer tokenizer = new StringTokenizer(word);
                while(tokenizer.hasMoreTokens()){
                    fullList[fullListCount]= tokenizer.nextToken(); /** Each token accounted for is added to full list array */
                    fullListCount++; /** full list counter increases */
                }
                word = read.readLine(); /** goes through each line of paragraph in text file */
            }
            read.close(); /** closes buffered reader */
            /** catches used to trace and throw exceptions in file reader */
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        /** Sort full array into valid and invalid array */
        for(int i = 0; i<fullListCount; i++){ /** loop goes through each word in full array */
            Boolean isvalid = true; /** initializes validity of word */
            for(int j =0; j< fullList[i].length(); j++){ /** loop goes through each character in word */
                if(!Character.isLetter(fullList[i].charAt(j))){ /** checks if character is a word */
                    isvalid = false;
                }
            }
            if(isvalid){
                validList[validListCount++] = fullList[i]; /** increase count of valid words */
            }else{
                invalidList[invalidListCount++] = fullList[i]; /** increase count of invalid words */
            }
        }
        /** Use selection sort to sort words in order*/
        int lowestIndex= 0;
        for (int i = 0; i< validListCount; i++){
            lowestIndex=i;
            for(int j = i; j< validListCount; j++){
                if(validList[j].compareToIgnoreCase(validList[lowestIndex]) < 0){
                    lowestIndex= j;
                }
            }
            /** Swaps order of words depending on index of the word */
            String temp = validList[i];
            validList[i] = validList[lowestIndex];
            validList[lowestIndex] = temp;
            /** Connect project class to Word GUI class */
            WordGUI gui = new WordGUI();
            /** fill each text area with full list, valid list and invalid list, respectively
             * Done so by going through each word in each array
             */
            for(int a =0; a<fullListCount; a++){
                gui.addToFullListArea(fullList[a] + "\n");
            }
            for(int a =0; a<validListCount; a++){
                gui.addToValid(fullList[a] + "\n");
            }
            for(int a =0; a< invalidListCount; a++){
                gui.addToInvalid(fullList[a] + "\n");
            }
        }
    }




}
