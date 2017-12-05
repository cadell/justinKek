/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import java.util.Scanner;

/**
 *
 * @author cadelmonterde
 */
public class JavaApplication13 {

    /**
     * @param args the command line arguments
     */
    PalindromeHelper myPalindrome = new PalindromeHelper();
    ReversePoemHelper myReversePoem = new ReversePoemHelper();
    AdoptAPetHelper.Demo myAdoptAPet = new AdoptAPetHelper.Demo();
    public static void main(String[] args) {
       
        JavaApplication13 jav = new JavaApplication13();
        jav.mainMenu();
        // TODO code application logic here
/*
1.  Palindrome Tester
2.  Reverse Poem 
3.  Adopt-A-Pet
4.  exit
*/

/*
1.  myPalindrome.isPalindrome()   //the linked list will be created inside the isPalindrome() method, from the user's selection of an input file (good or bad file)
2.  myReversePoem.readFileLoadStack();
3.  myAdoptAPet.displayMenu();
*/


    }
    
    public void mainMenu()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please select an option from the menu");
        System.out.println("1. Palindrome Tester");
        System.out.println("2. Reverse Poem");
        System.out.println("3. Adopt-A-Pet");
        System.out.println("4.Exit");
        int userChoice = scan.nextInt();
        switch(userChoice)
        {
            case 1:
            {
                
                myPalindrome.isPalindrome();
                break;
            }
            case 2:
            {
                
                myReversePoem.readFileLoadStack();
                break;
            }
            case 3:
            {
                
                myAdoptAPet.displayMenu();
                break;
            }
            case 4:
            {
                System.out.println("Exit");
                break;
            }
            default:
            {
                break;
            }
        }
    }
    
}
