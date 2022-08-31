
public class River extends TestGame {

	RiverItem[] riverItem = new RiverItem[100];
	String[] riverItem2 = new String[100];
	int n = (int)(Math.random()*15)+10;
	RiverItem x = new RiverItem();
	
	public River() {
		
		for (int i=0; i<n; i++) { 
			Current c = new Current();
			riverItem[c.getPosition()] = c;
			Trap t = new Trap();
			riverItem[t.getPosition()] = t;
		}
		
	}
	
	public void printRiver() {
		
		int index = 0;
		for (RiverItem r: riverItem) {
			if (r == null) {
				riverItem2[index] = "[ ]";
			}
			else {
				riverItem2[index] = r.getSymbol();
			}
			index ++;
		}
		
		for (int i=0; i<100; i++) {
			if (riverItem2[i] != "[ ]") {
				if ((i == player1.getPosition()) && (i == player2.getPosition())) {
					if (riverItem2[i] == "[C]") {
						int strength = x.getStrength();
						player1.setPosition(player1.getPosition() + strength);
						player2.setPosition(player2.getPosition() + strength);
						riverItem2[i] = "[ ]";
					}
					else if (riverItem2[i] == "[#]") {
						int strength = x.getStrength();
						player1.setPosition(player1.getPosition() - strength);
						player2.setPosition(player2.getPosition() - strength);
						riverItem2[i] = "[ ]";
						i -= strength;
						riverItem2[i] = "[12]";
					}
				}
				else if (i == player1.getPosition()) {
					if (riverItem2[i] == "[C]") {
						int strength = x.getStrength();
						player1.setPosition(player1.getPosition() + strength);
						riverItem2[i] = "[ ]";
					}
					else if (riverItem2[i] == "[#]") {
						int strength = x.getStrength();
						player1.setPosition(player1.getPosition() - strength);
						riverItem2[i] = "[ ]";
						i -= strength;
						riverItem2[i] = "[1]";
					}
				}
				else if (i == player2.getPosition()) {
					if (riverItem2[i] == "[C]") {
						int strength = x.getStrength();
						player2.setPosition(player2.getPosition() + strength);
						riverItem2[i] = "[ ]";
					}
					else if (riverItem2[i] == "[#]") {
						int strength = x.getStrength();
						player2.setPosition(player2.getPosition() - strength);
						riverItem2[i] = "[ ]";
						i -= strength;
						riverItem2[i] = "[2]";
					}
				}
				else {
					continue;
				}
			}
			else {
				if ((i == player1.getPosition()) && (i == player2.getPosition())) {
					riverItem2[i] = "[12]";
				}
				else if (i == player1.getPosition()) {
					riverItem2[i] = "[1]";
				}
				else if (i == player2.getPosition()) {
					riverItem2[i] = "[2]";
				}
				else {
					riverItem2[i] = "[ ]";
				}
			}
		}
		
		for (int i=0; i<100; i++) {
			System.out.print(riverItem2[i]);
		}
		
	}
		
	
}
