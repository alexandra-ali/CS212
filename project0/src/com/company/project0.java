/**
 * Have a user input a sentence. The number of lowercase and uppercase E's are counted and shown to the user.
 * The program is loop and will continue until the user inputs "stop."
 * @author Alexandra Ali
 * @since 9.16. 2020
 * @version 1.0
 * @returns Number of Lowercase and Uppercase E's in a string
 */
package com.company;
import javax.swing.*;

/**
 * Repeat through input strings to count and display number of lowercase and uppercase E's in string.
 */
public class project0 {
    public static void main(String[] args) {

        String inputSent; //declares input as a string

        inputSent = JOptionPane.showInputDialog(null, "Enter a sentence:"); /**lets user input string */
        while(!(inputSent.equalsIgnoreCase("stop"))) { /** while loop iterates until user enters 'stop' */
            int upperE=0, lowerE = 0; /** declare and initialize upper and lower 'E' counters */
            for (int i = 0; i < inputSent.length(); i++) { /** for loop goes through entire string */
                char ch = inputSent.charAt(i); /** retrieves single character from string */
                if (ch == 'e') { /** checks if character is lowercase 'e' */
                    lowerE++; /** increases count if statement is true */
                } else if (ch == 'E') { /** checks if character is uppercase 'E' */
                    upperE++; /** increases count if statement is true */
                }
            }
            /** displays number of lowercase and uppercase e's */
            JOptionPane.showMessageDialog(null, "Number of lower case e's: " + lowerE + "\nNumber of upper case e's: " + upperE);
            inputSent = JOptionPane.showInputDialog(null, "Enter a sentence:"); /** asks user for next input to be checked for while loop to re-iterate */
        } 
    }

}
