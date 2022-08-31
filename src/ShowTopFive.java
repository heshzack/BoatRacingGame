import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ShowTopFive extends TestGame {

	public static void filterAndPrintTopFive() throws IOException {
		
//		Filter in ascending order from text file
		BufferedReader reader = new BufferedReader(new FileReader("TopFive.txt"));
		ArrayList<TopFive> playerRecords = new ArrayList<TopFive>();
		String currentLine = reader.readLine();
	    while (currentLine != null) {
	        String[] playerDetail = currentLine.split(" ");
	        String name = playerDetail[0];
	        int mark = Integer.valueOf(playerDetail[1]);
	        playerRecords.add(new TopFive(name, mark));
	        currentLine = reader.readLine();
	    }
	    if ((player1.getPosition() == 99) && (player2.getPosition() == 99)) {
        	System.out.println("Tie");
        	playerRecords.add(new TopFive(player1.getName(), player1.getRound()));
        	playerRecords.add(new TopFive(player2.getName(), player1.getRound()));
        }
        else if (player1.getPosition() == 99) {
        	System.out.println("Player 1 win");
        	playerRecords.add(new TopFive(player1.getName(), player1.getRound()));
        }
        else if (player2.getPosition() == 99) {
        	System.out.println("Player 2 win");
        	playerRecords.add(new TopFive(player2.getName(), player1.getRound()));
        }
	    
//	    Write records into text file
	    Collections.sort(playerRecords, Collections.reverseOrder(new MarksCompare()));
	    BufferedWriter writer = new BufferedWriter(new FileWriter("TopFive.txt"));
	    for (TopFive player: playerRecords) {
	        writer.write(player.name + " " + player.mark + "\n");
	    }
        
	    reader.close();
	    writer.close();
	    
	}
	
	public static void printRecords() throws IOException {
//	    Print top five records
	    Scanner input;
		try {
			input = new Scanner(new File("TopFive.txt"));
			int x = 0;
			while ((input.hasNext()) && (x < 5)) {
				x ++;
				System.out.print(input.nextLine() + "\n");
			}
			if (input != null) {
				input.close();
			}
		}
		catch (FileNotFoundException fe) {
			File file = new File("TopFive.txt");
            file.createNewFile();
		}
		catch (NoSuchElementException ex) {
			System.out.println("File improperly formed.");
		}
	}

}
