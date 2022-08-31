import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
public class TestGame {
	
	public static Player player1 = new Player();
	public static Player player2 = new Player();
	public static River river = new River();
	
	public static void main(String[] args) throws IOException {
		
//		Print records
		ShowTopFive.printRecords();
		
//		Ask user enter name
		int player1Dice, player2Dice;
		boolean repeat = true;
		
		Scanner input = new Scanner(System.in);
		while(repeat) {
			System.out.print("Please enter first player name [Short name with one word only]: ");
			player1.setName(input.nextLine());
			if (player1.getName().equals("n o")) {
				repeat = true;
			}
			else {
				repeat = false;
			}
		}
		
		repeat = true;
		while(repeat) {
			System.out.print("Please enter second player name [Short name with one word only]: ");
			player2.setName(input.nextLine());
			if (player2.getName().equals("n o")) {
				repeat = true;
			}
			else {
				repeat = false;
			}
		}
		
		river.printRiver();
		System.out.println("");
		
//		Looping until one of the player reach exactly 100
		while((player1.getPosition() != 99) && (player2.getPosition() != 99)) {
			player1.setRound(player1.getRound() + 1);
			System.out.println("Player1 currently at position " + (player1.getPosition()+1));
			System.out.println("Player2 currently at position " + (player2.getPosition()+1));
			
			System.out.print("Player1 press \"ENTER\" to roll the dice");
			input.nextLine();
			player1Dice = player1.getDice();
			System.out.println("Player 1 has rolled: " + player1Dice);
			
			System.out.print("Player2 press \"ENTER\" to roll the dice");
			input.nextLine();
			player2Dice = player2.getDice();
			System.out.println("Player 2 has rolled: " + player2Dice);
			System.out.println("");
			
			player1.setPosition(player1.getPosition() + player1Dice);
			player2.setPosition(player2.getPosition() + player2Dice);
			river.printRiver();
			System.out.println("");
		}
		
//		Write records into text file
		ShowTopFive.filterAndPrintTopFive();
		
		System.out.println("Rerun program to see your ranking");

		input.close();
	}

}
