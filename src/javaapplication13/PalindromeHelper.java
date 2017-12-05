
package javaapplication13;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author cadelmonterde
 */
public class PalindromeHelper {

    LinkedList<String> linkedlist = new LinkedList<>();
    LinkedList<String> aLL = new LinkedList<>();
    public boolean test() {
//        readFrom();
        linkedlist = reverseAndClose(aLL);
        boolean state = isEqual(aLL, linkedlist);
        if (!state) {
            return false;
        } else {
            return true;
        }
    }

    public LinkedList<String> reverseAndClose(LinkedList<String> inputLL) {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0, j = inputLL.size() - 1; i < inputLL.size(); i++, j--) {
            list.add(i, inputLL.get(j));
        }

        return list;
    }

    public boolean isEqual(LinkedList<String> aLL1, LinkedList<String> aLL2)
    {
        for(int i =0; i < aLL1.size(); i++)
        {
            if(!aLL1.get(i).equals(aLL2.get(i)))
            {
                return false;
            }
        }
        return true;
    }
    
    public void isPalindrome() {
        boolean flag = false;

        File myFile;
        Scanner inFile = null;
        String word;
        LinkedList<String> possiblePal;
       // HelperPal myPalHelp = new HelperPal();
        Scanner scan = new Scanner(System.in);
        while (!flag) {
            try {
                System.out.println("Please input the file name");
                String fileName = scan.next();
                myFile = new File(fileName);
                flag = true;
                //myFile = new File("candidates.txt");
                inFile = new Scanner(myFile);
                while (inFile.hasNext()) {
                    word = inFile.next();
                    possiblePal = makeLinkedList(word);
                    aLL = possiblePal;
                    if (test()) {
                        System.out.println(word + " is a Palindrome.");

                    } else {
                        System.out.println(word + " is NOT a Palindrome.");
                    }

                }

            } catch (IOException e) {
                flag = false;
                System.out.println("Sorry, wrong file.  Come back later.");
            } finally {
                if (inFile != null) {
                    inFile.close();
                }
            }
        }

    }

    public static LinkedList<String> makeLinkedList(String word) {

        LinkedList<String> list = new LinkedList();
        for (int i = 0; i < word.length(); i++) {
            list.add(String.valueOf(word.charAt(i)));
        }
        return list;
    }

}
