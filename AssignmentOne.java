package com.example.java;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by JOE on
 **/
public class AssignmentOne {

    public static void main(String args[]) throws IOException {

        String dirname = "file";
        // create instance d from File class
        File d = new File(dirname);
        // create directory called file
        d.mkdirs();

        // Buffer Stream
        InputStream in = null;
        OutputStream out = null;

        // get the file
        File f = new File("file/Exercise14_15.txt");

        // check if the file exist
        // try and final block
        if (!f.exists()) {
            try {
                // create instance from Random class
                Random rand = new Random();
                // create integer array
                int[] randNum = new int[100];
                // generate 100 integer within bound 100 + 10
                for (int i = 0; i < randNum.length; i++) {
                    randNum[i] = rand.nextInt(100) + 10;
                }
                // try to write the int from interger array into a file called Exercise14_15.txt
                out = new FileOutputStream("file/Exercise14_15.txt");
                for (int i = 0; i < randNum.length; i++) {
                    out.write(randNum[i]);
                }
                // read the file using FileInputStream
                in = new FileInputStream("file/Exercise14_15.txt");
                // get the size
                int size = in.available();
                // create a array to contain the values
                int[] array = new int[size];
                // use loop to fill the values into array
                for (int i = 0; i < size; i++) {
                    array[i] = in.read();
                }
                // sort the array
                Arrays.sort(array);
                // iterate the array
                for (int elem : array) {
                    System.out.print(elem + " ");
                }

            } finally {
                // close the file
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            }

        }

    }

}
