
public class Player {
 
	private String name;
	private int round;
	private int position;
	private int dice;
	
	public Player() {
		name = "";
		round = 0;
		position = 0;
	}
	
	public Player(String name, int round, int position, int dice) {
		this.name = name;
		this.round = round;
		this.position = position;
		this.dice = dice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		String[] checkName = name.trim().split(" ");
		if((name.length() > 10) || (name.length() <= 1) || (checkName.length < 1) || (!name.matches("[a-zA-Z]+"))) {
			this.name = "n o";
		}
		else {
			this.name = name;
		}
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public int getPosition() {
		if (position > 99) {
			return position = 99 - (position - 99);
		}
		else if (position < 0) {
			return position = 0 - position;
		}
		else {
			return position;
		}
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getDice() {
		return dice = (int)(Math.random()*6)+1;
	}
	
}
