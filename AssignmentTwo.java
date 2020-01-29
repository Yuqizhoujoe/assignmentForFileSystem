package com.example.java;
import java.io.*;

/**
 * Created by JOE on
 **/
public class AssignmentTwo {

    public static void changeOccurence(String filePath, String oldString) throws IOException {

        File f = new File(filePath);

        BufferedReader reader = null;
        FileWriter writer = null;

        try {

            reader = new BufferedReader(new FileReader(f));
            // reading all the lines
            String line = reader.readLine();
            String s = "";
            while (line != null) {
                s = s + line + "\n";
                line = reader.readLine();
            }
            // replacing oldString with newString in the String s
            String newStr = s.replaceAll(oldString, oldString.toUpperCase());
            // rewriting the input text file with newStr
            writer = new FileWriter(f);
            writer.write(newStr);
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static void main(String args[]) throws IOException {
        AssignmentTwo.changeOccurence("file/Student.txt", "hello");
    }
}
