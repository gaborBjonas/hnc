package pontoon;

import java.util.Scanner;

public class pontoon {
	/*
	 * method for game, if the player wins w/o bj return 0, if the player loses w/o bust return 1, if the player gets a blackjack return 2,
	 * if player gets a bust return 3, if a player gets bj but the house also has bj, return 4
	 */
	static int game() { 
			Scanner kekboard = new Scanner(System.in);
			
			//Initialising points
			int housePoints = 0;
			int randomNum = (int)((Math.random() * 11)+1);
			housePoints += randomNum;
			randomNum = (int)((Math.random() * 11)+1);
			housePoints += randomNum;
			int playerPoints = 0;

			//giving player 2 random cards
			randomNum = (int)((Math.random() * 11)+1);
			playerPoints += randomNum;
			System.out.println("You have drawn "+randomNum+" as your first card. The value of your cards is "+playerPoints+"\n");

			randomNum = (int)((Math.random() * 11)+1);
			playerPoints += randomNum;
			System.out.println("You have drawn "+randomNum+" as your second card. The value of your cards is "+playerPoints+"\n");
		   	
			//check for bust / bj in initial hand
			if (playerPoints > 21) {
				return 3;
			} else if (playerPoints == 21) {
				//if its a bj, check if house also has bj
				if (housePoints == playerPoints) {
					return 4;
				} else {
					return 2;
				}
			} else {
				//giving player the option to draw more or show their hands
				System.out.println("Your current score is "+playerPoints+"\n\nIf you want to draw more, type draw, if you want to show your cards, type show!");
				
				String drawOrShow = kekboard.nextLine();
				drawOrShow = drawOrShow.toLowerCase();
				
				while (drawOrShow.equals("draw")) {
					randomNum = (int)((Math.random() * 11)+1);
					playerPoints += randomNum;
					System.out.println("You've chosen to draw another card: "+randomNum);
					System.out.println("\nYour current score is "+playerPoints);
					//after they have drawn a new card, check for bj or bust
					if (playerPoints > 21) {
						return 3;
					} else if (playerPoints == 21) {
						if (housePoints == playerPoints) {
							System.out.println("\nThe house's score is "+housePoints+"\n");
							return 4;
						} else {
							System.out.println("The house's score is "+housePoints+"\n");
							return 2;
						}
					} else { 
						//if no bj or bust, offer to draw a card again
						System.out.println("If you want to draw more, type draw, if you want to show your cards, type show!");
						drawOrShow = kekboard.nextLine();
						drawOrShow = drawOrShow.toLowerCase();
					}			
				}
				// when the answer to draw or show becomes not draw, display points and compare them and return the according value to either victory or defeat
				System.out.println("The house's score is "+housePoints+"\nYour score is "+playerPoints);
				if (playerPoints > housePoints) {
					return 0;
				} else {
					return 1;
				}
			}
	}
	
	public static void main(String[] args) {
        
	    Scanner kekboard = new Scanner(System.in);
	    
	    //start of menu
	    System.out.println("To play, press 1, to read the rules first, press 2!");	  // intro, user has to chose whether they want to play straight away or see the rules first
	    int menuchoice = kekboard.nextInt();
	    kekboard.nextLine();  // consume /n 
	    int result=0;

	    if (menuchoice == 1) {
	    	// game starts straight off when choosing to play
	    	result = game();   
	    } else if (menuchoice == 2) {   
	    	// otherwise user gets presented with rules, upon agreeing the game will start, else the program will stop
	    	System.out.println("The rules are the following:"
	    			+ "\n1. Both the house and the player draw 2 cards from the deck, the player can only see their own cards."
	    			+ "\n2. The value of cards will be the face value from 1-11."
	    			+ "\n3. After the initial draw, the player can either ask the house to show their cards, in which case skip to rule no5., or the player can ask to draw more cards."
	    			+ "\n4. The player can draw as many cards as they want, but if they reach a score of 21 they will automatically show their hands, or if they reach more than 21 they get a bust and they lose."
	    			+ "\n5. When the player decides to show, both the player and the house's cards will be revealed, whoever has the closer score to 21 will win. When there is a draw between the numbers(unless both players have blackjack), the house wins."
	    			+ "\n6. If the house has blackjack at the same time as the player, it's a draw.");
	    	System.out.println("if you agree to the rules type yes");
	    	String kontinue = kekboard.nextLine();
	    	if (kontinue.equals("yes")) {	    		
	    		result = game();	    			    		
	    	} else {    		
	    		System.out.println("You did not agree to the rules. The program is now shutting down.");
	    	}
	    }
	    //end of menu
	    
	    //score display and looping to restart the program after finishing
	    boolean repeat = true;
	    while (repeat == true) {
	    	if (result == 0) {
		    	System.out.println("You won. Press 1 to play again, press 2 to exit.");
		    	int playAgain = kekboard.nextInt();
			    kekboard.nextLine();  // consume /n
			    if(playAgain == 1) {
			    	result = game();
				} else {
					repeat = false;
					System.out.println("The program is now shutting down");
				}
		    } else if (result == 1) {
		    	System.out.println("You lost. Press 1 to play again, press 2 to exit.");
		    	int playAgain = kekboard.nextInt();
			    kekboard.nextLine();  // consume /n
			    if(playAgain == 1) {
			    	result = game();
				} else {
					repeat = false;
					System.out.println("The program is now shutting down");
				}
		    } else if (result == 2) {
		    	System.out.println("Blackjack, you won. Press 1 to play again, press 2 to exit.");
		    	int playAgain = kekboard.nextInt();
			    kekboard.nextLine();  // consume /n
			    if(playAgain == 1) {
			    	result = game();
				} else {
					repeat = false;
					System.out.println("The program is now shutting down");
				}
		    } else if (result == 3) {
		    	System.out.println("Bust, you lost. Press 1 to play again, press 2 to exit.");
		    	int playAgain = kekboard.nextInt();
			    kekboard.nextLine();  // consume /n
			    if(playAgain == 1) {
			    	result = game();
				} else {
					repeat = false;
					System.out.println("The program is now shutting down");
				}
	    	} else {
	    		System.out.println("You got blackjack!, but so does the house! Draw! Press 1 to play again, press 2 to exit.");
		    	int playAgain = kekboard.nextInt();
			    kekboard.nextLine();  // consume /n
			    if(playAgain == 1) {
			    	result = game();
				} else {
					repeat = false;
					System.out.println("The program is now shutting down");
				}
	    	}
	    }

	    kekboard.close();
	}
	
}