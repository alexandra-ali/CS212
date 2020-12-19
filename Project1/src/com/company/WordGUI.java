/**
 * Create GUI to display arrays created in Project1 class
 * @author Alexandra Ali
 * @since 10.09. 2020
 * @version 1.0
 * @returns GUI to connect to other class, which shows list of words, valid words and invalid words
 */
package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Create WordGUI with a grid layout
 */
public class WordGUI extends JFrame {
    /** Create three text areas, one for each array */
    JTextArea fullArea;
    JTextArea validArea;
    JTextArea invalidArea;

    /** Styles characteristics of GUI to appropriate measurements and layouts */
    public WordGUI(){
        this.setSize(600, 400);
        this.setTitle("Project 1");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1,3));
        /** creates actual text area */
        fullArea = new JTextArea();
        validArea = new JTextArea();
        invalidArea = new JTextArea();

        /** create scroll bar for each area so that user can scroll through each column individually */
        JScrollPane scrollPane1 = new JScrollPane();
        JScrollPane scrollPane2 = new JScrollPane();
        JScrollPane scrollPane3 = new JScrollPane();

        scrollPane1. setViewportView(fullArea);
        scrollPane2. setViewportView(validArea);
        scrollPane3. setViewportView(invalidArea);
        /** add scroll bar to text area */
        this.add(scrollPane1);
        this.add(scrollPane2);
        this.add(scrollPane3);
        /** Makes GUI visible */
        this.setVisible(true);
    }

    /**
     * create 3 functions for each array in project file
     * each function appends (connects as) as string
     * @param str
     */
    public void addToFullListArea(String str){
        fullArea.append(str);
    }
    public void addToValid(String str){
        validArea.append(str);
    }
    public void addToInvalid(String str){
        invalidArea.append(str);
    }
}
