/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

/**
 *
 * @author HP
 */
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Oop {
        private static int choice;
         
	private static ArrayList<String> dict=new ArrayList<>();
        private static ArrayList<String> words;
        private static  Scanner x;
        private static String word ;
	private static String asterisk;
        private static int count = 0;
        
        Oop()
        {
            count=0;
            openFile();
            words=readFile(dict);
            word = words.get((int)(Math.random()*words.size()));
            asterisk = new String(new char[word.length()]).replace("\0", "*");
            
        }
        public void openFile()
        {
            try{
                x=new Scanner(new File("temp2.txt"));
            }
            catch(Exception e)
            {
                System.out.println("Sorry File does not exist\n");
            }
        }
        private static ArrayList<String> readFile(ArrayList<String> dict)
        {
                while(x.hasNext())
                {      
                  dict.add(x.nextLine());
                }
                return dict;
            }        
        public static void closeFile()
        {
            x.close();
        }    
      
	public static void main(String[] args) {
           
            do{
            System.out.println("\t\t\tWelcome to Hangman Game.In this game you have to guess the country name before you run out of chances!\n");
            Oop obj= new Oop();
            Scanner sc = new Scanner(System.in);
                
		while (count < 7 && asterisk.contains("*")) {
			System.out.println("Guess any letter in the word");
			System.out.println(asterisk);
			char guess = sc.next().charAt(0);
			hang(guess);
		} 
                closeFile();  
                Scanner ch=new Scanner (System.in);
               System.out.println("Do you Want to Play Again(1/0)?");
                choice=ch.nextInt();
           }while(choice==1);
           System.out.println("\n\t\t\tThank you for Playing!");
           
	}
       
       
	
	public static void hang(char guess) {
		String newasterisk = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess) {
				newasterisk += guess;
			} else if (asterisk.charAt(i) != '*') {
				newasterisk += word.charAt(i);
			} else {
				newasterisk += "*";
			}
		}

		if (asterisk.equals(newasterisk)) {
			count++;
			hangmanImage();
		} else {
			asterisk = newasterisk;
		}
		if (asterisk.equals(word)) {
			System.out.println("Correct! You win! The word was " + word);
		}
	}

	public static void hangmanImage() {
		if (count == 1) {
                        
			System.out.println("Wrong guess, try again.Chances remaining are "+(7-count));
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println();
		}
		if (count == 2) {   
                       
			System.out.println("Wrong guess, try again.Chances remaining are "+(7-count));
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 3) {
                     
			System.out.println("Wrong guess, try again.Chances remaining are "+(7-count));
			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (count == 4) {
                         
			System.out.println("Wrong guess, try again.Chances remaining are "+(7-count));
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 5) {
                       
			System.out.println("Wrong guess, try again.Chances remaining are "+(7-count));
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 6) {   
                       
			System.out.println("Wrong guess, try again.Chances remaining are "+(7-count));
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
		}
		if (count == 7) {   
                      
			System.out.println("GAME OVER!");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
			System.out.println("GAME OVER! The word was " + word);
		}
	}

        
        }
