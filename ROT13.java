//Kristy Carpenter, Computer Science II, Fall 2014, Section C (4th period)
//Assignment 3--ROT13 option
//
//This program takes one line of user input and encrypts it using the ROT-13 cipher, which takes
//each letter (but not any other character) and rotates it by 13 places in the alphabet (a goes to
//n, b goes to o, etc.) This program also checks the encryped string for accuracy, and informs the
//user if the output is correct. This is done efficiently through the use of parameters, returns, a
//scanner, different static methods, if statements, and for loops.

import java.util.*;

public class ROT13
{
   /**
     *This is the main method, where the program begins.
     *@param args
     */   
   public static void main(String[]args)
   {
      Scanner input = new Scanner(System.in);
      intro();
      final String originalString = getOriginalString(input);
      final String encodedString = rotateLetters(originalString);
      final String decodedString = rotateLetters(encodedString);
      printResult(originalString, encodedString, decodedString);
   }
   
   /**
     *This method prints the introductory message that instructs the user on how to use the program
     */
   public static void intro()
   {
      System.out.println("This program encodes a string by rotating the alphabetic characters in a string by 13 places");
      System.out.println("Enter the string you'd like to convert:");
   }
   
   /**
     *This method uses the scanner set up in the main method to get the string to encrypt from the
     *user.
     *@param input - the scanner that takes the user's input
     *@return originalString - the string that must be encrypted, taken from the user's input
     */
   public static String getOriginalString(Scanner input)
   {
      String originalString = input.nextLine();
      return originalString;
   }
   
   /**
     *This method does the actual rotation of the letters. It goes through each character in the
     *string to be encrypted, checking if it is a letter, and if it is, checking if it is uppercase
     *or lowercase. Then, it accordingly adds or subtracts numbers to get the ASCII value of the
     *rotated letter. Once all characters have been rotated (or not, if they aren't letters), the
     *encrypted string is returned.
     *
     *@param stringToConvert - this is whatever string that needs to be put through ROT13
     *@return outputString - this is the string produced after rotating by 13 places. It is built
     *up character by character
     */
   public static String rotateLetters(String stringToConvert)
   {
      int lengthOfString = stringToConvert.length();
      String outputString = "";
      for (int characterCounter = 0; characterCounter < lengthOfString; characterCounter++)
      {
         char currentCharacter = stringToConvert.charAt(characterCounter);
         if ((Character.isLetter(currentCharacter)) == true)
         
         {
            int asciiNumber = (int) currentCharacter;
            if (asciiNumber <= 90) //if uppercase
            {
               if (asciiNumber > 77) //if it has to loop back to A
               {
                  int thisHasBeenSubtracted = 90 - asciiNumber;
                  int newAsciiNumber = 65 + 12 - thisHasBeenSubtracted; //must be 12 instead of 13 since the move to A is 1 already
                  char currentCharacterEncoded = (char) newAsciiNumber;
                  outputString = outputString + currentCharacterEncoded;
               }
               else //the straightforward case
               {
                int newAsciiNumber = asciiNumber + 13;
                char currentCharacterEncoded = (char) newAsciiNumber;
                outputString = outputString + currentCharacterEncoded;
               }
            }
            else //must be lowercase then
            {
               if (asciiNumber > 109) //if it has to loop back to a
               {
                  int thisHasBeenSubtracted = 122 - asciiNumber;
                  int newAsciiNumber = 97 + 12 - thisHasBeenSubtracted; //12 not 13 since the move from z to a is 1
                  char currentCharacterEncoded = (char) newAsciiNumber;
                  outputString = outputString + currentCharacterEncoded;
               }
               else //the straightforward case
               {
                int newAsciiNumber = asciiNumber + 13;
                char currentCharacterEncoded = (char) newAsciiNumber;
                outputString = outputString + currentCharacterEncoded;
               }
            }
         }
         else //if it's not a letter, just add the character to the output string
         {
            outputString = outputString + currentCharacter;
         }
      }
      return outputString; //this is the finished output string
   }
   
   /**
     *This method tells the user what the encrypted string turned out to be. It then checks the
     *accuracy of the encryption by taking the decoded string (the string obtained by putting
     *the encrypted string through ROT13 again, which ideally would be the original string) and
     *checking to see if it is the same as the original string. If they are the same, it tells the
     *user that the conversion was correct. If they are not the same, it tells the user that it was
     *incorrect, and gives the output of running the original string through ROT13 twice.
     *
     *@param originalString - the original string that the user typed
     *@param encodedString - the resulting string after the original string was rotated 13 places
     *@param decodedString - the resulting string after the encrypted string was rotated 13 places
     *(should be the same as the original string)
     */
   public static void printResult(String originalString, String encodedString, String decodedString)
   {
      System.out.println("The encoded string is: " + encodedString);
      System.out.print("The conversion was tested and was ");
      if (originalString.equals(decodedString) == true)
      {
         System.out.println("correct, here's your output: " + decodedString); 
      }
      else
      {
         System.out.println("incorrect. Oh no. Here's what it turned out to be: " + decodedString);
      }
   }
}