
package javaapplication13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author cadelmonterde
 */
public class ReversePoemHelper extends Stack{
Stack <Object> stack = new Stack<>();
    public void readFileLoadStack() {
        File file = new File("thing.txt");
        try {
            Scanner readFile = new Scanner(file);
            while (readFile.hasNext()) {
                String word = readFile.nextLine();
                String[] hold = word.split(" ");
                for (int i = 0; i < hold.length; i++) {
                    // System.out.println(hold[i]);
                    stack.push((Object) hold[i]);
                }
                popStackPrintMsg();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found bruh...");
        }

    }

    public void popStackPrintMsg() {
        String song = "";
        while (!stack.empty()) {
            song += stack.pop() + " ";
        }
        System.out.println(song);
        song = new String();
    }
}
